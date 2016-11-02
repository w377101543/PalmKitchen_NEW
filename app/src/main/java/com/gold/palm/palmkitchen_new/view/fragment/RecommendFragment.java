package com.gold.palm.palmkitchen_new.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.FoodBookRecommendBannerHolder;
import com.gold.palm.palmkitchen_new.adapter.RecommendCyclerAdapter;
import com.gold.palm.palmkitchen_new.bean.HomeBean;
import com.gold.palm.palmkitchen_new.presenter.foodrecommend.FoodRecommendPresenter;
import com.gold.palm.palmkitchen_new.view.view.IFoodRecommendView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Wang on 2016/10/21.
 */

public class RecommendFragment extends LazyFragment implements IFoodRecommendView, XRecyclerView.LoadingListener {
    @BindView(R.id.recommend_recycler)
    XRecyclerView recyclerView;
    @BindView(R.id.loading_pb)
    FrameLayout loadingPb;
    private HomeBean homeBean;
    private RecommendCyclerAdapter adapter;;
    private FoodRecommendPresenter presenter;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(false);
        recyclerView.setLoadingListener(this);
//        recyclerView.setIsnomore(true);
        presenter = new FoodRecommendPresenter(this,getContext());
        presenter.getData();
    }

    @Override
    public void showLoading() {
        loadingPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        loadingPb.setVisibility(View.GONE);
    }

    @Override
    public void getDataSucceed(HomeBean homeBean) {
        this.homeBean = homeBean;
        Toast.makeText(getContext(), "获取数据成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDataFailed() {
        Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.head_food_book_recommend, null);
        ConvenientBanner banner = (ConvenientBanner) view.findViewById(R.id.food_book_recommend_pager);
        List<String> bannerUrl = new ArrayList<>();
        for (int i = 0; i < homeBean.getData().getBanner().size(); i++) {
            bannerUrl.add(homeBean.getData().getBanner().get(i).getBanner_picture());
        }
        banner.setPages(new CBViewHolderCreator<FoodBookRecommendBannerHolder>() {
            @Override
            public FoodBookRecommendBannerHolder createHolder() {
                return new FoodBookRecommendBannerHolder();
            }
        }, bannerUrl);
        banner.setPageIndicator(new int[]{R.mipmap.indicator_n, R.mipmap.indicator_s});
        banner.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        banner.setCanLoop(true);
        banner.setManualPageable(true);
        banner.setScrollDuration(1200);
        banner.startTurning(8000);
        recyclerView.addHeaderView(view);
        adapter = new RecommendCyclerAdapter(homeBean, getContext());
        recyclerView.setAdapter(adapter);
        stopLoading();
    }

    @Override
    public void notifyData(HomeBean homeBean) {
        adapter.notiyData(homeBean);
    }

    @Override
    public void onRefresh() {
        presenter.getNetWorkData(1);
        recyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    protected void lazyLoad() {
    }
}
