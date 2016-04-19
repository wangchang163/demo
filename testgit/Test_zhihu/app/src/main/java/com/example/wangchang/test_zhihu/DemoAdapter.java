package com.example.wangchang.test_zhihu;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangchang.test_zhihu.helper.ItemTouchHelperAdapter;
import com.example.wangchang.test_zhihu.helper.ItemTouchHelperViewHolder;
import com.example.wangchang.test_zhihu.helper.OnStartDragListener;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by WangChang on 2016/3/31.
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.BaseViewHolder> implements ItemTouchHelperAdapter {

    private ArrayList<Model> dataList = new ArrayList<>();
    private OnStartDragListener mDragStartListener;


    public DemoAdapter(OnStartDragListener mDragStartListener) {
        this.mDragStartListener = mDragStartListener;
    }
    public void replaceAll(ArrayList<Model> list) {
        dataList.clear();
        if (list != null && list.size() > 0) {
            dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public DemoAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DemoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(DemoAdapter.BaseViewHolder holder, int position) {

        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(dataList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        void setData(Object data) {
        }
    }

    private class DemoViewHolder extends BaseViewHolder implements
            ItemTouchHelperViewHolder {
        private TextView tvType, tvCount, tvTitle, tvContent;

        public DemoViewHolder(View view) {
            super(view);
            tvType = (TextView) view.findViewById(R.id.tvType);
            tvCount = (TextView) view.findViewById(R.id.tvCount);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvContent = (TextView) view.findViewById(R.id.tvContent);
        }

        @Override
        void setData(Object data) {
            if (data != null) {
                Model model = (Model) data;
                tvType.setText(model.getType());
                tvCount.setText(model.getCount());
                tvTitle.setText(model.getTitle());
                tvContent.setText(model.getContent());
            }
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(0);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}
