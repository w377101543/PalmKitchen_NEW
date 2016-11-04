package com.gold.palm.palmkitchen_new.view.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.SearchListAdapter;
import com.gold.palm.palmkitchen_new.bean.SearchListBean;
import com.gold.palm.palmkitchen_new.presenter.searchlist.SearchListPresenter;
import com.gold.palm.palmkitchen_new.view.view.ISearchListView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Wang on 2016/11/3.
 */

public class SearchListActivity extends BaseActivity implements ISearchListView {
    @BindView(R.id.search_list_recycle)
    XRecyclerView recyclerView;
    @BindView(R.id.search_list_back)
    View img;
    @BindView(R.id.normal_title)
    TextView title;
    @BindView(R.id.search_list_pb)
    FrameLayout loadingView;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_search_list;
    }

    private String keyword;

    @Override
    protected void initViews() {
        Intent intent = getIntent();
        keyword = intent.getStringExtra("keyword");
        recyclerView.setPullRefreshEnabled(false);
        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        title.setText("为你找到");
        final SearchListPresenter presenter = new SearchListPresenter(this);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                if (presenter.getLoadedCount() >= presenter.getTotalCount()) {
                    recyclerView.setIsnomore(true);
                    return;
                }
                presenter.loadMore(keyword);
            }
        });
        presenter.getData(keyword);
    }

    @OnClick({R.id.search_list_back})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.search_list_back:
                onBackPressed();
                return;
        }
    }

    private SearchListAdapter adapter;

    @Override
    public void setAdapter(SearchListBean bean) {
        adapter = new SearchListAdapter(this, bean);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void notifyData(SearchListBean bean) {
        adapter.addData(bean.getData());
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void loadMoreComplete() {
        recyclerView.loadMoreComplete();
    }
}
