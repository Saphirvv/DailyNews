package com.saphir.test.dailynews.Detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.saphir.test.dailynews.R;
import com.saphir.test.dailynews.model.News;
import com.saphir.test.dailynews.utils.ActivityUtils;

/**
 * Created by Saphir
 * on 2016/4/5.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NEWS = "extra_news";

//    private ActivityDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        binding = DataBindingUtil.setContentView(this, R.layout.detail_fragment);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);//can turn back

        // Get the requested news detail
        News news = (News) getIntent().getSerializableExtra(EXTRA_NEWS);

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (detailFragment == null) {
            detailFragment = DetailFragment.newInstance(news);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), detailFragment, R.id.contentFrame);
        }

    }

    public static Intent launchDetail(Context context, News news) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_NEWS, news);

        return intent;
    }

    //turn back
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
