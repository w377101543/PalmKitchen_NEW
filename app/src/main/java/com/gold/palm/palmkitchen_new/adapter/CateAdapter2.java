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
import com.gold.palm.palmkitchen_new.bean.CateBean2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/4.
 */

public class CateAdapter2 extends RecyclerView.Adapter {
    private Fragment fragment;
    private List<CateBean2.DataFirst.DataSecond> list;
    private int loadedCount;
    public CateAdapter2(Fragment fragment, CateBean2 bean2) {
        this.fragment = fragment;
        list = bean2.getData().getData();
        loadedCount += list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_cate_health_2,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        String name = list.get(position).getSeries_name();
        String[] strings = name.split("#");
        String title = strings[strings.length-1];
        String album = strings[strings.length-2];
        Glide.with(fragment).load(list.get(position).getImage()).into(h.img);
        Glide.with(fragment).load(list.get(position).getAlbum_logo()).into(h.logo);
        h.title.setText(title);
        h.album.setText(album);
        h.episode.setText("更新至"+list.get(position).getEpisode()+"集");
        h.play.setText("上课人数"+list.get(position).getPlay());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.life_img)
        ImageView img;
        @BindView(R.id.life_logo)
        ImageView logo;
        @BindView(R.id.life_title)
        TextView title;
        @BindView(R.id.life_episode)
        TextView episode;
        @BindView(R.id.life_play)
        TextView play;
        @BindView(R.id.life_album)
        TextView album;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void notifyData(CateBean2 bean2){
        list.addAll(bean2.getData().getData());
        notifyItemRangeInserted(loadedCount+1,Integer.parseInt(bean2.getData().getCount()));
        loadedCount += Integer.parseInt(bean2.getData().getCount());
    }
}
