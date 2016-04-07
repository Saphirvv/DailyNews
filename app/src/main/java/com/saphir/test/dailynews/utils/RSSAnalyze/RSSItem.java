package com.saphir.test.dailynews.utils.RSSAnalyze;

/**
 * RSS里的channel里的item内容项
 * Created by saphir
 * on 2016/4/6.
 */
public class RSSItem {
    public static final String TITLE = "rssTitle";
    public static final String ABSTRACT = "rssAbstract";
    public static final String LINK = "rssLink";

    private String rssTitle = null;
    private String rssAbstract = null;
    private String rssLink = null;

    public RSSItem() {

    }

    public String getRssTitle() {
        return rssTitle;
    }

    public void setRssTitle(String rssTitle) {
        this.rssTitle = rssTitle;
    }

    public String getRssAbstract() {
        return rssAbstract;
    }

    public void setRssAbstract(String rssAbstract) {
        this.rssAbstract = rssAbstract;
    }

    public String getRssLink() {
        return rssLink;
    }

    public void setRssLink(String rssLink) {
        this.rssLink = rssLink;
    }

    /**
     * 若标题长度过长，采用省略的模式
     * @return 加了省略号后的标题
     */
    public String TitleFormat()
    {
        if (rssTitle.length() > 20)
        {
            return rssTitle.substring(0, 42) + "...";
        }
        return rssTitle;
    }

}
