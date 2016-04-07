package com.saphir.test.dailynews.view;

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
    void showMessage(String message);
}
