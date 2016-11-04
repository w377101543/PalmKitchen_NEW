package com.gold.palm.palmkitchen_new.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.SearchListBean;
import com.gold.palm.palmkitchen_new.ui.RoundImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/3.
 */

public class SearchListAdapter extends RecyclerView.Adapter {
    private List<SearchListBean.DataFirst.DataSecond> list;

    private Activity activity;
    private int lastCount;
    public SearchListAdapter(Activity activity,SearchListBean bean) {
        this.activity = activity;
        list = bean.getData().getData();
        lastCount = list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_search_list,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder mHolder = (Holder) holder;
        SearchListBean.DataFirst.DataSecond obj = list.get(position);
        Glide.with(activity).load(obj.getImage()).into(mHolder.img);
        mHolder.title.setText(obj.getTitle());
        mHolder.desc.setText(obj.getDescription());
        mHolder.hard.setText("难度："+obj.getHard_level());
        mHolder.taste.setText("口味："+obj.getTaste());
        mHolder.cookTime.setText("烹饪时间："+obj.getCooking_time());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.search_list_img)
        RoundImageView img;
        @BindView(R.id.search_list_title)
        TextView title;
        @BindView(R.id.search_list_desc)
        TextView desc;
        @BindView(R.id.search_list_hard)
        TextView hard;
        @BindView(R.id.search_list_taste)
        TextView taste;
        @BindView(R.id.search_list_cook_time)
        TextView cookTime;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    /**添加数据*/
    public void addData(SearchListBean.DataFirst data){
        list.addAll(data.getData());
        lastCount += Integer.parseInt(data.getCount());
        notifyItemRangeInserted(lastCount-1,Integer.parseInt(data.getCount()));
    }
}
