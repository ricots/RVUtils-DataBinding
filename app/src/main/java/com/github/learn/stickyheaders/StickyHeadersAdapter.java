package com.github.learn.stickyheaders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.captain_miao.rvdatabinding.BaseWrapperRecyclerAdapter;
import com.github.learn.rvdatabinding.R;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;


/**
 * @author YanLu
 * @since 16/3/28
 */
public class StickyHeadersAdapter extends BaseWrapperRecyclerAdapter<HeaderModel>
                                    implements StickyRecyclerHeadersAdapter<StickyHeadersAdapter.HeaderItemViewHolder> {


    //Sticky Headers
    @Override
    public long getHeaderId(int position) {
        HeaderModel vo = getItem(position);
        return vo.categoryId;
    }

    @Override
    public HeaderItemViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_sticky_header_view, parent, false);
        return new HeaderItemViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderItemViewHolder holder, int position) {
        HeaderModel vo = getItem(position);
        holder.mTvTitle.setText(vo.category);
    }



    public class HeaderItemViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvTitle;

        public HeaderItemViewHolder(View view) {
            super(view);
            mTvTitle = (TextView) view.findViewById(R.id.detail_title);
        }
    }
}
