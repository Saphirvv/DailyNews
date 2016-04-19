package com.saphir.test.dailynews.Main.interactor;

import com.saphir.test.dailynews.model.News;

import java.util.List;

/**
 * 首页 - 读取rss加载新闻列表
 * Created by Saphir
 * on 2016/4/6.
 */
public interface LoadNewsListInteractor {

    /**
     * 监听新闻列表加载完成
     */
    interface onFinishedListener {
        void onFinished(List<News> newsList);
    }

    /**
     * 加载新闻列表
     * @param listener 加载新闻列表的监听
     */
    void loadItems(onFinishedListener listener);
}
