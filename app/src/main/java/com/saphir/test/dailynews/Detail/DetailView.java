package com.saphir.test.dailynews.Detail;

import android.content.Context;

import com.saphir.test.dailynews.model.News;

/**
 * 详情页 - UI变化
 * Created by Saphir
 * on 2016/4/8.
 */
public interface DetailView {

        void backToHome();

        News getNews();

        void setBinding(News news);

        Context getContext();
}
