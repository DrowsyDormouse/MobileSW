package com.example.song.mobilesw;

import android.graphics.drawable.Drawable;

/**
 * Created by Song on 2017-10-25.
 */

public class TimelineItemList {
    private Drawable drawable;
    private String writer;
    private String title;
    private String body;

    public void setIcon(Drawable icon){
        drawable = icon;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setwriter(String writer){
        this.writer = writer;
    }

    public void setbody(String body){
        this.body = body;
    }

    public Drawable getIcon(){
        return drawable;
    }

    public String getWriter(){
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getBody(){
        return body;
    }
}

