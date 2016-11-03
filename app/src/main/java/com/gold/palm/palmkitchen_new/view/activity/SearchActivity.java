package com.gold.palm.palmkitchen_new.view.activity;

import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.SoftSearchAdapter;
import com.gold.palm.palmkitchen_new.bean.SoftSearchBean;
import com.gold.palm.palmkitchen_new.presenter.search.SearchPresenter;
import com.gold.palm.palmkitchen_new.view.view.ISearchView;
import com.google.android.flexbox.FlexboxLayout;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Wang on 2016/11/2.
 */

public class SearchActivity extends BaseActivity implements ISearchView, TextWatcher, TextView.OnEditorActionListener {
    @BindView(R.id.search_edit)
    EditText editText;
    @BindView(R.id.search_cancel)
    TextView cancelTv;
    @BindView(R.id.search_index)
    LinearLayout layoutIndex;
    @BindView(R.id.search_history_layout)
    LinearLayout layoutHistory;
    @BindView(R.id.search_hot_layout)
    LinearLayout layoutHot;
    @BindView(R.id.search_history_flex)
    FlexboxLayout flexHistory;
    @BindView(R.id.search_hot_flex)
    FlexboxLayout flexHot;
    @BindView(R.id.search_soft_listview)
    ListView listView;
    @BindView(R.id.search_delete_img)
    ImageView deleteImg;
    private SearchPresenter presenter;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        presenter = new SearchPresenter(this, this);
        editText.addTextChangedListener(this);
        editText.setOnEditorActionListener(this);
        final List<String> hotList = presenter.getHotSearch(this);
        if(hotList != null){
            for (int i = 0; i < hotList.size(); i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.item_flex_hot, null);
                final TextView tv = (TextView) view.findViewById(R.id.search_hot_tv);
                final String text = hotList.get(i);
                tv.setText(text);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        search(text);
                        presenter.search(text);
                    }
                });
                flexHot.addView(view);
            }
        }
        initHeadAndFoot();
        presenter.getHistory();
    }

    @Override
    public void search(String word) {
        if(word.trim().isEmpty()){
            Toast.makeText(this,"请输入要搜索的菜名",Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.search(word);
        for (int i = 0; i < flexHistory.getChildCount(); i++) {
            View view = flexHistory.getChildAt(i);
            TextView tv = (TextView) view.findViewById(R.id.search_history_tv);
            if(word.equals(tv.getText().toString())){
                flexHistory.removeView(view);
                flexHistory.addView(view,0);
                return;
            }
        }
        View view = LayoutInflater.from(this).inflate(R.layout.item_flex_history, null);
        TextView tv = (TextView) view.findViewById(R.id.search_history_tv);
        tv.setText(word);
        flexHistory.addView(view,0);
        layoutHistory.setVisibility(View.VISIBLE);
    }

    @Override
    public void addHistoryData(List<String> history) {
        LayoutInflater inflater = LayoutInflater.from(this);
        Iterator<String> iterator = history.iterator();
        while (iterator.hasNext()) {
            final View view = inflater.inflate(R.layout.item_flex_history, null);
            final TextView tv = (TextView) view.findViewById(R.id.search_history_tv);
            tv.setText(iterator.next());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flexHistory.removeView(view);
                    flexHistory.addView(view,0);
                    presenter.search(tv.getText().toString());
                }
            });
            flexHistory.addView(view,0);
        }
    }

    @Override
    public void showHistory(List<String> history) {
        layoutHistory.setVisibility(View.VISIBLE);
        addHistoryData(history);
    }

    private SoftSearchAdapter adapter;

    @Override
    public void setAdapter(SoftSearchBean bean, int num) {
        adapter = new SoftSearchAdapter(bean, this);
        setHeadData(num);
        setFootData();
        listView.setAdapter(adapter);

    }

    private View headView, footView;

    private void initHeadAndFoot() {
        headView = LayoutInflater.from(this).inflate(R.layout.head_soft_search, null);
        footView = LayoutInflater.from(this).inflate(R.layout.foot_soft_search, null);
        listView.addHeaderView(headView);
        listView.addFooterView(footView);
    }

    private void setHeadData(int num) {
        TextView keyword = (TextView) headView.findViewById(R.id.search_head_keyword);
        TextView numTv = (TextView) headView.findViewById(R.id.search_head_num);
        keyword.setText(editText.getText());
        SpannableString string = new SpannableString("相关食材" + num + "个");
        string.setSpan(new ForegroundColorSpan(Color.RED), 4, string.length() - 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        numTv.setText(string);
    }

    private void setFootData() {
        TextView footTv = (TextView) footView.findViewById(R.id.foot_soft_search_tv);
        footTv.setText("想要更多关于" + editText.getText() + "的菜，请直接搜索");
    }

    @Override
    public void showNoResult() {

    }

    @Override
    public void hideHistory() {
        layoutHistory.setVisibility(View.GONE);
    }

    @Override
    public void hideIndex() {
        layoutIndex.setVisibility(View.GONE);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!s.toString().trim().isEmpty()) {
            presenter.getKeywordData(s.toString());
            listView.setVisibility(View.VISIBLE);
            layoutIndex.setVisibility(View.GONE);
            cancelTv.setText("搜索");
            deleteImg.setVisibility(View.VISIBLE);
            return;
        }
        layoutIndex.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        deleteImg.setVisibility(View.GONE);
        cancelTv.setText("取消");
    }


    @OnClick({R.id.search_cancel, R.id.search_delete_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_cancel:
                if ("取消".equals(cancelTv.getText())) {
                    onBackPressed();
                } else {
                    search(editText.getText().toString());
                }
                return;
            case R.id.search_delete_img:
                editText.setText("");
                return;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_SEARCH)) {
            search(editText.getText().toString());
        }
        return false;
    }

}
