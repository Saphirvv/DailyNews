package com.saphir.test.dailynews.Detail;

/**
 * 详情页 - 业务逻辑实现
 * Created by Saphir
 * on 2016/4/8.
 */
public class DetailPresenterImpl implements DetailPresenter {

    private String mUrl = "https://www.baidu.com";

    private DetailView mdv;

    public DetailPresenterImpl(DetailView dv) {
        this.mdv = dv;
    }

    @Override
    public void onResume() {
        if (mdv != null) {
            mdv.setBinding(mdv.getNews());
        }
    }

    @Override
    public void onDestroy() {
        if (mdv != null) {
            mdv = null;
        }
    }

    //invoke by btn_back
    @Override
    public void onBackClick() {
        if (mdv != null) {
            mdv.backToHome();
        }
    }

}
