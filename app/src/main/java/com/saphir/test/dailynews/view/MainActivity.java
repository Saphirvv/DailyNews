package com.saphir.test.dailynews.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.saphir.test.dailynews.decoration.DividerLinearItemDecoration;
import com.saphir.test.dailynews.model.NewsRVAdapter;
import com.saphir.test.dailynews.presenter.MainPresenter;
import com.saphir.test.dailynews.presenter.MainPresenterImpl;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.model.NewsListAdapter;
import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.utils.ToastUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;

public class MainActivity extends AppCompatActivity implements MainView {

    public static final String LISTTRANS = "listSer";
    public static final String LISTPOSTRANS = "listPos";

    private ProgressBar pb;
    //    private ListView mNewsList;
    private RecyclerView mNewsList;
    private MainPresenter mMainPresenter;

    private List<News> m_listNews = new ArrayList<>();
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenterImpl(this);

        initUI();
        mMainPresenter.onCreate();
    }

    private void initUI() {
//        mNewsList = (ListView) findViewById(R.id.news_list);
        mNewsList = (RecyclerView) findViewById(R.id.news_list);
        pb = (ProgressBar) findViewById(R.id.loading_pb);

//        mNewsList.setOnItemClickListener(this);
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
    public void showProgress() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void setItems(List<News> news) {
//        NewsListAdapter nAdapter = new NewsListAdapter(this, news);
//        mNewsList.setAdapter(nAdapter);
//        nAdapter.notifyDataSetChanged();

        NewsRVAdapter rvAdapter = new NewsRVAdapter(this, news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mNewsList.setLayoutManager(layoutManager);
        mNewsList.setItemAnimator(new DefaultItemAnimator());
//        mNewsList.setItemAnimator(new FadeInDownAnimator());
        mNewsList.addItemDecoration(new DividerLinearItemDecoration(this, DividerLinearItemDecoration.VERTICAL_LIST));
        mNewsList.setAdapter(rvAdapter);

        this.m_listNews = news;
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

//    @Override
//    public void intoDetail(Bundle b) {
//        Intent i = new Intent(this, DetailActivity.class);
//        i.putExtras(b);
////        i.putExtra(LISTTRANS, (Serializable) m_listNews);
////        i.putExtra(LISTPOSTRANS, position);
//        startActivity(i);
//    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        mMainPresenter.onItemClicked(position);
//        this.position = position;
//    }

//    @Override
//    public Bundle setBundle(int position) {
//        if (position >= 0) {
//            Bundle b = new Bundle();
//            b.putString(News.TITLE, m_listNews.get(position).getN_title());
//            b.putString(News.HREF, m_listNews.get(position).getN_href());
//
//            return b;
//        } else {
//            return null;
//        }
//    }

    @Override
    public String getUrl() {
        String u = null;
        return u;
    }
}
