package com.example.wangchang.test_zhihu;

import java.io.Serializable;

/**
 * Created by WangChang on 2016/3/31.
 */
public class Model implements Serializable {

    private String type = "";
    private String count = "";
    private String title = "";
    private String content = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
