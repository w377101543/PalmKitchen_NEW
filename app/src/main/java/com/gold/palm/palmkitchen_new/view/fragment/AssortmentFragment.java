package com.gold.palm.palmkitchen_new.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.FoodAssortmentAdapter;
import com.gold.palm.palmkitchen_new.adapter.FoodIngredientAdapter;
import com.gold.palm.palmkitchen_new.bean.AssortmentBean;
import com.gold.palm.palmkitchen_new.bean.IngredientBean;
import com.gold.palm.palmkitchen_new.presenter.foodassortment.AssortmentPresenter;
import com.gold.palm.palmkitchen_new.presenter.foodingredient.IngredientPresenter;
import com.gold.palm.palmkitchen_new.view.view.IAssortmentView;

import butterknife.BindView;


/**
 * Created by Wang on 2016/10/21.
 */

public class AssortmentFragment extends BaseFragment implements IAssortmentView{
    @BindView(R.id.ingredient_loading_pb)
    FrameLayout loadingView;
    @BindView(R.id.ingredient_recycle_view)
    RecyclerView recyclerView;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_ingredient;
    }

    @Override
    protected void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        AssortmentPresenter presenter = new AssortmentPresenter(this,this);
        presenter.getData();
    }

    @Override
    public void setAdapter(AssortmentBean bean) {
        FoodAssortmentAdapter adapter = new FoodAssortmentAdapter(bean,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void stopLoading() {
        loadingView.setVisibility(View.GONE);
    }
}
