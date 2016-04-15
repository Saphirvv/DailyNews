package com.saphir.test.dailynews.viewModel;

import android.os.Bundle;

import com.saphir.test.dailynews.model.News;

import java.util.List;

/**
 * 首页 - UI显示
 * Created by Saphir
 * on 2016/4/5.
 */
public interface MainView {
    //加载条显示
    void showProgress();

    void hideProgress();

    /**
     * listView配置
     *
     * @param news 新闻列表
     */
    void setItems(List<News> news);

    /**
     * 发toast
     *
     * @param message toast的内容
     * @param time    toast的长度，0为short，1为long
     */
    void showMessage(String message, int time);

    /**
     * 进入详情页
     *
     * @param b 需要传递的参数
     *          i.extra包括新闻详情（News）新闻列表（List<News>)及当前位置(int)
     */
//    void intoDetail(Bundle b);

    /**
     * 得到存储了点击事件里的（具体）新闻数据的bundle
     *
     * @param position 当前点击的位置
     * @return 包含具体新闻数据的bundle
     */
//    Bundle setBundle(int position);

    /**
     * 得到存储了当前已解析的所有新闻数据的List的bundle
     * @return 包含所有新闻数据的bundle
     *
     * 难以传递list或者list<object>
     */
//    Bundle setBundle();

    /**
     * 通过接口得到需要读取的rss的url地址
     *
     * @return url数据
     */
    String getUrl();
}
