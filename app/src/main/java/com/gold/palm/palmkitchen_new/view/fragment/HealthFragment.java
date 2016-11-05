package com.gold.palm.palmkitchen_new.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.HealthAdapter1;
import com.gold.palm.palmkitchen_new.adapter.HealthAdapter2;
import com.gold.palm.palmkitchen_new.bean.HealthBean1;
import com.gold.palm.palmkitchen_new.bean.HealthBean2;
import com.gold.palm.palmkitchen_new.presenter.health.HealthPresenter;
import com.gold.palm.palmkitchen_new.view.view.IHealthView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * Created by Wang on 2016/11/4.
 */

public class HealthFragment extends BaseFragment implements IHealthView{
    @BindView(R.id.cate_health_recycler1)
    RecyclerView recyclerView;
    @BindView(R.id.cate_health_recycler2)
    XRecyclerView xRecyclerView;
    @BindView(R.id.life_pb)
    FrameLayout pb;
    @Override
    protected int getViewResId() {
        return R.layout.fragment_cate_health;
    }
    private HealthPresenter presenter;
    private HealthAdapter1 adapter1;
    private HealthAdapter2 adapter2;
    @Override
    protected void initViews() {
        presenter = new HealthPresenter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        xRecyclerView.setPullRefreshEnabled(false);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                presenter.loadMore();
            }
        });
        presenter.getData1();
        presenter.getData2();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void setAdapter1(HealthBean1 bean1) {
        adapter1 = new HealthAdapter1(bean1,this);
        recyclerView.setAdapter(adapter1);
    }

    @Override
    public void setAdapter2(HealthBean2 bean2) {
        adapter2 = new HealthAdapter2(bean2,this);
        xRecyclerView.setAdapter(adapter2);
    }

    @Override
    public void loadMoreComplete() {
        xRecyclerView.loadMoreComplete();
    }

    @Override
    public void notifyData(HealthBean2 bean2) {
        adapter2.notifyData(bean2);
    }

    @Override
    public void setNoMoreData() {
        xRecyclerView.setIsnomore(true);
    }
}
