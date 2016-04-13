package com.saphir.test.dailynews.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.databinding.ActivityDetailBinding;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.presenter.DetailPresenter;
import com.saphir.test.dailynews.presenter.DetailPresenterImpl;

import java.util.List;

/**
 * 新闻详情页
 * Created by Saphir
 * on 2016/4/5.
 */
public class DetailActivity extends AppCompatActivity implements DetailView, View.OnClickListener {

    private TextView tv_detail_title;
    private WebView wv_detail_show;
    private ProgressBar pb_load;

    private DetailPresenter mDetailPresenter;
    private ActivityDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        mDetailPresenter = new DetailPresenterImpl(this);

        initUI();
    }

    private void initUI() {
        tv_detail_title = (TextView) findViewById(R.id.detail_tv_title);
        wv_detail_show = (WebView) findViewById(R.id.detail_wv_show);
        pb_load = (ProgressBar) findViewById(R.id.loading_pb_detail);

        findViewById(R.id.detail_iv_back).setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        pb_load.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pb_load.setVisibility(View.GONE);
    }

    @Override
//    @BindingAdapter({"bind:web_url"})//若检测到传入的数据是string值，就会传到方法里
    public void setWebView(String url) {
        wv_detail_show.setWebViewClient(new WebViewClient());
        wv_detail_show.setHorizontalFadingEdgeEnabled(false);
        wv_detail_show.setVerticalScrollBarEnabled(false);

        WebSettings ws = wv_detail_show.getSettings();
        ws.setBuiltInZoomControls(true);// 隐藏缩放按钮
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 排版适应屏幕
        ws.setUseWideViewPort(true);// 可任意比例缩放
        ws.setLoadWithOverviewMode(true);// setUseWideViewPort方法设置webview推荐使用的窗口。setLoadWithOverviewMode方法是设置webview加载的页面的模式。
        ws.setTextZoom(120);

        wv_detail_show.loadUrl(url);
    }

//    @Override
//    public void setNewsTitle(String title) {
//        tv_detail_title.setText(title);
//    }

    @Override
    public void backToHome() {
        this.finish();
    }

    @Override
    public News getBundle() {
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String nTitle = b.getString(News.TITLE);
        String nHref = b.getString(News.HREF);

        return new News(nTitle, null, nHref);
    }

    @Override
    public List<News> getListNews() {
        Intent i = getIntent();
        return (List<News>) i.getSerializableExtra(MainActivity.LISTTRANS);
    }

    @Override
    public void setBinding(News news) {
        News n = news;
        binding.setNews(n);
//        binding.setWebUrl(n.getN_href());
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
}
