package com.gold.palm.palmkitchen_new.view.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.FollowAdapter;
import com.gold.palm.palmkitchen_new.bean.FollowBean;
import com.gold.palm.palmkitchen_new.presenter.follow.FollowPresenter;
import com.gold.palm.palmkitchen_new.view.view.IFollowView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * Created by Wang on 2016/11/5.
 */

public class FollowFragment extends BaseFragment implements IFollowView{
    @BindView(R.id.follow_recycler)
    XRecyclerView recyclerView;
    @BindView(R.id.follow_pb)
    ProgressBar pb;
    private FollowAdapter adapter;
    private FollowPresenter presenter;
    private SheQuFragment parent;
    @Override
    protected int getViewResId() {
        return R.layout.fragment_follow;
    }

    @Override
    protected void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        presenter = new FollowPresenter(this);
        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setPullRefreshEnabled(false);
        parent = (SheQuFragment) getParentFragment();
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                presenter.loadMore();
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy >= 10){
                    parent.cameraLayout.animate().translationY(parent.cameraLayout.getHeight()).setDuration(200).start();
                }else if (dy<=-10){
                    parent.cameraLayout.animate().translationY(0).setDuration(200).start();
                }
            }
        });
        presenter.getData();
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
    public void setAdapter(FollowBean bean) {
        adapter = new FollowAdapter(bean,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void notifyData(FollowBean bean) {
        adapter.notifyData(bean);
    }

    @Override
    public void loadMoreComplete() {
        recyclerView.loadMoreComplete();
    }

}
