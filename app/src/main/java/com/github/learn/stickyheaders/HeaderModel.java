package com.github.learn.stickyheaders;

import com.github.captain_miao.uniqueadapter.library.ItemModel;
import com.github.learn.rvdatabinding.R;

/**
 * @author YanLu
 * @since 16/3/28
 */
public class HeaderModel implements ItemModel {
    public int categoryId;
    public String category;
    public String title;
    public String value;
    public boolean isQualified;

    public HeaderModel(int categoryId, String category, String title, String value) {
        this.categoryId = categoryId;
        this.category = category;
        this.title = title;
        this.value = value;
        this.isQualified = true;
    }

    public HeaderModel(int categoryId, String category, String title, String value, boolean isQualified) {
        this.categoryId = categoryId;
        this.category = category;
        this.title = title;
        this.value = value;
        this.isQualified = isQualified;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.rv_item_view_sticky;
    }
}
