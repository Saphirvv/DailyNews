package com.saphir.test.dailynews.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.saphir.test.dailynews.decoration.DividerLinearItemDecoration;
import com.saphir.test.dailynews.presenter.MainPresenter;
import com.saphir.test.dailynews.presenter.MainPresenterImpl;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.utils.ToastUtil;
import com.saphir.test.dailynews.viewModel.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements MainView {

    public static final String LISTTRANS = "listSer";
    public static final String LISTPOSTRANS = "listPos";

    private RecyclerView mNewsList;
    private MainPresenter mMainPresenter;

    //    private List<News> m_listNews = new ArrayList<>();
//    private int position = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenterImpl(this);

        initUI();
        mMainPresenter.onCreate();
    }

    private void initUI() {
        mNewsList = (RecyclerView) findViewById(R.id.news_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDestroy();
    }

    @Override
    public void setItems(List<News> news) {

        NewsRVAdapter rvAdapter = new NewsRVAdapter(this, news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mNewsList.setLayoutManager(layoutManager);
        mNewsList.setItemAnimator(new DefaultItemAnimator());
        mNewsList.addItemDecoration(new DividerLinearItemDecoration(this, DividerLinearItemDecoration.VERTICAL_LIST));
        mNewsList.setAdapter(rvAdapter);

//        this.m_listNews = news;
    }

    @Override
    public void showMessage(String message, int time) {
        switch (time) {
            case 0:
                ToastUtil.showShort(this, message);
                break;
            case 1:
                ToastUtil.showLong(this, message);
                break;
        }
    }


    @Override
    public String getUrl() {
        String u = null;
        return u;
    }
}
