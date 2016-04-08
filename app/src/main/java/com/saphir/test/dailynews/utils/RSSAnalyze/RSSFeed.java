package com.saphir.test.dailynews.utils.RSSAnalyze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

/**
 * Rss的读取及解析的实现
 * Created by saphir
 * on 2016/4/6.
 */
public class RSSFeed {
//    private String rssTitle = null;
//    private String rssAbstract = null;
//    private String rssLink = null;

    private int itemCount = 0;

    //声明一个RSSItem类型的泛型集合类List对象itemList，用于描述列表item
    private List<RSSItem> itemList;

    /**
     * 构造函数初始化itemList
     */
    public RSSFeed() {
        itemList = new Vector<>();
    }


    public int addItem(RSSItem item) {
        itemList.add(item);
        itemCount++;
        return itemCount;
    }

    public RSSItem getItem(int location) {
        return itemList.get(location);
    }

    public List getAllItems() {
        return itemList;
    }

    public List<Map<String, String>> getAllItemsForListView() {
        List<Map<String, String>> data = new ArrayList<>();
        int size = itemList.size();
        for (int i = 0; i < size; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put(RSSItem.TITLE, itemList.get(i).getRssTitle());
            item.put(RSSItem.ABSTRACT, itemList.get(i).getRssAbstract());
            item.put(RSSItem.LINK, itemList.get(i).getRssLink());
            data.add(item);
        }
        return data;
    }
}
