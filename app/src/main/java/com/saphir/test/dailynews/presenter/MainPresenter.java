package com.saphir.test.dailynews.presenter;

/**
 * 首页 - 业务逻辑
 * Created by Saphir
 * on 2016/4/5.
 */
public interface MainPresenter {
    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
