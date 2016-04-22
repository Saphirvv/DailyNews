package com.saphir.test.dailynews.Detail;

import com.saphir.test.dailynews.BasePresenter;
import com.saphir.test.dailynews.BaseView;

/**
 * Created by Saphir
 * on 2016/4/20.
 */
public interface DetailContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void onDestroy();
    }
}
