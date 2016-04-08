package com.saphir.test.dailynews.view;

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
    void setWebView(String url);

    //title显示设置
    void setNewsTitle(String title);

    //返回首页
    void backToHome();
}
