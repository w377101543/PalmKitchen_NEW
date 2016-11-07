package com.gold.palm.palmkitchen_new.adapter;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.FollowBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/6.
 */

public class FollowAdapter extends RecyclerView.Adapter {
    private List<FollowBean.DataFirst.DataSecond> list;
    private Fragment fragment;
    private int loadedCount;

    public FollowAdapter(FollowBean bean, Fragment fragment) {
        list = bean.getData().getData();
        this.fragment = fragment;
        loadedCount = list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_follow, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FollowBean.DataFirst.DataSecond data = list.get(position);
        Holder h = (Holder) holder;
        Glide.with(fragment).load(data.getHead_img()).into(h.avatar);
        Glide.with(fragment).load(data.getImage()).into(h.img);
        h.topicName.setText(data.getTopics().get(0).getTopic_name());
        h.title.setText(Html.fromHtml(data.getContent()));
        h.name.setText(data.getNick());
        h.time.setText(data.getCreate_time());
        List<FollowBean.DataFirst.DataSecond.Comment> comments = data.getComment();
        if (comments.size() >= 1) {
            h.comment1.setVisibility(View.VISIBLE);
            FollowBean.DataFirst.DataSecond.Comment comment = comments.get(0);
            if (comment.getParents().size() == 0) {
                SpannableString string = new SpannableString(comment.getNick() + "：" + comment.getContent());
                string.setSpan(new ForegroundColorSpan(Color.parseColor("#FF915F")),0,comment.getNick().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                h.comment1.setText(string);
            } else {
                SpannableStringBuilder string = new SpannableStringBuilder(comment.getNick()+ " 回复 " + comment.getParents().get(0).getNick() + "：" + comment.getContent());
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#FF915F"));
                ForegroundColorSpan span2 = new ForegroundColorSpan(Color.parseColor("#FF915F"));
                string.setSpan(span,0,comment.getNick().length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                string.setSpan(span2,comment.getNick().length()+4,comment.getNick().length()+4+comment.getParents().get(0).getNick().length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                h.comment1.setText(string);
            }
        }
        if (comments.size() >= 2) {
            h.comment2.setVisibility(View.VISIBLE);
            FollowBean.DataFirst.DataSecond.Comment comment = comments.get(1);
            if (comment.getParents().size() == 0) {
                SpannableString string = new SpannableString(comment.getNick() + "：" + comment.getContent());
                string.setSpan(new ForegroundColorSpan(Color.parseColor("#FF915F")),0,comment.getNick().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                h.comment2.setText(string);
            } else {
                SpannableStringBuilder string = new SpannableStringBuilder(comment.getNick()+ " 回复 " + comment.getParents().get(0).getNick() + "：" + comment.getContent());
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#FF915F"));
                ForegroundColorSpan span2 = new ForegroundColorSpan(Color.parseColor("#FF915F"));
                string.setSpan(span,0,comment.getNick().length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                string.setSpan(span2,comment.getNick().length()+4,comment.getNick().length()+4+comment.getParents().get(0).getNick().length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                h.comment2.setText(string);
            }
        }
        if (comments.size() >= 3) {
            h.comment3.setVisibility(View.VISIBLE);
            FollowBean.DataFirst.DataSecond.Comment comment = comments.get(2);
            if (comment.getParents().size() == 0) {
                SpannableString string = new SpannableString(comment.getNick() + "：" + comment.getContent());
                string.setSpan(new ForegroundColorSpan(Color.parseColor("#FF915F")),0,comment.getNick().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                h.comment3.setText(string);
            } else {
                SpannableStringBuilder string = new SpannableStringBuilder(comment.getNick()+ " 回复 " + comment.getParents().get(0).getNick() + "：" + comment.getContent());
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#FF915F"));
                ForegroundColorSpan span2 = new ForegroundColorSpan(Color.parseColor("#FF915F"));
                string.setSpan(span,0,comment.getNick().length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                string.setSpan(span2,comment.getNick().length()+4,comment.getNick().length()+4+comment.getParents().get(0).getNick().length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                h.comment3.setText(string);
            }
        }
        h.more.setText("更多厨友热评 （" + data.getComment_count() + "）");
        h.like.setText(data.getAgree_count());
        h.reply.setText(data.getComment_count() + "");
        if(data.getLike().size()>=6){
            for (int i = 0; i < 6; i++) {
                FollowBean.DataFirst.DataSecond.Like person = data.getLike().get(i);
                View view = h.container.getChildAt(i);
                ImageView img = (ImageView) view.findViewById(R.id.follow_like_img);
                if (TextUtils.isEmpty(person.getHead_img().trim())) {
                    img.setImageResource(R.mipmap.default_head_icon);
                    continue;
                }
                Glide.with(fragment).load(person.getHead_img()).into(img);
            }
        }else {
            for (int i = 0; i < data.getLike().size(); i++) {
                FollowBean.DataFirst.DataSecond.Like person = data.getLike().get(i);
                View view = h.container.getChildAt(i);
                ImageView img = (ImageView) view.findViewById(R.id.follow_like_img);
                if (TextUtils.isEmpty(person.getHead_img().trim())) {
                    img.setImageResource(R.mipmap.default_head_icon);
                    continue;
                }
                Glide.with(fragment).load(person.getHead_img()).into(img);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.follow_img)
        ImageView img;
        @BindView(R.id.follow_topic_name)
        TextView topicName;
        @BindView(R.id.follow_title)
        TextView title;
        @BindView(R.id.follow_avatar)
        ImageView avatar;
        @BindView(R.id.follow_name)
        TextView name;
        @BindView(R.id.follow_time)
        TextView time;
        @BindView(R.id.follow_report)
        ImageView report;
        @BindView(R.id.follow_container)
        LinearLayout container;
        @BindView(R.id.follow_comment_1)
        TextView comment1;
        @BindView(R.id.follow_comment_2)
        TextView comment2;
        @BindView(R.id.follow_comment_3)
        TextView comment3;
        @BindView(R.id.follow_more_comment)
        TextView more;
        @BindView(R.id.follow_like)
        TextView like;
        @BindView(R.id.follow_replay)
        TextView reply;
        @BindView(R.id.follow_share)
        TextView share;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            more.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            param.weight = 1;
            param.gravity = Gravity.CENTER;
            for (int i = 0; i < 6; i++) {
                View view = LayoutInflater.from(fragment.getContext()).inflate(R.layout.head_follow_img, null);
                container.addView(view,param);
            }
            container.addView(LayoutInflater.from(fragment.getContext()).inflate(R.layout.head_follow_img_more, null),param);
        }
    }

    public void notifyData(FollowBean bean) {
        this.list.addAll(bean.getData().getData());
        notifyItemRangeInserted(loadedCount + 1, bean.getData().getCount());
        loadedCount += bean.getData().getCount();
    }
}
