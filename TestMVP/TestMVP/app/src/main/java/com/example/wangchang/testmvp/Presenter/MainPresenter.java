package com.example.wangchang.testmvp.Presenter;


import com.example.wangchang.testmvp.Interface.CallBack;
import com.example.wangchang.testmvp.Interface.GetUserInfo;
import com.example.wangchang.testmvp.Model.UserModel;
import com.example.wangchang.testmvp.View.MainView;

/**
 * Created by WangChang on 2016/4/17.
 */
public class MainPresenter {
    private MainView view;
    private GetUserInfo info;


    public MainPresenter(MainView view) {
        this.view = view;
        this.info = new GetUserInfo();
    }

    public void getUserInfo() {

        view.showLoading();
        info.getUserInfo("wwww.bai.com", new CallBack() {


            @Override
            public void success(final UserModel userModel) {
                view.userInfo(userModel);
                view.hideLoading();
            }

            @Override
            public void failure() {
                view.hideLoading();


            }
        });
    }


}
