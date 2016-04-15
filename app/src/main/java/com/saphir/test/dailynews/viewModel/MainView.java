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
     * 通过接口得到需要读取的rss的url地址
     *
     * @return url数据
     */
    String getUrl();
}
