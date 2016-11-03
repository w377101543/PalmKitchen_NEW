package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.AssortmentBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/2.
 */

public class FoodAssortmentAdapter extends RecyclerView.Adapter {
    private List<AssortmentBean.Data.SecondData> list;
    private LayoutInflater inflater;
    private Fragment fragment;
    public FoodAssortmentAdapter(AssortmentBean bean, Fragment fragment) {
        list = bean.getData().getData();
        this.fragment = fragment;
        inflater = LayoutInflater.from(fragment.getContext());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_ingredient,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AssortmentBean.Data.SecondData data = list.get(position);
        ViewHolder h = (ViewHolder) holder;
        h.title.setText(data.getText());
        Glide.with(fragment.getContext()).load(data.getImage()).into(h.img);
        h.gridLayout.removeViews(1, h.gridLayout.getChildCount() - 1);
        for (int i = 0; i < data.getData().size(); i++) {
            View view = inflater.inflate(R.layout.item_sub_tv, null);
            TextView tv = (TextView) view.findViewById(R.id.sub_tv);
            tv.setText(data.getData().get(i).getText());
            h.gridLayout.addView(view);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ingredient_title)
        TextView title;
        @BindView(R.id.ingredient_grid)
        GridLayout gridLayout;
        @BindView(R.id.grid_img)
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
