package com.baiiu.dropdownmenu;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class ListAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public ListAdapter(List<String> data) {
        super(R.layout.item_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.txt_content,item);
    }
}
