package com.saphir.test.dailynews.view;

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

    //listView配置
    void setItems(List<News> news);

    //测试点击事件
    void showMessage(String message,int time);

    //进入详情页
    void intoDetail(Bundle b);

    //得到存储了点击事件里的新闻数据的bundle
    Bundle setBundle(int position);

    //通过接口得到需要读取的rss的url地址
    String getUrl();
}
