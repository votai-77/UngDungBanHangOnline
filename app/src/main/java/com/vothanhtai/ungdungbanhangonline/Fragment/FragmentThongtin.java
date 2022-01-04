package com.vothanhtai.ungdungbanhangonline.Fragment;

import static com.vothanhtai.ungdungbanhangonline.Activity.Home.My_ReQuest_Code;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Magnifier;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vothanhtai.ungdungbanhangonline.Activity.Home;
import com.vothanhtai.ungdungbanhangonline.R;

public class FragmentThongtin extends Fragment {
    View view;
    ImageView image;
    EditText edtTen, edtEmail;
    Button btnCapnhat;

    public FragmentThongtin() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thongtin, container, false);
        setControl();
        hienthithongtin();
        setEvent();
        return view;
    }

    private void setEvent() {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chọn hình
                onClickRequest();
            }
        });
    }

    private void onClickRequest() {
        Home home = (Home) getActivity();
        if (home == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            home.openGallery();
            return;
        }
        if (getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            home.openGallery();

        } else {
            String[] permisstion = {Manifest.permission.READ_EXTERNAL_STORAGE};
            getActivity().requestPermissions(permisstion, My_ReQuest_Code);
        }
    }

    private void hienthithongtin() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return;
        }
        edtTen.setText(user.getDisplayName());
        edtEmail.setText(user.getEmail());
        Glide.with(getActivity()).load(user.getPhotoUrl()).error(R.drawable.giay).into(image);
    }

    private void setControl() {
        image = view.findViewById(R.id.myprofile_image_avatar);
        edtTen = view.findViewById(R.id.myprofile_fullname);
        edtEmail = view.findViewById(R.id.myprofile_email);
        btnCapnhat = view.findViewById(R.id.btn_myprofile_capnhat);
    }

    public void setBitmapImageview(Bitmap bitmapImageview){
        image.setImageBitmap(bitmapImageview);
    }
}
