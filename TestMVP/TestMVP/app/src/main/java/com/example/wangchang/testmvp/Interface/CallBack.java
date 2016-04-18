package com.example.wangchang.testmvp.Interface;

import com.example.wangchang.testmvp.Model.UserModel;

/**
 * Created by WangChang on 2016/4/17.
 */
public interface CallBack {

    void success(UserModel userModel);

    void failure();
}
