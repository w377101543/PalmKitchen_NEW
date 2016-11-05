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
import com.gold.palm.palmkitchen_new.bean.HealthBean2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/5.
 */

public class HealthAdapter2 extends RecyclerView.Adapter {
    private List<HealthBean2.DataFirst.DataSecond> list;
    private Fragment fragment;
    private int loadedCount;
    public HealthAdapter2(HealthBean2 bean2,Fragment fragment) {
        list = bean2.getData().getData();
        this.fragment = fragment;
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
        HealthBean2.DataFirst.DataSecond data = list.get(position);
        Glide.with(fragment).load(data.getImage()).into(h.img);
        Glide.with(fragment).load(data.getAlbum_logo()).into(h.logo);
        String name = data.getSeries_name();
        String[] strings = name.split("#");
        String title = strings[strings.length-1];
        String album = strings[strings.length-2];
        h.album.setText(album);
        h.title.setText(title);
        h.episode.setText("更新至"+data.getEpisode()+"集");
        h.play.setText("上课人数"+data.getPlay());
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
    public void notifyData(HealthBean2 bean2){
        list.addAll(bean2.getData().getData());
        notifyItemRangeInserted(loadedCount+1,Integer.parseInt(bean2.getData().getCount()));
        loadedCount += Integer.parseInt(bean2.getData().getCount());
    }
}
