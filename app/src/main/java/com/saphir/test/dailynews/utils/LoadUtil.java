package com.saphir.test.dailynews.utils;

import android.databinding.BindingAdapter;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 放置dataBinding相关的加载类
 * BindingAdapter
 * Created by Saphir
 * on 2016/4/14.
 */
public class LoadUtil {
    @BindingAdapter({"bind:webUrl"})
    public static void webLoader(WebView wv, String url) {
        wv.setWebViewClient(new WebViewClient());
        wv.setHorizontalFadingEdgeEnabled(false);
        wv.setVerticalScrollBarEnabled(false);
        wv.loadUrl(url);
    }
}
