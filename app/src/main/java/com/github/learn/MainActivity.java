package com.github.learn;

import android.content.Intent;
import android.view.View;

import com.github.captain_miao.rvdatabinding.BaseWrapperRecyclerAdapter;
import com.github.captain_miao.rvdatabinding.WrapperRecyclerView;
import com.github.captain_miao.rvdatabinding.common.DividerItemDecoration;
import com.github.captain_miao.uniqueadapter.library.UniquePresenter;
import com.github.learn.base.BaseListActivity;
import com.github.learn.model.TextModel;
import com.github.learn.rvdatabinding.R;
import com.github.learn.rvdatabinding.RefreshRecyclerActivity;
import com.github.learn.stickyheaders.StickyHeadersActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class MainActivity extends BaseListActivity<TextModel> implements UniquePresenter<TextModel> {

    private LinkedHashMap<String, Class> data = new LinkedHashMap<>();

    public boolean isShowHomeAsUp() {
        return false;
    }

    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        ArrayList<TextModel> items = new ArrayList<>();
        initList();
        for (Map.Entry<String, Class> entry : data.entrySet()) {
            String key = entry.getKey();
            items.add(new TextModel(key));
        }
        mAdapter.addAll(items);

        mAdapter.setPresenter(this);

        mWrapperRecyclerView.addItemDecoration(new DividerItemDecoration(this));
    }



    @Override
    protected int getLayoutResID() {
        return R.layout.act_recycler_view;
    }


    @Override
    protected WrapperRecyclerView getRecyclerView() {
        return mWrapperRecyclerView != null ? mWrapperRecyclerView
                : (mWrapperRecyclerView = (WrapperRecyclerView) findViewById(R.id.recycler_view));
    }

    @Override
    protected BaseWrapperRecyclerAdapter<TextModel> getWrapperRecyclerAdapter() {
        return mAdapter != null ? mAdapter : ( mAdapter = new BaseWrapperRecyclerAdapter<>());
    }


    @Override
    public boolean enablePullToLoadMore() {
        return false;
    }


    @Override
    public boolean enablePullToRefresh() {
        return false;
    }

    @Override
    protected void loadData() {

    }


    public void initList() {
        data.put(getString(R.string.label_action_label_recycler_view), RefreshRecyclerActivity.class);
        data.put(getString(R.string.label_action_label_sticky_header_view), StickyHeadersActivity.class);
    }

    @Override
    public void onClick(View view, TextModel itemModel) {
        Intent intent = new Intent(MainActivity.this, data.get(itemModel.text));

        startActivity(intent);
    }
}
