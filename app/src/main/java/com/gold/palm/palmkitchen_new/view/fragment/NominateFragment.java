package com.gold.palm.palmkitchen_new.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.FoodBookRecommendBannerHolder;
import com.gold.palm.palmkitchen_new.adapter.MarrowAdapter;
import com.gold.palm.palmkitchen_new.adapter.NominateAdapter;
import com.gold.palm.palmkitchen_new.adapter.TalentAdapter;
import com.gold.palm.palmkitchen_new.bean.NominateBean;
import com.gold.palm.palmkitchen_new.presenter.nominate.NominatePresenter;
import com.gold.palm.palmkitchen_new.view.view.INominateView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Wang on 2016/11/5.
 */

public class NominateFragment extends BaseFragment implements INominateView{
    @BindView(R.id.nominate_pb)
    ProgressBar pb;
    @BindView(R.id.nominate_recycler)
    XRecyclerView recyclerView;
    private NominatePresenter presenter;
    private NominateAdapter adapter;
    @Override
    protected int getViewResId() {
        return R.layout.fragment_nominate;
    }

    @Override
    protected void initViews() {
        final SheQuFragment parent = (SheQuFragment) getParentFragment();
        recyclerView.setLoadingMoreEnabled(false);
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
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
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }

            @Override
            public void onLoadMore() {

            }
        });
        presenter = new NominatePresenter(this);
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
    public void setAdapter(NominateBean bean) {
        addHead(bean);
        adapter = new NominateAdapter(this,bean);
        recyclerView.setAdapter(adapter);
    }

    private void addHead(NominateBean bean) {
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.head_nominate,null);
        ConvenientBanner banner = (ConvenientBanner) headView.findViewById(R.id.nominate_convenientBanner);
        List<String> bannerUrl = new ArrayList<>();
        for (int i = 0; i < bean.getData().getBanner().size(); i++) {
            bannerUrl.add(bean.getData().getBanner().get(i).getBanner_picture());
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
        RecyclerView recycler1 = (RecyclerView) headView.findViewById(R.id.head1_recycler);
        recycler1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        TalentAdapter adapter = new TalentAdapter(bean,this);
        recycler1.setAdapter(adapter);
        RecyclerView recycler2 = (RecyclerView) headView.findViewById(R.id.head2_recycler);
        recycler2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        MarrowAdapter adapter2 = new MarrowAdapter(bean,this);
        recycler2.setAdapter(adapter2);
        recyclerView.addHeaderView(headView);
    }

    @Override
    public void notifyData(NominateBean bean) {
        adapter.setData(bean);
        recyclerView.refreshComplete();
    }
}
