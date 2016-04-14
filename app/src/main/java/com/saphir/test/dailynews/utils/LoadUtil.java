package com.saphir.test.dailynews.utils;

import android.databinding.BindingAdapter;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 放置dataBinding相关的加载类
 * BindingAdapter
 * Created by Saphir
 * on 2016/4/14.
 */
public class LoadUtil {

    /**
     * 详情页-webView加载
     *
     * @param wv  网页view
     * @param url 加载地址
     */
    @BindingAdapter({"bind:webUrl"})
    public static void webLoader(WebView wv, String url) {
        wv.setWebViewClient(new WebViewClient());
        wv.setHorizontalFadingEdgeEnabled(false);
        wv.setVerticalScrollBarEnabled(false);

        WebSettings ws = wv.getSettings();
        ws.setBuiltInZoomControls(true);// 隐藏缩放按钮
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);// 排版适应屏幕
        ws.setUseWideViewPort(true);// 可任意比例缩放

        wv.loadUrl(url);
    }
}
