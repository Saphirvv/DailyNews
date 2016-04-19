package com.saphir.test.dailynews.Main;

import com.saphir.test.dailynews.BasePresenter;
import com.saphir.test.dailynews.BaseView;
import com.saphir.test.dailynews.model.News;

import java.util.List;

/**
 * HomePage - contract's implements
 * Created by Saphir
 * on 2016/4/19.
 */
public class MainContract {
    interface View extends BaseView<Presenter> {
        /**
         * Setup RecyclerView
         *
         * @param news the list of News
         */
        void setItems(List<News> news);

        /**
         * Send toast
         *
         * @param message content
         * @param time    how long it shows，0 means short，1 means long
         */
        void showMessage(String message, int time);


        /**
         * get the url address of RSS from the impl which connected to the service
         *
         * @return url
         */
        String getUrl();
    }

    interface Presenter extends BasePresenter {

        void onDestroy();
    }
}
