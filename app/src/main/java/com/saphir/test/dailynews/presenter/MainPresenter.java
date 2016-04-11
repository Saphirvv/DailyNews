package com.saphir.test.dailynews.presenter;

/**
 * 首页 - 业务逻辑
 * 显示、点击事件（页面跳转）
 * Created by Saphir
 * on 2016/4/5.
 */
public interface MainPresenter {
    void onCreate();

    /**
     * 点击item进入新闻详情页
     * @param position 点击位置
     */
    void onItemClicked(int position);

    void onDestroy();
}
