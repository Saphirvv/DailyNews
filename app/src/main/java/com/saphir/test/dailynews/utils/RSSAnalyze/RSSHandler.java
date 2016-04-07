package com.saphir.test.dailynews.utils.RSSAnalyze;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 对一个RSS进行xml解析
 * Created by Saphir
 * on 2016/4/6.
 */
public class RSSHandler extends DefaultHandler {

    RSSFeed mRSSFeed;//保存解析过程中的channel
    RSSItem mRSSItem;//保存解析过程中的item

    String lastElementName = "";//标记变量，用于标记在解析过程中我们关心的几个标签，若不是我们关心的标签，记做 0
    final int RSS_TITLE = 1;//若是title标签,记做 1,注意有两个title,但我们都保存在item的title成员变量中
    final int RSS_LINK = 2;//若是link标签,记做 2
    final int RSS_DESCRIPTION = 3;//若是description标签,记做 3
    //    final int RSS_CATEGORY = 4;//若是category标签,记做 4
    int currentState = 0;

    public RSSHandler() {
    }

    /**
     * 通过这个方法把解析结果封装在 RSSFeed 对象中并返回
     *
     * @return 解析后的 RSSFeed 对象
     */
    public RSSFeed getRSSFeed() {
        return mRSSFeed;
    }

    private StringBuilder mStringBuilder = new StringBuilder();

    //以下通过重载 DefaultHandler 的 5 个方法来实现 sax 解析
    @Override
    public void startDocument() throws SAXException {
        //这个方法在解析 xml 文档的一开始执行,一般我们需要在该方法中{初始化}解析过程中有可能用到的变量
        mRSSFeed = new RSSFeed();
        mRSSItem = new RSSItem();

        Log.e("RSS", "---------start---Document————————");
    }

    @Override
    public void endDocument() throws SAXException {
        //这个方法在整个 xml 文档解析结束时执行,一般需要在该方法中返回或保存整个文档解析解析结果
        //由于我们已经在解析过程中把结果保持在 rssFeed 中,所以这里什么也不做
        Log.e("RSS", "---------end---Document————————");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //开始收集新的标签的数据时，先清空历史数据
        mStringBuilder.setLength(0);

        //这个方法在解析标签开始标记时执行,一般我们需要在该方法取得标签属性值
        //由于我们的 rss 文档中并没有任何我们关心的标签属性,因此我们主要在这里进行的是设置标记变量 currentState
        //以标记我们处理到哪个标签
        if (localName.equals("channel")) {
            //channel这个标签没有任何值得我们关心的内容，所以 currentState 置为0
            currentState = 0;
            return;
        }
        if (localName.equals("item")) {
            //若是 item 标签,则重新构造一个 RSSItem ,并把已有(已经解析过的) item 数据扔掉
            //扔掉的数据事先是已经保存到 rssFeed 的 itemList 集合中了
            mRSSItem = new RSSItem();
            return;
        }
        if (localName.equals("title")) {
            //若是 title 标签,设 currentState 为1,表明这是我们关心的数据
            //在 characters 方法中会把元素内容保存到 rssItem 变量中
            currentState = RSS_TITLE;
            return;
        }
        if (localName.equals("link")) {
            //若是 link 标签,置 currentState 为2,表明这是我们关心的数据
            //在 characters 方法中会把元素内容保存到 rssItem 变量中
            currentState = RSS_LINK;
            return;
        }
        if (localName.equals("description")) {
            //若是 description 标签,置 currentState 为3,表明这是我们关心的数据
            //在 characters 方法中会把元素内容保存到 rssItem 变量中
            currentState = RSS_DESCRIPTION;
            return;
        }

        //如果不是上面列出的任何标签,置 currentState 为0,我们不关心
        currentState = 0;
        Log.e("RSS", "---------start---Element————————");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        String value = mStringBuilder.toString();

        switch (currentState) {//根据 currentState 标记判断这个元素体是属于我们关心的哪个元素
            case RSS_TITLE:
                mRSSItem.setRssTitle(value);//若是 title 元素,放入 rssItem 的 title 属性
                currentState = 0;
                break;
            case RSS_LINK:
                mRSSItem.setRssLink(value);
                currentState = 0;
                break;
            case RSS_DESCRIPTION:
                mRSSItem.setRssAbstract(value);
                currentState = 0;
                break;
        }

        //如果解析一个 item 节点结束，就将 rssItem 添加到 rssFeed 中。
        if (localName.equals("item")) {
            mRSSFeed.addItem(mRSSItem);
        }
        Log.e("RSS", "---------END_ ELEMENT!!!————————");
    }

    /**
     * 在解析标签内容(即开始标记－结束标记之间的部分)时执行
     * 我们可在里这获取元素体内容
     *
     * @param ch     字符数组
     * @param start  开始位置
     * @param length 长度
     */
    public void characters(char ch[], int start, int length) throws SAXException {

        super.characters(ch, start, length);
        mStringBuilder.append(ch, start, length);
    }
}
