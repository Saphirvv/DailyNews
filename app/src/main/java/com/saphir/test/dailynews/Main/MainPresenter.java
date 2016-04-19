package com.saphir.test.dailynews.Main;

import android.util.Log;

import com.saphir.test.dailynews.Main.interactor.LoadNewsListInteractor;
import com.saphir.test.dailynews.Main.interactor.LoadNewsListInteractorImpl;
import com.saphir.test.dailynews.model.News;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

/**
 * HomePage - listens to users actions from the UI({@link MainActivity} ,
 * ---------- retrieves the data and updates the UI as required.
 * Created by Saphir
 * on 2016/4/6.
 */
public class MainPresenter implements MainContract.Presenter, LoadNewsListInteractor.onFinishedListener {

    private static final int SHORT = 0;
    private static final int LONG = 1;
    //通过接口得到rss地址
    //This is a MOCK url
    private String mUrl = "http://blog.sina.com.cn/rss/1267454277.xml";

    private MainContract.View mMainView;
    private LoadNewsListInteractor mLoadNewsListInteractor;

    public MainPresenter(@NotNull MainContract.View mv) {
        this.mMainView = mv;
        mMainView.setPresenter(this);
//        if (mv.getUrl() != null) {
//            this.mLoadNewsListInteractor = new LoadNewsListInteractorImpl(mv.getUrl());
//        } else {
//            mv.showMessage("读取新闻失败！请检查网络连接是否成功并重新进入！", LONG);
//        }
        this.mLoadNewsListInteractor = new LoadNewsListInteractorImpl(mUrl);

        Log.e("MainPresenter", "!!!---------loadurl————————");
    }

    @Override
    public void start() {
        Log.e("MainPresenter", "!!!---------START————————");
        mLoadNewsListInteractor.loadItems(this);
    }

    @Override
    public void onDestroy() {
        Log.e("MainPresenter", "!!!---------onDestroy————————");
        mMainView = null;
    }

    @Override
    public void onFinished(List<News> newsList) {
        mMainView.setItems(newsList);
        Log.e("MainPresenter", "---------loadurl———Finished!!—————");
    }


}
