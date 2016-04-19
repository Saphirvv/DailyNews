package com.saphir.test.dailynews.Detail;

import android.databinding.BindingAdapter;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.utils.FormatUtil;

/**
 * Created by Saphir
 * on 2016/4/15.
 */
public class DetailViewModel {
    private static final int TITLE_MAX = 24;

    private News mNews;

    public DetailViewModel(News news) {
        mNews = news;
    }

    public String getTitle() {
        return FormatUtil.lengthFormat(mNews.getN_title(), TITLE_MAX);
    }

    public String getUrl() {
        return mNews.getN_href();
    }

    @BindingAdapter({"bind:webUrl"})
    public static void webLoader(WebView wv, String url) {
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        wv.setHorizontalFadingEdgeEnabled(false);
        wv.setVerticalScrollBarEnabled(false);

        WebSettings ws = wv.getSettings();
        ws.setBuiltInZoomControls(true);
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        ws.setUseWideViewPort(true);// able to zoomIn & zoomOut

        wv.loadUrl(url);
    }
}
