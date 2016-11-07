package com.gold.palm.palmkitchen_new.view.fragment;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.NewAdapter;
import com.gold.palm.palmkitchen_new.bean.NewBean;
import com.gold.palm.palmkitchen_new.presenter.cardnew.NewPresenter;
import com.gold.palm.palmkitchen_new.view.view.ICardNewView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * Created by Wang on 2016/11/5.
 */

public class NewFragment extends BaseFragment implements ICardNewView {
    @BindView(R.id.new_pb)
    ProgressBar pb;
    @BindView(R.id.new_recycler)
    XRecyclerView recyclerView;
    private NewAdapter adapter;
    private NewPresenter presenter;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_new;
    }

    @Override
    protected void initViews() {
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }

            @Override
            public void onLoadMore() {
                presenter.loadMore();
            }
        });
        final SheQuFragment parent = (SheQuFragment) getParentFragment();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy >= 10) {
                    parent.cameraLayout.animate().translationY(parent.cameraLayout.getHeight()).setDuration(200).start();
                } else if (dy <= -10) {
                    parent.cameraLayout.animate().translationY(0).setDuration(200).start();
                }
            }
        });
        recyclerView.addItemDecoration(new SpacesItemDecoration(2));
        presenter = new NewPresenter(this);
        presenter.getData();
    }
    private class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,RecyclerView parent, RecyclerView.State state) {

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) % 2 == 0) {
//                    outRect.top = space;
                outRect.left = space;
            } else {
                outRect.right = space;
            }
        }
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
    public void setAdapter(NewBean bean) {
        adapter = new NewAdapter(bean, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void notifyData(NewBean bean) {
        adapter.notify(bean);
    }

    @Override
    public void loadMoreComplete() {
        recyclerView.loadMoreComplete();
    }

    @Override
    public void refreshComplete() {
        recyclerView.refreshComplete();
    }

    @Override
    public void resetData(NewBean bean) {
        adapter.setData(bean);
    }

    @Override
    public void noMoreData() {
        recyclerView.setIsnomore(true);
    }
}
