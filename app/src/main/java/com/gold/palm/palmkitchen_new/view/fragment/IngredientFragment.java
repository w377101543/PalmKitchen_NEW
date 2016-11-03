package com.gold.palm.palmkitchen_new.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.FoodIngredientAdapter;
import com.gold.palm.palmkitchen_new.bean.IngredientBean;
import com.gold.palm.palmkitchen_new.presenter.foodingredient.IngredientPresenter;
import com.gold.palm.palmkitchen_new.view.view.IIngredientView;

import butterknife.BindView;


/**
 * Created by Wang on 2016/10/21.
 */

public class IngredientFragment extends BaseFragment implements IIngredientView {
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
        IngredientPresenter presenter = new IngredientPresenter(this,getContext());
        presenter.getData();
    }

    @Override
    public void setAdapter(IngredientBean bean) {
        FoodIngredientAdapter adapter = new FoodIngredientAdapter(this,bean);
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
