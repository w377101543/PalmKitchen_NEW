package com.gold.palm.palmkitchen_new.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.CateAdapter1;
import com.gold.palm.palmkitchen_new.adapter.CateAdapter2;
import com.gold.palm.palmkitchen_new.bean.CateBean1;
import com.gold.palm.palmkitchen_new.bean.CateBean2;
import com.gold.palm.palmkitchen_new.presenter.cate.CatePresenter;
import com.gold.palm.palmkitchen_new.view.view.ICateView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * Created by Wang on 2016/11/4.
 */

public class CateFragment extends BaseFragment implements ICateView{
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
    private CateAdapter1 adapter1;
    private CateAdapter2 adapter2;
    private CatePresenter presenter;
    @Override
    protected void initViews() {
        presenter = new CatePresenter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setPullRefreshEnabled(false);
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
    public void setAdapter1(CateBean1 bean1) {
        adapter1 = new CateAdapter1(this,bean1);
        recyclerView.setAdapter(adapter1);
    }

    @Override
    public void setAdapter2(CateBean2 bean2) {
        adapter2 = new CateAdapter2(this,bean2);
        xRecyclerView.setAdapter(adapter2);
    }

    @Override
    public void notifyData(CateBean2 bean2) {
        adapter2.notifyData(bean2);
    }

    @Override
    public void loadMoreComplete() {
        xRecyclerView.loadMoreComplete();
    }

    @Override
    public void setNoMoreData() {
        xRecyclerView.setIsnomore(true);
    }
}
