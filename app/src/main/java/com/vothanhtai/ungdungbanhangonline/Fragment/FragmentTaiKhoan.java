package com.vothanhtai.ungdungbanhangonline.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vothanhtai.ungdungbanhangonline.R;

public class FragmentTaiKhoan extends Fragment {

    public FragmentTaiKhoan() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_taikhoan,container,false);
    }
}
