package com.saphir.test.dailynews.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.databinding.ItemNewsBinding;
import com.saphir.test.dailynews.model.News;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 绑定数据到rv的适配器
 * Created by Saphir
 * on 2016/4/14.
 */
public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {

    private List<News> mNewses = new ArrayList<>();
    Context mContext;

    public NewsRVAdapter() {
        this.mNewses = Collections.emptyList();
    }

    public NewsRVAdapter(Context c, List<News> list) {
        mContext = c;
        setList(list);
    }

    public void replaceData(List<News> l) {
        setList(l);
    }

    private void setList(List<News> newses) {
        mNewses = newses;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemNewsBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = ItemNewsBinding.bind(itemView);
        }

        public void bind(@NonNull News news) {
            binding.setNews(news);
            //binding和VM的交互
            if (binding.getNewsVM() == null) {
                binding.setNewsVM(new ItemNewsViewModel(news, itemView.getContext()));
            } else {
                binding.getNewsVM().setNews(news);
            }
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
