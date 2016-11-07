package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.NominateBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/7.
 */

public class TalentAdapter extends RecyclerView.Adapter {
    private List<NominateBean.DataFirst.ShequTalentBean> list;
    private Fragment fragment;

    public TalentAdapter(NominateBean bean, Fragment fragment) {
        list = bean.getData().getShequ_talent();
        this.fragment = fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_head_talent,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        Glide.with(fragment).load(list.get(position).getHead_img()).into(h.headImg);
        h.name.setText(list.get(position).getNick());
        h.num.setText("粉丝："+list.get(position).getTongji_be_follow());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.talent_header)
        ImageView headImg;
        @BindView(R.id.talent_name)
        TextView name;
        @BindView(R.id.talent_follow_num)
        TextView num;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
