package com.gold.palm.palmkitchen_new.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.bean.SoftSearchBean;

import java.util.List;

/**
 * Created by Wang on 2016/11/2.
 */

public class SoftSearchAdapter extends BaseAdapter {
    private List<SoftSearchBean.DataFirst.DataThird> list;
    private LayoutInflater inflater;
    public SoftSearchAdapter(SoftSearchBean bean, Context context) {
        inflater = LayoutInflater.from(context);
        list = bean.getData().getData();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public SoftSearchBean.DataFirst.DataThird getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_search_soft,null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.search_auto_word);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getText());
        return convertView;
    }
    static class ViewHolder{
        TextView tv;
    }
    public void clearData(){
        list.clear();
        notifyDataSetChanged();
    }
    public void setData(SoftSearchBean bean){
        this.list = bean.getData().getData();
        notifyDataSetChanged();
    }
}
