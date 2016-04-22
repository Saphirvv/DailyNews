package com.saphir.test.dailynews.Detail;

import org.antlr.v4.runtime.misc.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Saphir
 * on 2016/4/8.
 */
public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View mdv;

    public DetailPresenter(@NotNull DetailContract.View dv) {
        mdv = checkNotNull(dv, "DetailView cannot bu null!");
        mdv.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {
        mdv = null;
    }


}
