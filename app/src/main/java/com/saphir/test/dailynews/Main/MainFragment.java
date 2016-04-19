package com.saphir.test.dailynews.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.utils.ToastUtil;
import com.saphir.test.dailynews.utils.decoration.DividerLinearItemDecoration;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Saphir
 * on 2016/4/19.
 */
public class MainFragment extends Fragment implements MainContract.View {

    private RecyclerView mNewsList;
    private MainContract.Presenter mPresenter;

    public MainFragment() {
        //an empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initUI() {
        mNewsList = (RecyclerView) getActivity().findViewById(R.id.news_list);
    }

    @Override
    public void setItems(List<News> news) {
        NewsRVAdapter rvAdapter = new NewsRVAdapter(this.getActivity(), news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mNewsList.setLayoutManager(layoutManager);
        mNewsList.setItemAnimator(new DefaultItemAnimator());
        mNewsList.addItemDecoration(new DividerLinearItemDecoration(this.getActivity(), DividerLinearItemDecoration.VERTICAL_LIST));
        mNewsList.setAdapter(rvAdapter);
    }

    @Override
    public void showMessage(String message, int time) {
        switch (time) {
            case 0:
                ToastUtil.showShort(this.getActivity(), message);
                break;
            case 1:
                ToastUtil.showLong(this.getActivity(), message);
                break;
        }
    }

    @Override
    public String getUrl() {
        return null;
    }


    //
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mMainPresenter.start();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mMainPresenter.onDestroy();
//    }
//
//    @Override
//    public void setItems(List<News> news) {
//
//        NewsRVAdapter rvAdapter = new NewsRVAdapter(this, news);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        mNewsList.setLayoutManager(layoutManager);
//        mNewsList.setItemAnimator(new DefaultItemAnimator());
//        mNewsList.addItemDecoration(new DividerLinearItemDecoration(this, DividerLinearItemDecoration.VERTICAL_LIST));
//        mNewsList.setAdapter(rvAdapter);
//
////        this.m_listNews = news;
//    }
//
}
