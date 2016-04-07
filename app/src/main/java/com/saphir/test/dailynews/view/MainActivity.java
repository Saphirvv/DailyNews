package com.saphir.test.dailynews.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.saphir.test.dailynews.presenter.MainPresenter;
import com.saphir.test.dailynews.presenter.MainPresenterImpl;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.model.NewsListAdapter;
import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.utils.ToastUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    private ProgressBar pb;
    private ListView mNewsList;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenterImpl(this);

        initUI();
    }

    private void initUI() {
        mNewsList = (ListView) findViewById(R.id.news_list);
        pb = (ProgressBar) findViewById(R.id.loading_pb);

        mNewsList.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.onResume();
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
        NewsListAdapter nAdapter = new NewsListAdapter(this, news);
        mNewsList.setAdapter(nAdapter);
    }

    @Override
    public void showMessage(String message) {
        ToastUtil.showShort(this, message);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mMainPresenter.onItemClicked(position);
    }
}
