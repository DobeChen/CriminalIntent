package com.dobe.zer0.entity;

import java.util.Date;
import java.util.UUID;

/**
 * Created by dobezer0 on 2017/5/10.
 */

public class Crime {
    private UUID mId;
    private String mTitle;

    private Date mDate;
    private boolean mSolved;

    public Crime(){
        //init mId
        mId = UUID.randomUUID();
        //init mDate
        mDate = new Date();
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
