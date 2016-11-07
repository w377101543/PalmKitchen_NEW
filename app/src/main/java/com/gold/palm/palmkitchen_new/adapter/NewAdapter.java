package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.NewBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/7.
 */

public class NewAdapter extends RecyclerView.Adapter {
    private List<NewBean.DataFirst.DataSecond> list;
    private Fragment fragment;
    private int loadedCount;
    public NewAdapter(NewBean bean, Fragment fragment) {
        list = bean.getData().getData();
        this.fragment = fragment;
        loadedCount = list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_new,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        Glide.with(fragment).load(list.get(position).getImage()).into(h.img);
        Glide.with(fragment).load(list.get(position).getHead_img()).into(h.header);
        h.name.setText(list.get(position).getNick());
        h.time.setText(list.get(position).getCreate_time());
        h.zan.setText(list.get(position).getAgree_count());
        if(TextUtils.isEmpty(list.get(position).getVideo().trim()))
            h.playImg.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.new_post)
        ImageView img;
        @BindView(R.id.new_card_play)
        ImageView playImg;
        @BindView(R.id.new_card_header)
        ImageView header;
        @BindView(R.id.new_card_nick)
        TextView name;
        @BindView(R.id.new_card_time)
        TextView time;
        @BindView(R.id.id_zan)
        TextView zan;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void notify(NewBean bean){
        this.list.addAll(bean.getData().getData());
        notifyItemRangeInserted(loadedCount+1,bean.getData().getCount());
        loadedCount+=bean.getData().getCount();
    }
    public void setData(NewBean bean){
        this.list = bean.getData().getData();
        notifyDataSetChanged();
        loadedCount = bean.getData().getCount();
    }
}
