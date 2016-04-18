package com.example.wangchang.testmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wangchang.testmvp.Model.UserModel;
import com.example.wangchang.testmvp.Presenter.MainPresenter;
import com.example.wangchang.testmvp.View.MainView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements MainView {

    private ImageView iv;
    private TextView tv;
    private ProgressBar progressBar;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        presenter = new MainPresenter(this);
        presenter.getUserInfo();


    }


    @Override
    public void userInfo(final UserModel userModel) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Picasso.with(MainActivity.this).load(userModel.getIcon()).resize(400,400).into(iv);
                tv.setText(userModel.getName());
            }
        });

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });

    }
}
