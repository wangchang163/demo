package com.example.wangchang.testmvp.Interface;

import com.example.wangchang.testmvp.Model.UserModel;

/**
 * Created by WangChang on 2016/4/17.
 */
public class GetUserInfo implements UserInfo {

    @Override
    public void getUserInfo(String url, final CallBack callBack) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                final UserModel userModel = new UserModel();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                userModel.setIcon("http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg");
                userModel.setName("隔壁小王");
                userModel.setId(1);

                if (userModel.getId() > 0) {
                    callBack.success(userModel);

                } else {
                    callBack.failure();
                }
            }
        }.start();


    }
}
