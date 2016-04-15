package com.saphir.test.dailynews.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.databinding.ActivityDetailBinding;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.presenter.DetailPresenter;
import com.saphir.test.dailynews.presenter.DetailPresenterImpl;
import com.saphir.test.dailynews.viewModel.DetailView;
import com.saphir.test.dailynews.viewModel.DetailViewModel;

/**
 * 新闻详情页
 * Created by Saphir
 * on 2016/4/5.
 */
public class DetailActivity extends AppCompatActivity implements DetailView, View.OnClickListener {

    public static final String EXTRA_NEWS = "extra_news";

    private DetailPresenter mDetailPresenter;
    private ActivityDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        mDetailPresenter = new DetailPresenterImpl(this);

        initUI();
    }

    private void initUI() {

        findViewById(R.id.detail_iv_back).setOnClickListener(this);
    }

    public static Intent launchDetail(Context context, News news) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_NEWS, news);

        return intent;
    }

    @Override
    public void backToHome() {
        this.finish();
    }

    @Override
    public News getNews() {
        Intent i = getIntent();
        News n = (News) i.getSerializableExtra(EXTRA_NEWS);
        return n;
    }

    @Override
    public void setBinding(News news) {
        DetailViewModel detailViewModel = new DetailViewModel(news);
        binding.setDetailNews(detailViewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDetailPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDetailPresenter.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detail_iv_back:
                mDetailPresenter.onBackClick();
                break;
            default:
                break;
        }
    }

    @Override
    public Context getContext() {
        return DetailActivity.this;
    }
}
