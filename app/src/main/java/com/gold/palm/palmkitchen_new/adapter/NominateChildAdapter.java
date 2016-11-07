package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.NominateBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/7.
 */

public class NominateChildAdapter extends RecyclerView.Adapter {
    private List<NominateBean.DataFirst.ShequTopicsBean.DataThird> list;
    private Fragment fragment;

    public NominateChildAdapter(Fragment fragment) {
        list = new ArrayList<>();
        this.fragment = fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_nominate_child,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        Glide.with(fragment).load(list.get(position).getImage()).into(h.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.nominate_post)
        ImageView img;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void addData(List<NominateBean.DataFirst.ShequTopicsBean.DataThird> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
