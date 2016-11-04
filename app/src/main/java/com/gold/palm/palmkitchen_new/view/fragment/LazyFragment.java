package com.gold.palm.palmkitchen_new.view.fragment;

/**
 * Created by Wang on 2016/10/30.
 */

public abstract class LazyFragment extends BaseFragment {
    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible;
    protected boolean noData = true;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }
    /**
     * 可见
     */
    protected void onVisible() {
        noData = false;
        lazyLoad();
    }
    /**
     * 不可见
     */
    protected void onInvisible() {}
    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();
}
