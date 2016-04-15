package com.saphir.test.dailynews.viewModel;

import android.content.Context;
import android.webkit.WebView;

import com.saphir.test.dailynews.model.News;

import java.util.Calendar;
import java.util.List;

/**
 * 详情页 - UI变化
 * Created by Saphir
 * on 2016/4/8.
 */
public interface DetailView {
    //加载条显示
    void showProgress();

    void hideProgress();

    //WebView显示配置
//    void setWebView(String url);

    //title显示设置
//    void setNewsTitle(String title);

    //返回首页
    void backToHome();

    //得到页面显示的新闻数据
//    News getBundle();

    //得到整个新闻列表
//    List<News> getListNews();

    News getNews();

    void setBinding(News news);

    Context getContext();
}
