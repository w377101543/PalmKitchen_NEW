package com.gold.palm.palmkitchen_new.presenter.Guide;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.BasePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2016/10/29.
 */

public class GuidePresenter implements IGuidePresenter {
    private LayoutInflater inflater;
    public GuidePresenter(Context context) {
        inflater = LayoutInflater.from(context);
    }
    @Override
    public void setPagerAdapter(ViewPager pager) {
        List<View> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            View view = inflater.inflate(R.layout.item_guide_pager, null);
            ImageView img = (ImageView) view.findViewById(R.id.guide_img);
            if(i == 0){
                img.setImageResource(R.mipmap.guide_01);
            }else if(i == 1){
                img.setImageResource(R.mipmap.guide_02);
            }else {
                img.setImageResource(R.mipmap.guide_03);
            }
            list.add(view);
        }
        BasePagerAdapter adapter = new BasePagerAdapter(list);
        pager.setAdapter(adapter);
    }

}
