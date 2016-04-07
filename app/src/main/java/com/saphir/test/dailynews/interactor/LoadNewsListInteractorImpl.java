package com.saphir.test.dailynews.interactor;

import android.util.Log;

import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.utils.RSSAnalyze.RSSFeed;
import com.saphir.test.dailynews.utils.RSSAnalyze.RSSHandler;
import com.saphir.test.dailynews.utils.RSSAnalyze.RSSItem;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.net.HttpURLConnection;
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

    private RSSFeed mFeed = null;
    private String rssUrl = "";//获取rss的地址

    public LoadNewsListInteractorImpl(String rss_url) {
        this.rssUrl = rss_url;
        Log.e(TAG, "---------url————————" + rssUrl);
    }

    @Override
    public void loadItems(onFinishedListener listener) {
        listener.onFinished(loadRSSFeed());
    }

    /**
     * 通过url获得xml并解析xml内容为RSSFeed对象
     *
     * @param u rss的地址
     * @return RSSFeed对象
     */
    private RSSFeed getFeed(String u) {
        StringBuilder buffer = new StringBuilder();
        Log.e(TAG, "getFeed()***---------begin!!");
        try {
            Log.e(TAG, "getFeed()***----catch begin  ~~get111");
            URL url = new URL(u);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            URLConnection connection = url.openConnection();
//            int response = connection.getResponseCode();
            Log.e(TAG, "getFeed()***----catch begin  ~~get111CONNECT");
            InputStream inputStream = connection.getInputStream();//FAIL!!!
            Log.e(TAG, "getFeed()***----catch begin  ~~get111INPUT");

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            RSSHandler handler = new RSSHandler();
            reader.setContentHandler(handler);
            Log.e(TAG, "getFeed()***----catch begin  ~~get222");
//            InputSource is = new InputSource(url.openStream());//FAIL!!!
            InputSource is = new InputSource(inputStream);
            Log.e(TAG, "getFeed()***----catch begin  ~~get333");
            reader.parse(is);

            Log.e(TAG, "getFeed()***----catch end");
            return handler.getRSSFeed();
        } catch (Exception e) {
            Log.e(TAG,"getFeed()***----catch null" + e.getMessage());
            return null;
        }
    }

    /**
     * 将RSSFeed对象加载为ArrayList对象
     *
     * @return 可用来显示的ArrayList对象
     */
    private List<News> loadRSSFeed() {
        List<Map<String, String>> newsData = new ArrayList<>();
        List<News> l = new ArrayList<News>();
        News news = null;

        mFeed = getFeed(rssUrl);
        if (mFeed != null) {
            newsData = mFeed.getAllItemsForListView();
            int size = newsData.size();
            for (int i = 0; i < size; i++) {
                news.setN_title(newsData.get(i).get(RSSItem.TITLE));
                news.setN_abstract(newsData.get(i).get(RSSItem.ABSTRACT));
                news.setN_href(newsData.get(i).get(RSSItem.LINK));
                l.add(news);
            }

            Log.e(TAG, "******loadRSSFeed()*-----success!!");
        } else {

            Log.e(TAG,"******loadRSSFeed()*------FAIL!!");
        }
        return l;
    }
}
