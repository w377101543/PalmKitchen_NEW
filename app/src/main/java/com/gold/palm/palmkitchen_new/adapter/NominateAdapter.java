package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.NominateBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/11/7.
 */

public class NominateAdapter extends RecyclerView.Adapter {
    private List<NominateBean.DataFirst.ShequTopicsBean> list;
    private Fragment fragment;
    public NominateAdapter(Fragment fragment,NominateBean bean) {
        this.fragment = fragment;
        list = bean.getData().getShequ_topics();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_nominate,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder h = (Holder) holder;
        h.title.setText(list.get(position).getTopic_name());
        h.adapter.addData(list.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.nominate_title)
        TextView title;
        @BindView(R.id.item_nominate_recycler)
        RecyclerView recyclerView;
        NominateChildAdapter adapter;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            adapter = new NominateChildAdapter(fragment);
            recyclerView.setLayoutManager(new LinearLayoutManager(fragment.getActivity(),LinearLayoutManager.HORIZONTAL,false));
            recyclerView.setAdapter(adapter);
        }
    }
}
