package com.saphir.test.dailynews.presenter;

import com.saphir.test.dailynews.utils.FormatUtil;
import com.saphir.test.dailynews.view.DetailView;

/**
 * 详情页 - 业务逻辑实现
 * Created by Saphir
 * on 2016/4/8.
 */
public class DetailPresenterImpl implements DetailPresenter {

    //标题所显示的最大字数
    public final static int TITLEMAX = 10;

    private String mUrl = "https://www.baidu.com";

    private DetailView mdv;

    public DetailPresenterImpl(DetailView dv) {
        this.mdv = dv;
    }

    @Override
    public void onResume() {
        if (mdv != null) {
            //getBundle
            //OMG~说是会自己调用，不用手工调。。真的假的
//            mdv.setWebView(mdv.getBundle().getN_href());
//            mdv.setNewsTitle(FormatUtil.lengthFormat(mdv.getBundle().getN_title(), TITLEMAX));
            //NEW-TECH！！dataBinding中定义了标题的变化及格式化
            mdv.setBinding(mdv.getNews());
        }
    }

    @Override
    public void onDestroy() {
        if (mdv != null) {
            mdv = null;
        }
    }

    //点击返回键调用
    @Override
    public void onBackClick() {
        if (mdv != null) {
            mdv.backToHome();
        }
    }

}
