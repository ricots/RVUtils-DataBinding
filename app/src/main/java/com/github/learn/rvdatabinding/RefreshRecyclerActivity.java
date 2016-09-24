package com.github.learn.rvdatabinding;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.github.captain_miao.rvdatabinding.BaseWrapperRecyclerAdapter;
import com.github.captain_miao.rvdatabinding.WrapperRecyclerView;
import com.github.captain_miao.rvdatabinding.common.DividerItemDecoration;
import com.github.captain_miao.uniqueadapter.library.UniquePresenter;
import com.github.learn.base.BaseListActivity;
import com.github.learn.model.TextModel;

import java.util.ArrayList;
import java.util.List;


public class RefreshRecyclerActivity extends BaseListActivity<TextModel> implements UniquePresenter<TextModel> {
    private static final String TAG = "RefreshRecyclerActivity";

    private View mEmptyView;
    @Override
    protected void initRecyclerView() {
        super.initRecyclerView();
        //addHeaderView();
        //addFooterView();
        mEmptyView = getLayoutInflater().inflate(R.layout.rv_empty_view, null);
        mWrapperRecyclerView.setEmptyView(mEmptyView);

        mEmptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RefreshRecyclerActivity.this, "onClick EmptyView", Toast.LENGTH_SHORT).show();
            }
        });

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
        return  mAdapter != null ? mAdapter : ( mAdapter = new BaseWrapperRecyclerAdapter<>());
    }

    @Override
    public boolean enablePullToLoadMore() {
        return true;
    }

    @Override
    protected void loadData() {
        new AsyncTask<Boolean, Boolean, List<TextModel>>() {
            @Override
            protected List<TextModel> doInBackground(Boolean... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (mCurrPage > 1 && mAdapter.getItemCount() > 50) {
                    return new ArrayList<>();
                } else {
                    return new ArrayList<TextModel>() {{
                        for (int i = 0; i < 15; i++) {
                            add(new TextModel(mCurrPage + " page -> " + i));
                        }
                    }};
                }
            }

            @Override
            protected void onPostExecute(List<TextModel> items) {
                if(items != null && items.size() > 0) {
                    // 加载完数据 页数+1
                    mCurrPage++;
                    if (mIsRefresh) {
                        refreshData(items);
                        onRefreshComplete();
                    } else {
                        addMoreData(items);
                        onLoadMoreComplete();
                    }
                } else {
                    if (mIsRefresh) {
                        onRefreshComplete();
                        hideLoadMoreView();
                    } else {
                        onLoadMoreComplete();
                        showNoMoreDataView();
                    }
                }
            }
        }.execute();
    }


    private void addHeaderView() {
        View mRecyclerViewHeader = LayoutInflater.from(this).inflate(R.layout.rv_header_view, null);
        mRecyclerViewHeader.findViewById(R.id.btn_header_change_color).setVisibility(View.GONE);
        mAdapter.addHeaderView(mRecyclerViewHeader, true);
    }

    private void addFooterView() {
        View mRecyclerViewHeader = LayoutInflater.from(this).inflate(R.layout.rv_footer_view, null);
        mRecyclerViewHeader.findViewById(R.id.btn_footer_change_color).setVisibility(View.GONE);
        mAdapter.addFooterView(mRecyclerViewHeader, true);
    }

    @Override
    public void onClick(View view, TextModel model) {
        switch (view.getId()){
            case R.id.tv_content:
                Toast.makeText(view.getContext(), "on click " + model.text, Toast.LENGTH_SHORT).show();
                break;
            default:
                mAdapter.remove(model);
        }
    }
}
