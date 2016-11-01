package com.gold.palm.palmkitchen_new.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.HomeBean;
import com.gold.palm.palmkitchen_new.ui.CircleImageView;
import com.gold.palm.palmkitchen_new.ui.WImageView;
import com.gold.palm.palmkitchen_new.ui.WImageViewSub;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/10/29.
 */

public class RecommendCyclerAdapter extends RecyclerView.Adapter {
    private HomeBean homeBean;
    private List<HomeBean.DataBean.WidgetListBean> list;
    private LayoutInflater inflater;
    private Context context;
    public RecommendCyclerAdapter(HomeBean homeBean, Context context) {
        this.homeBean = homeBean;
        list = homeBean.getData().getWidgetList();
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                return new ViewHolderType1(inflater.inflate(R.layout.widget_type1,parent,false));
            case 2:
                return new ViewHolderType2(inflater.inflate(R.layout.widget_type2,parent,false));
            case 5:
                return new ViewHolderType5(inflater.inflate(R.layout.widget_type5,parent,false));
            case 3:
                return new ViewHolderType3(inflater.inflate(R.layout.widget_type3,parent,false));
            case 9:
                return new ViewHolderType9(inflater.inflate(R.layout.widget_type9,parent,false));
            case 4:
                return new ViewHolderType4(inflater.inflate(R.layout.widget_type4,parent,false));
            case 8:
                return new ViewHolderType8(inflater.inflate(R.layout.widget_type8,parent,false));
            case 7:
                return new ViewHolderType7(inflater.inflate(R.layout.widget_type7,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case 1:
                ViewHolderType1 mHolder = (ViewHolderType1) holder;
                handleType1(mHolder,position);
                break;
            case 2:
                ViewHolderType2 mHolder2 = (ViewHolderType2) holder;
                handleType2(mHolder2,position);
                break;
            case 5:
                ViewHolderType5 mHolder5 = (ViewHolderType5) holder;
                handleType5(mHolder5,position);
                break;
            case 3:
                ViewHolderType3 mHolder3 = (ViewHolderType3) holder;
                handleType3(mHolder3,position);
                break;
            case 9:
                ViewHolderType9 mHolder9 = (ViewHolderType9) holder;
                handleType9(mHolder9,position);
                break;
            case 4:
                ViewHolderType4 mHolder4 = (ViewHolderType4) holder;
                handleType4(mHolder4,position);
                break;
            case 8:
                ViewHolderType8 mHolder8 = (ViewHolderType8) holder;
                handleType8(mHolder8,position);
                break;
            case 7:
                ViewHolderType7 mHolder7 = (ViewHolderType7) holder;
                handleType7(mHolder7,position);
                break;
        }
    }
    /**
     * 第七种视图：type = 7*/
    private void handleType7(ViewHolderType7 mHolder7, int position) {
        List<HomeBean.DataBean.WidgetListBean.WidgetDataBean> data = list.get(position).getWidget_data();
        Glide.with(context).load(data.get(0).getContent()).into(mHolder7.img1);
        Glide.with(context).load(data.get(3).getContent()).into(mHolder7.img2);
        mHolder7.title.setText(list.get(position).getTitle());
        mHolder7.title1.setText(data.get(1).getContent());
        mHolder7.title2.setText(data.get(4).getContent());
        mHolder7.desc1.setText(data.get(2).getContent());
        mHolder7.desc2.setText(data.get(5).getContent());
    }

    /**
     * 第八种视图：type = 8*/
    private void handleType8(ViewHolderType8 mHolder8, int position) {
        List<HomeBean.DataBean.WidgetListBean.WidgetDataBean> data = list.get(position).getWidget_data();
        mHolder8.desc.setText(list.get(position).getDesc());
        mHolder8.title.setText(list.get(position).getTitle());
        mHolder8.tv1.setText(data.get(2).getContent());
        mHolder8.tv2.setText(data.get(5).getContent());
        mHolder8.tv3.setText(data.get(8).getContent());
        Glide.with(context).load(data.get(0).getContent()).into(mHolder8.img1);
        Glide.with(context).load(data.get(3).getContent()).into(mHolder8.img2);
        Glide.with(context).load(data.get(6).getContent()).into(mHolder8.img3);
        Glide.with(context).load(data.get(1).getContent()).into(mHolder8.avatar1);
        Glide.with(context).load(data.get(4).getContent()).into(mHolder8.avatar2);
        Glide.with(context).load(data.get(7).getContent()).into(mHolder8.avatar3);
    }

    /**
     * 第四种视图：type = 4*/
    private void handleType4(ViewHolderType4 mHolder4, int position) {
        List<HomeBean.DataBean.WidgetListBean.WidgetDataBean> data = list.get(position).getWidget_data();
        Glide.with(context).load(data.get(0).getContent()).into(mHolder4.img1);
        Glide.with(context).load(data.get(4).getContent()).into(mHolder4.img2);
        Glide.with(context).load(data.get(8).getContent()).into(mHolder4.img3);
        mHolder4.title.setText(list.get(position).getTitle());
        mHolder4.title1.setText(data.get(1).getContent());
        mHolder4.title2.setText(data.get(5).getContent());
        mHolder4.title3.setText(data.get(9).getContent());
        mHolder4.desc1.setText(data.get(2).getContent());
        mHolder4.desc2.setText(data.get(6).getContent());
        mHolder4.desc3.setText(data.get(10).getContent());
        mHolder4.follow1.setText(data.get(3).getContent());
        mHolder4.follow2.setText(data.get(7).getContent());
        mHolder4.follow3.setText(data.get(11).getContent());
    }

    /**
     * 第九种视图：type = 9*/
    private void handleType9(ViewHolderType9 mHolder9, int position) {
        mHolder9.tv.setText(list.get(position).getTitle());
    }

    /**
     * 第三种视图：type = 3*/
    private void handleType3(ViewHolderType3 mHolder3, int position) {
        List<HomeBean.DataBean.WidgetListBean.WidgetDataBean> data = list.get(position).getWidget_data();
        Glide.with(context).load(data.get(0).getContent()).into(mHolder3.logoImg);
        Glide.with(context).load(data.get(3).getContent()).into(mHolder3.img1);
        Glide.with(context).load(data.get(5).getContent()).into(mHolder3.img2);
        Glide.with(context).load(data.get(7).getContent()).into(mHolder3.img3);
        Glide.with(context).load(data.get(9).getContent()).into(mHolder3.img4);
        mHolder3.desc.setText(list.get(position).getDesc());
        mHolder3.title.setText(list.get(position).getTitle());
        mHolder3.title1.setText(data.get(1).getContent());
        mHolder3.title2.setText(data.get(2).getContent());
    }

    /**
     * 第五种视图：type = 5*/
    private void handleType5(ViewHolderType5 mHolder5, int position) {
        List<HomeBean.DataBean.WidgetListBean.WidgetDataBean> data = list.get(position).getWidget_data();
        Glide.with(context).load(data.get(0).getContent()).into(mHolder5.img1);
        Glide.with(context).load(data.get(4).getContent()).into(mHolder5.img2);
        Glide.with(context).load(data.get(8).getContent()).into(mHolder5.img3);
        mHolder5.title.setText(list.get(position).getTitle());
        mHolder5.title1.setText(data.get(2).getContent());
        mHolder5.title2.setText(data.get(6).getContent());
        mHolder5.title3.setText(data.get(10).getContent());
        mHolder5.desc1.setText(data.get(3).getContent());
        mHolder5.desc2.setText(data.get(7).getContent());
        mHolder5.desc3.setText(data.get(11).getContent());
    }

    /**
     * 第二种视图：type = 2*/
    private void handleType2(ViewHolderType2 mHolder2, int position) {
        final List<HomeBean.DataBean.WidgetListBean.WidgetDataBean> data = list.get(position).getWidget_data();
        mHolder2.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        mHolder2.recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MHolder(inflater.inflate(R.layout.item_widget2,parent,false));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MHolder mHolder = (MHolder) holder;
                Log.e("tag",""+mHolder.img1);
                Glide.with(context).load(data.get(2*position).getContent()).into(mHolder.img1);
                Glide.with(context).load(data.get(2*position+1).getContent()).into(mHolder.img2);
            }

            @Override
            public int getItemCount() {
                return data.size()/2;
            }
            class MHolder extends RecyclerView.ViewHolder{
                @BindView(R.id.item_widget2_img1)
                ImageView img1;
                @BindView(R.id.item_widget2_img2)
                ImageView img2;
                public MHolder(View itemView) {
                    super(itemView);
                    img1 = (ImageView) itemView.findViewById(R.id.item_widget2_img1);
                    img2 = (ImageView) itemView.findViewById(R.id.item_widget2_img2);
//                    ButterKnife.bind(this,itemView);
                }
            }
        });
    }

    /**
     * 第一种视图：type = 1*/
    private void handleType1(ViewHolderType1 mHolder,int position) {
        List<HomeBean.DataBean.WidgetListBean.WidgetDataBean> data = list.get(position).getWidget_data();
        int count = data.size()/2;
        if(count <= 4){
            mHolder.layout1.setVisibility(View.VISIBLE);
            mHolder.layout2.setVisibility(View.VISIBLE);
            mHolder.layout3.setVisibility(View.VISIBLE);
            mHolder.layout4.setVisibility(View.VISIBLE);
            mHolder.layout5.setVisibility(View.GONE);
            mHolder.layout6.setVisibility(View.GONE);
            mHolder.layout7.setVisibility(View.GONE);
            mHolder.layout8.setVisibility(View.GONE);
        }else {
            mHolder.layout1.setVisibility(View.VISIBLE);
            mHolder.layout2.setVisibility(View.VISIBLE);
            mHolder.layout3.setVisibility(View.VISIBLE);
            mHolder.layout4.setVisibility(View.VISIBLE);
            mHolder.layout5.setVisibility(View.VISIBLE);
            mHolder.layout6.setVisibility(View.VISIBLE);
            mHolder.layout7.setVisibility(View.VISIBLE);
            mHolder.layout8.setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < count; i++) {
            if(i == 0){
                Glide.with(context).load(data.get(0).getContent()).into(mHolder.img1);
                mHolder.tv1.setText(data.get(1).getContent());
                continue;
            }else if(i == 1){
                Glide.with(context).load(data.get(2).getContent()).into(mHolder.img2);
                mHolder.tv2.setText(data.get(3).getContent());
                continue;
            }else if(i == 3){
                Glide.with(context).load(data.get(4).getContent()).into(mHolder.img3);
                mHolder.tv3.setText(data.get(5).getContent());
                continue;
            }else if(i == 4){
                Glide.with(context).load(data.get(6).getContent()).into(mHolder.img4);
                mHolder.tv4.setText(data.get(7).getContent());
                continue;
            }else if(i == 5){
                Glide.with(context).load(data.get(8).getContent()).into(mHolder.img5);
                mHolder.tv5.setText(data.get(9).getContent());
                continue;
            }else if(i == 6){
                Glide.with(context).load(data.get(10).getContent()).into(mHolder.img6);
                mHolder.tv6.setText(data.get(11).getContent());
                continue;
            }else if(i == 7){
                Glide.with(context).load(data.get(12).getContent()).into(mHolder.img7);
                mHolder.tv7.setText(data.get(13).getContent());
                continue;
            }else if(i == 8){
                Glide.with(context).load(data.get(14).getContent()).into(mHolder.img8);
                mHolder.tv8.setText(data.get(15).getContent());
            }
        }


        Glide.with(context).load(data.get(4).getContent()).into(mHolder.img3);
        Glide.with(context).load(data.get(6).getContent()).into(mHolder.img4);


        mHolder.tv3.setText(data.get(5).getContent());
        mHolder.tv4.setText(data.get(7).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolderType7 extends RecyclerView.ViewHolder{
        @BindView(R.id.widget7_img1)
        WImageViewSub img1;
        @BindView(R.id.widget7_img2)
        WImageViewSub img2;
        @BindView(R.id.widget7_title)
        TextView title;
        @BindView(R.id.widget7_desc1)
        TextView desc1;
        @BindView(R.id.widget7_desc2)
        TextView desc2;
        @BindView(R.id.widget7_title1)
        TextView title1;
        @BindView(R.id.widget7_title2)
        TextView title2;
        public ViewHolderType7(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class ViewHolderType8 extends RecyclerView.ViewHolder{
        @BindView(R.id.widget8_avatar1)
        ImageView avatar1;
        @BindView(R.id.widget8_avatar2)
        ImageView avatar2;
        @BindView(R.id.widget8_avatar3)
        ImageView avatar3;
        @BindView(R.id.widget8_img1)
        ImageView img1;
        @BindView(R.id.widget8_img2)
        ImageView img2;
        @BindView(R.id.widget8_img3)
        ImageView img3;
        @BindView(R.id.widget8_tv1)
        TextView tv1;
        @BindView(R.id.widget8_tv2)
        TextView tv2;
        @BindView(R.id.widget8_tv3)
        TextView tv3;
        @BindView(R.id.widget8_desc)
        TextView desc;
        @BindView(R.id.widget8_title)
        TextView title;
        public ViewHolderType8(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class ViewHolderType4 extends RecyclerView.ViewHolder{
        @BindView(R.id.widget4_desc1)
        TextView desc1;
        @BindView(R.id.widget4_desc2)
        TextView desc2;
        @BindView(R.id.widget4_desc3)
        TextView desc3;
        @BindView(R.id.widget4_follow1)
        TextView follow1;
        @BindView(R.id.widget4_follow2)
        TextView follow2;
        @BindView(R.id.widget4_follow3)
        TextView follow3;
        @BindView(R.id.widget4_img1)
        CircleImageView img1;
        @BindView(R.id.widget4_img2)
        CircleImageView img2;
        @BindView(R.id.widget4_img3)
        CircleImageView img3;
        @BindView(R.id.widget4_title)
        TextView title;
        @BindView(R.id.widget4_title1)
        TextView title1;
        @BindView(R.id.widget4_title2)
        TextView title2;
        @BindView(R.id.widget4_title3)
        TextView title3;
        public ViewHolderType4(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class ViewHolderType9 extends RecyclerView.ViewHolder{
        @BindView(R.id.widget9_title)
        TextView tv;
        public ViewHolderType9(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class ViewHolderType3 extends RecyclerView.ViewHolder{
        @BindView(R.id.widget3_logo_img)
        ImageView logoImg;
        @BindView(R.id.widget3_img1)
        ImageView img1;
        @BindView(R.id.widget3_img2)
        ImageView img2;
        @BindView(R.id.widget3_img3)
        ImageView img3;
        @BindView(R.id.widget3_img4)
        ImageView img4;
        @BindView(R.id.widget3_title)
        TextView title;
        @BindView(R.id.widget3_title1)
        TextView title1;
        @BindView(R.id.widget3_title2)
        TextView title2;
        @BindView(R.id.widget3_desc)
        TextView desc;
        public ViewHolderType3(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class ViewHolderType5 extends RecyclerView.ViewHolder{
        @BindView(R.id.widget5_img1)
        WImageView img1;
        @BindView(R.id.widget5_img2)
        WImageView img2;
        @BindView(R.id.widget5_img3)
        WImageView img3;
        @BindView(R.id.widget5_title1)
        TextView title1;
        @BindView(R.id.widget5_title2)
        TextView title2;
        @BindView(R.id.widget5_title3)
        TextView title3;
        @BindView(R.id.widget5_desc1)
        TextView desc1;
        @BindView(R.id.widget5_desc2)
        TextView desc2;
        @BindView(R.id.widget5_desc3)
        TextView desc3;
        @BindView(R.id.widget5_title)
        TextView title;
        public ViewHolderType5(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class ViewHolderType2 extends RecyclerView.ViewHolder{
        @BindView(R.id.widget2_recycler_view)
        RecyclerView recyclerView;
        public ViewHolderType2(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class ViewHolderType1 extends RecyclerView.ViewHolder{
        @BindView(R.id.widget1_img1)
        ImageView img1;
        @BindView(R.id.widget1_img2)
        ImageView img2;
        @BindView(R.id.widget1_img3)
        ImageView img3;
        @BindView(R.id.widget1_img4)
        ImageView img4;
        @BindView(R.id.widget1_img5)
        ImageView img5;
        @BindView(R.id.widget1_img6)
        ImageView img6;
        @BindView(R.id.widget1_img7)
        ImageView img7;
        @BindView(R.id.widget1_img8)
        ImageView img8;
        @BindView(R.id.widget1_title1)
        TextView tv1;
        @BindView(R.id.widget1_title2)
        TextView tv2;
        @BindView(R.id.widget1_title3)
        TextView tv3;
        @BindView(R.id.widget1_title4)
        TextView tv4;
        @BindView(R.id.widget1_title5)
        TextView tv5;
        @BindView(R.id.widget1_title6)
        TextView tv6;
        @BindView(R.id.widget1_title7)
        TextView tv7;
        @BindView(R.id.widget1_title8)
        TextView tv8;
        @BindView(R.id.widget1_btn1)
        LinearLayout layout1;
        @BindView(R.id.widget1_btn2)
        LinearLayout layout2;
        @BindView(R.id.widget1_btn3)
        LinearLayout layout3;
        @BindView(R.id.widget1_btn4)
        LinearLayout layout4;
        @BindView(R.id.widget1_btn5)
        LinearLayout layout5;
        @BindView(R.id.widget1_btn6)
        LinearLayout layout6;
        @BindView(R.id.widget1_btn7)
        LinearLayout layout7;
        @BindView(R.id.widget1_btn8)
        LinearLayout layout8;
        public ViewHolderType1(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getWidget_type()){
            case 1:
                return 1;
            case 2:
                return 2;
            case 5:
                return 5;
            case 3:
                return 3;
            case 9:
                return 9;
            case 4:
                return 4;
            case 8:
                return 8;
            case 7:
                return 7;
        }
        return super.getItemViewType(position);
    }
    public void notiyData(HomeBean homeBean){
        this.homeBean = homeBean;
        notifyDataSetChanged();
    }
}