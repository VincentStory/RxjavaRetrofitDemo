package com.example.rxjava.bean;

/**
 * author : wangwenbo
 * e-mail : wangwenbo@qutoutiao.net
 * date   : 2021/6/18 2:54 PM
 * desc   :
 */
public class ResultBean {

    private String title;
    private String cover;
    private String uri;
    private String param;
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", uri='" + uri + '\'' +
                ", param='" + param + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
