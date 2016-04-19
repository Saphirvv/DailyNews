package com.saphir.test.dailynews.Main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.saphir.test.dailynews.utils.decoration.DividerLinearItemDecoration;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.utils.ToastUtil;

import java.util.List;

public class MainActivity extends Activity implements MainContract.View {

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
        setContentView(R.layout.main_fragment);

        initUI();
        mMainPresenter.onCreate();
    }

    private void initUI() {
        mNewsList = (RecyclerView) findViewById(R.id.news_list);
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
//        mMainPresenter = checkNotNull(presenter);
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
