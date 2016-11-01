package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.IngredientBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/1.
 */

public class FoodIngredientAdapter extends RecyclerView.Adapter {
    private List<IngredientBean.DataFirst.DataSecond> list;
    private Fragment fragment;
    public FoodIngredientAdapter(Fragment fragment, IngredientBean bean) {
        list = bean.getData().getData();
        this.fragment = fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ingredient, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        IngredientBean.DataFirst.DataSecond data = list.get(position);
        Glide.with(fragment).load(data.getImage()).into(mHolder.img);
        Log.e("name",data.getText()+data.getData());
        mHolder.title.setText(data.getText());
        for (int i = 0; i < data.getData().size(); i++) {
            TextView tv = new TextView(fragment.getContext());
            tv.setText(data.getData().get(i).getText());
            mHolder.layout.addView(tv);
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
        GridLayout layout;
        @BindView(R.id.ingredient_img)
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
