package com.saphir.test.dailynews.model;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.databinding.ItemNewsBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 绑定数据到rv的适配器
 * Created by Saphir
 * on 2016/4/14.
 */
public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {

    private List<News> mNewses = new ArrayList<>();
    Context mContext;

    public NewsRVAdapter(Context c, List<News> list) {
        mContext = c;
        mNewses = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemNewsBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = ItemNewsBinding.bind(itemView);
        }

        public void bind(@NonNull News news) {
            binding.setNews(news);
        }
    }

    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsRVAdapter.ViewHolder holder, int position) {
        holder.bind(mNewses.get(position));
    }

    @Override
    public int getItemCount() {
        return mNewses.size();
    }
}
