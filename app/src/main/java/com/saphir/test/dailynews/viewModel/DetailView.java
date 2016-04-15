package com.saphir.test.dailynews.viewModel;

import android.content.Context;
import android.webkit.WebView;

import com.saphir.test.dailynews.model.News;

import java.util.Calendar;
import java.util.List;

/**
 * 详情页 - UI变化
 * Created by Saphir
 * on 2016/4/8.
 */
public interface DetailView {
        //返回首页
        void backToHome();

        News getNews();

        void setBinding(News news);

        Context getContext();
}
