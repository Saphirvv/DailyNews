package com.saphir.test.dailynews.interactor;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.utils.RSSAnalyze.RSSFeed;
import com.saphir.test.dailynews.utils.RSSAnalyze.RSSHandler;
import com.saphir.test.dailynews.utils.RSSAnalyze.RSSItem;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 首页 - 读取rss加载新闻列表的实现
 * Created by Saphir
 * on 2016/4/6.
 */
public class LoadNewsListInteractorImpl implements LoadNewsListInteractor {
    public static final String TAG = "LoadNewsListInterImpl";
    public static final int SUCCESS = 1;

    private RSSFeed mFeed = null;
    private String rssUrl = "";//获取rss的地址
    private List<News> newList = new ArrayList<>();

    public LoadNewsListInteractorImpl(String rss_url) {
        this.rssUrl = rss_url;
        Log.e(TAG, "---------url————————" + rssUrl);
    }

    @Override
    public void loadItems(onFinishedListener listener) {
        listener.onFinished(loadRSSFeed());
    }

    /**
     * 将RSSFeed对象加载为ArrayList对象
     * 因为需要调用网络，为延时操作，需要开启线程
     *
     * @return 可用来显示的ArrayList对象
     */
    private List<News> loadRSSFeed() {

        Thread thread = new getFeedThread(rssUrl);
        thread.start();
        return newList;
    }

    /**
     * 通过 url 获得 xm l并解析 xml 内容为 RSSFeed 对象
     *
     * @param u rss的地址
     * @return RSSFeed对象
     */
    private RSSFeed getFeed(String u) {
        Log.e(TAG, "getFeed()***---------begin!!");
        try {
            //使用Sax读取网络资源
            URL url = new URL(u);
            //[1]
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            //[2]
            RSSHandler handler = new RSSHandler();
            reader.setContentHandler(handler);
            Log.e(TAG, "getFeed()***----catch begin  ~~get222");
            //[3] 读取网络资源
            InputSource is = new InputSource(url.openStream());//此处为延时操作，需在线程使用
            Log.e(TAG, "getFeed()***----catch begin  ~~get333");
            //[4] 开始解析
            reader.parse(is);

            Log.e(TAG, "getFeed()***----catch end");
            return handler.getRSSFeed();

        } catch (Exception e) {
            Log.e(TAG, "getFeed()***----catch null--the exception is:  " + e.getMessage());
            return null;
        }
    }


    /**
     * 线程，执行包含延时操作的 getFeed() 方法
     */
    class getFeedThread extends Thread {
        String u;

        public getFeedThread(String u) {
            this.u = u;
        }

        public void run() {
            Message message = new Message();
            message.what = SUCCESS;

            mFeed = getFeed(u);
            LoadNewsListInteractorImpl.this.rssLoadHandler.sendMessage(message);
        }
    }

    /**
     * Handler，接收到线程的msg之后进行之后的操作
     */
    Handler rssLoadHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SUCCESS:
                    loadRssHandle();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    /**
     * 将 RSSFeed 对象转化成 News 对象列表
     *
     * @return News 对象列表
     */
    private List<News> loadRssHandle() {
        List<Map<String, String>> newsData;

        if (mFeed != null) {
            newsData = mFeed.getAllItemsForListView();
            int size = newsData.size();
            for (int i = 0; i < size; i++) {
                News news = new News();
                news.setN_title(newsData.get(i).get(RSSItem.TITLE));
                news.setN_abstract(newsData.get(i).get(RSSItem.ABSTRACT));
                news.setN_href(newsData.get(i).get(RSSItem.LINK));
                newList.add(news);
            }

            Log.e(TAG, "******loadRSSFeed()*-----success!!");
        } else {

            Log.e(TAG, "******loadRSSFeed()*------FAIL!!");
        }
        return newList;
    }
}
