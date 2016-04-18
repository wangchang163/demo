package com.example.wangchang.testmvp.View;

import com.example.wangchang.testmvp.Model.UserModel;

/**
 * Created by WangChang on 2016/4/17.
 */
public interface MainView {

    void userInfo(UserModel userModel);

    void showLoading();

    void hideLoading();

}
