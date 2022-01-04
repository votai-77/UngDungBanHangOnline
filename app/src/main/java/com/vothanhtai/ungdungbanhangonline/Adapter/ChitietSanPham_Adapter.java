package com.vothanhtai.ungdungbanhangonline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vothanhtai.ungdungbanhangonline.Model.LoaiSP;
import com.vothanhtai.ungdungbanhangonline.R;

import java.util.List;

public class ChitietSanPham_Adapter extends BaseAdapter {
    private Context context;
    private List<LoaiSP> data_LoaiSP;

    public ChitietSanPham_Adapter(Context context, List<LoaiSP> data_LoaiSP) {
        this.context = context;
        this.data_LoaiSP = data_LoaiSP;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_loaisp,parent,false);

        return view;
    }
    public void ViewHodel()
    {

    }
}
