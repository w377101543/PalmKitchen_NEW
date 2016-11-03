package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.IngredientBean;
import com.gold.palm.palmkitchen_new.utils.AppUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by Wang on 2016/11/1.
 */

public class FoodIngredientAdapter extends RecyclerView.Adapter {
    private List<IngredientBean.DataFirst.DataSecond> list;
    private Fragment fragment;
    private LayoutInflater inflater;

    public FoodIngredientAdapter(Fragment fragment, IngredientBean bean) {
        list = bean.getData().getData();
        this.fragment = fragment;
        inflater = LayoutInflater.from(fragment.getContext());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ingredient, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        final IngredientBean.DataFirst.DataSecond data = list.get(position);
        mHolder.title.setText(data.getText());
        final List<IngredientBean.DataFirst.DataSecond.DataThird> thirdList = data.getData();
        Glide.with(fragment.getContext()).load(data.getImage()).into(mHolder.img);
        mHolder.gridLayout.removeViews(1, mHolder.gridLayout.getChildCount() - 1);
        for (int i = 0; i < thirdList.size(); i++) {
            View view = inflater.inflate(R.layout.item_sub_tv, null);
            TextView tv = (TextView) view.findViewById(R.id.sub_tv);
            tv.setText(thirdList.get(i).getText());
            mHolder.gridLayout.addView(view);
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
