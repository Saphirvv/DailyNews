package com.saphir.test.dailynews.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.saphir.test.dailynews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页 - 新闻列 adapter
 * Created by Saphir
 * on 2016/4/5.
 */
public class NewsListAdapter extends BaseAdapter {

    Context mContext;
    List<News> mNews = new ArrayList<News>();

    public NewsListAdapter(Context context, List<News> list) {
        this.mContext = context;
        this.mNews = list;
    }

    //显示内容 - 标题和摘要
    private class ViewHolder {
        TextView tv_title;
        TextView tv_abs;
    }

    @Override
    public int getCount() {
        return mNews.size();
    }

    @Override
    public Object getItem(int position) {
        return mNews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_news, null);
            holder.tv_title = (TextView) convertView.findViewById(R.id.news_title);
            holder.tv_abs = (TextView) convertView.findViewById(R.id.news_abstract);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String title_text = mNews.get(position).getN_title();
        String abstract_text = mNews.get(position).getN_abstract();
        holder.tv_title.setText("" + title_text);
        holder.tv_abs.setText("" + abstract_text);
        return convertView;
    }
}
