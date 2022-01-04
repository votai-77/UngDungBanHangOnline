package com.vothanhtai.ungdungbanhangonline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vothanhtai.ungdungbanhangonline.Activity.DetailMainActivity;
import com.vothanhtai.ungdungbanhangonline.Model.LoaiSP;
import com.vothanhtai.ungdungbanhangonline.R;

import java.util.ArrayList;
import java.util.List;

public class LoaiSP_Adapter extends RecyclerView.Adapter<LoaiSP_Adapter.LoaiSPViewHolder> {
    private Context context;
    private List<LoaiSP> data_LoaiSP;
    private RecyclerView recyclerView;
    public LoaiSP_Adapter(Context context) {
        this.context = context;
    }

    public void setData(Context context,List<LoaiSP> list) {
        this.context = context;
        this.data_LoaiSP = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LoaiSPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_loaisp, parent, false);
        return new LoaiSPViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiSPViewHolder holder, int position) {
        final LoaiSP loaiSP = data_LoaiSP.get(position);
        if (loaiSP == null) {
            return;
        }


        holder.tv_Image.setImageResource(loaiSP.getHinhanhloaiSP());
        holder.tv_Ten.setText(loaiSP.getTenloaiSP());
        holder.tv_Gia.setText(loaiSP.getGiaLoaiSP());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDetail(loaiSP);
            }
        });
    }
    private void onClickDetail(LoaiSP loaiSP)
    {
        Intent intent = new Intent(context, DetailMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Object",loaiSP);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        if (data_LoaiSP != null)
        {
            return data_LoaiSP.size();
        }
        return 0;
    }


    public class LoaiSPViewHolder extends RecyclerView.ViewHolder {

        private ImageView tv_Image;
        private TextView tv_Ten;
        private TextView tv_Gia;
        private CardView cardview;

        public LoaiSPViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Image = itemView.findViewById(R.id.tv_ImageView_LoaiSP);
            tv_Ten = itemView.findViewById(R.id.tv_TenLoaiSP);
            tv_Gia = itemView.findViewById(R.id.tv_GiaLoaiSP);
            recyclerView = itemView.findViewById(R.id.recyclerview);
            cardview = itemView.findViewById(R.id.cardview);
        }
    }
}
