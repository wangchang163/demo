package com.example.wangchang.test_zhihu;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.wangchang.test_zhihu.helper.OnStartDragListener;
import com.example.wangchang.test_zhihu.helper.SimpleItemTouchHelperCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnStartDragListener {

    private SwipeRefreshLayout layRefresh;
    private RecyclerView recyclerView;
    private DemoAdapter adapter;
    private ItemTouchHelper mItemTouchHelper;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layRefresh = (SwipeRefreshLayout) findViewById(R.id.layRefresh);
        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        fab= (FloatingActionButton) findViewById(R.id.fab);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter = new DemoAdapter(this));
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        adapter.replaceAll(getData());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "what are you doing", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        layRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                try {
                    Thread.sleep(2000);
                    adapter.replaceAll(getData());
                    layRefresh.setRefreshing(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    public ArrayList<Model> getData() {
        ArrayList<Model> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Model model = new Model();
            model.setContent("Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。尚未有统一中文名称，中国大陆地区较多人使用“安卓”或“安致”。Android操作系统最初由Andy Rubin开发，主要支持手机。2005年8月由Google收购注资。2007年11月，Google与84家硬件制造商、软件开发商及电信营运商组建开放手机联盟共同研发改良Android系统。随后Google以Apache开源许可证的授权方式，发布了Android的源代码。第一部Android智能手机发布于2008年10月。Android逐渐扩展到平板电脑及其他领域上，如电视、数码相机、游戏机等。");
            model.setCount("3.4K");
            model.setTitle("人生若只如初见");
            model.setType("来自互联网");
            list.add(model);
        }
        return list;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
