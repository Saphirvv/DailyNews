package com.saphir.test.dailynews.model;

/**
 * News实体类
 * Created by Saphir
 * on 2016/4/5.
 */
public class News {
    public static final String TITLE = "n_title";
    public static final String ABSTRACT = "n_abstract";
    public static final String CONTENT = "n_content";
    public static final String HREF = "n_href";

    String n_title;
    //    String n_time;
    String n_abstract;
    String n_content;
    String n_href;

    //constructor
    public News(String title, String abs, String href) {
        this.n_title = title;
        this.n_abstract = abs;
        this.n_href = href;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_abstract() {
        return n_abstract;
    }

    public void setN_abstract(String n_abstract) {
        this.n_abstract = n_abstract;
    }

    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }

    public String getN_href() {
        return n_href;
    }

    public void setN_href(String n_href) {
        this.n_href = n_href;
    }
}
