package com.saphir.test.dailynews.presenter;

import android.util.Log;

import com.saphir.test.dailynews.interactor.LoadNewsListInteractor;
import com.saphir.test.dailynews.interactor.LoadNewsListInteractorImpl;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.view.MainView;

import java.util.List;

/**
 * 首页 - 业务逻辑实现
 * Created by Saphir
 * on 2016/4/6.
 */
public class MainPresenterImpl implements MainPresenter, LoadNewsListInteractor.onFinishedListener {

    //通过接口得到rss地址
    //This is a MOCK url
//    private String mUrl = "http://feeds.bbci.co.uk/news/world/rss.xml";
    private String mUrl ="http://blog.sina.com.cn/rss/1267454277.xml";

    private MainView mMainView;
    private LoadNewsListInteractor mLoadNewsListInteractor;

    public MainPresenterImpl(MainView mv) {
        this.mMainView = mv;
        this.mLoadNewsListInteractor = new LoadNewsListInteractorImpl(mUrl);

        Log.e("MainPresenter", "!!!---------loadurl————————");
    }

    @Override
    public void onCreate() {

        Log.e("MainPresenter", "!!!---------onCreate————————");
        if (mMainView != null) {
            mMainView.showProgress();
            mLoadNewsListInteractor.loadItems(this);
        }
    }

    @Override
    public void onItemClicked(int position) {
        if (mMainView != null) {
//            mMainView.showMessage("you have clicked the " + (position + 1) + " item.");
            mMainView.intoDetail(mMainView.setBundle(position));
        }
    }

    @Override
    public void onDestroy() {

        Log.e("MainPresenter", "!!!---------onDestroy————————");
        mMainView = null;
    }

    @Override
    public void onFinished(List<News> newsList) {
        if (mMainView != null) {
            mMainView.setItems(newsList);
            mMainView.hideProgress();

            Log.e("MainPresenter", "---------loadurl———Finished!!—————");
        }
    }
}
