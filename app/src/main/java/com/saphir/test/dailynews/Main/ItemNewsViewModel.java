package com.saphir.test.dailynews.Main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.Detail.DetailActivity;

/**
 * Created by Saphir
 * on 2016/4/14.
 */
public class ItemNewsViewModel extends BaseObservable {

    private News mNews;
    private Context mContext;

    public ItemNewsViewModel(News news, Context context) {
        mNews = news;
        mContext = context;
    }

    public void onItemClick(View view) {
        mContext.startActivity(DetailActivity.launchDetail(view.getContext(), mNews));
    }

    /**
     * 若已有此ViewModel，不新建，自刷新
     *
     * @param news 新闻实体
     */
    public void setNews(News news) {
        mNews = news;
        notifyChange();
    }
}