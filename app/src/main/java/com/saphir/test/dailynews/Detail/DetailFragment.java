package com.saphir.test.dailynews.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.databinding.DetailFragmentBinding;
import com.saphir.test.dailynews.model.News;

import org.antlr.v4.runtime.misc.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Saphir
 * on 2016/4/20.
 */
public class DetailFragment extends Fragment implements DetailContract.View {

    public static final String BUNDLE_NEWS = "bundle_news";

    private DetailContract.Presenter mPresenter;
    private DetailFragmentBinding mBinding;

    public DetailFragment() {

    }

    public static DetailFragment newInstance(News news) {
        Bundle b = new Bundle();
        b.putSerializable(BUNDLE_NEWS, news);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(b);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //do the dataBinding with the layout
        View root = inflater.inflate(R.layout.detail_fragment, container, false);
        mBinding = DetailFragmentBinding.bind(root);

        setRetainInstance(true);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        News news = (News) getArguments().getSerializable(BUNDLE_NEWS);

        //setup the binding data
        DetailViewModel detailViewModel = new DetailViewModel(news);
        mBinding.setDetailNews(detailViewModel);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
