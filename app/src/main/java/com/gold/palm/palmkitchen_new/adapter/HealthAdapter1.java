package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.HealthBean1;
import com.gold.palm.palmkitchen_new.ui.CircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/5.
 */

public class HealthAdapter1 extends RecyclerView.Adapter {
    private List<HealthBean1.DataBean.AlbumsBean> list;
    private Fragment fragment;

    public HealthAdapter1(HealthBean1 bean, Fragment fragment) {
        list = bean.getData().getAlbums();
        this.fragment = fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cate_health_1,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HealthBean1.DataBean.AlbumsBean data = list.get(position);
        Holder h = (Holder) holder;
        Glide.with(fragment).load(data.getAlbum_logo()).into(h.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.cate_health_1_img)
        CircleImageView img;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
