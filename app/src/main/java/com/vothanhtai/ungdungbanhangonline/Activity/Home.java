package com.vothanhtai.ungdungbanhangonline.Activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;
import com.vothanhtai.ungdungbanhangonline.Adapter.LoaiSP_Adapter;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentDanhMuc;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentHome;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentTaiKhoan;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentThongBao;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentThongtin;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentTimKiem;
import com.vothanhtai.ungdungbanhangonline.Model.LoaiSP;
import com.vothanhtai.ungdungbanhangonline.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationDrawer;
    private RecyclerView recyclerView;
    ListView listView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ImageView imageview_nav_header;
    TextView txtTen, txtEmail;
    LoaiSP_Adapter loaiSP_adapter;

    public static final int My_ReQuest_Code = 10;
    private static final int FRAGMENT_HOME = 1;
    private static final int FRAGMENT_DANHMUC = 2;
    private static final int FRAGMENT_THONGBAO = 3;
    private static final int FRAGMENT_TIMKIEM = 4;
    private static final int FRAGMENT_TAIKHOAN = 5;
    private static final int FRAGMENT_THONGTIN = 6;
    private int mCurrentFragment = FRAGMENT_HOME;
    final private FragmentThongtin mFragmentThongtin = new FragmentThongtin();

    final private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                if (intent == null) {
                    return;
                }
                Uri uri = intent.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    mFragmentThongtin.setBitmapImageview(bitmap);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setControl();
        loaiSP_adapter = new LoaiSP_Adapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        loaiSP_adapter.setData(this,getListLoaiSP());
        recyclerView.setAdapter(loaiSP_adapter);


        setEvent();
//        ActionBar();
//        ActionViewFlipper();
//        hienthithongtinUser();
    }

    private void setEvent() {

        ActionViewFlipper();
        ActionBar();
        hienthithongtinUser();
    }

    private List<LoaiSP> getListLoaiSP() {
        List<LoaiSP> datalist_loaisp = new ArrayList<>();
        datalist_loaisp.add(new LoaiSP(1, "Giay nam", R.drawable.giay, "1000"));
        datalist_loaisp.add(new LoaiSP(1, "Giay nam", R.drawable.giay, "2000"));
        datalist_loaisp.add(new LoaiSP(1, "Giay nam", R.drawable.giay, "3000"));
        datalist_loaisp.add(new LoaiSP(1, "Giay nam", R.drawable.giay, "4000"));
        datalist_loaisp.add(new LoaiSP(1, "Giay nam", R.drawable.giay, "4000"));
        datalist_loaisp.add(new LoaiSP(1, "Giay nam", R.drawable.giay, "4000"));
        datalist_loaisp.add(new LoaiSP(1, "Giay nam", R.drawable.giay, "4000"));
        return datalist_loaisp;
    }

    private void ActionViewFlipper() {
        ArrayList<String> arrayList_quangcao = new ArrayList<>();
        arrayList_quangcao.add("https://tse3.mm.bing.net/th?id=OIP.vJpBMqVNae5GNJ33bwa7zAHaE2&pid=Api&P=0&w=238&h=157");
        arrayList_quangcao.add("https://tse4.mm.bing.net/th?id=OIP.bBmrLy-wpchPE8VyxndfxQHaEo&pid=Api&P=0&w=249&h=156");
        arrayList_quangcao.add("https://mtrend.vn/wp-content/uploads/2016/08/hinh-anh-song-nui-thien-nhien-8.jpg");
        arrayList_quangcao.add("https://thuthuatnhanh.com/wp-content/uploads/2020/03/hinh-anh-bai-bien-mua-he-dep.jpg");
        for (int i = 0; i < arrayList_quangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.get().load(arrayList_quangcao.get(i)).into(imageView);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);

    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationDrawer.setNavigationItemSelectedListener(this);
        replaceFragment(new FragmentHome());
        navigationDrawer.getMenu().findItem(R.id.QuanLyDonHang).setChecked(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_homemanhinhchinh, fragment);
        fragmentTransaction.commit();
    }

    private void hienthithongtinUser() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return;
        } else {
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photo = user.getPhotoUrl();
            if (name == null) {
                txtTen.setVisibility(View.GONE);

            } else {
                txtTen.setVisibility(View.VISIBLE);
                txtTen.setText(name);
            }
            txtEmail.setText(email);
            Glide.with(this).load(photo).error(R.drawable.giay).into(imageview_nav_header);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Home) {
            if (mCurrentFragment != FRAGMENT_HOME) {
                replaceFragment(new FragmentHome());
                mCurrentFragment = FRAGMENT_HOME;
            }
        } else if (id == R.id.DanhMuc) {
            if (mCurrentFragment != FRAGMENT_DANHMUC) {
                replaceFragment(new FragmentDanhMuc());
                mCurrentFragment = FRAGMENT_DANHMUC;
            }
        } else if (id == R.id.Thongbao) {
            if (mCurrentFragment != FRAGMENT_THONGBAO) {
                replaceFragment(new FragmentThongBao());
                mCurrentFragment = FRAGMENT_THONGBAO;
            }

        } else if (id == R.id.MyProfile) {
            if (mCurrentFragment != FRAGMENT_THONGTIN) {
                replaceFragment(mFragmentThongtin);
                mCurrentFragment = FRAGMENT_THONGTIN;
            }

        } else if (id == R.id.TimKiem) {
            if (mCurrentFragment != FRAGMENT_TIMKIEM) {
                replaceFragment(new FragmentTimKiem());
                mCurrentFragment = FRAGMENT_TIMKIEM;
            }

        } else if (id == R.id.DangXuat) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, DangNhap.class);
            startActivity(intent);
            finish();


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == My_ReQuest_Code) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
                Toast.makeText(this, "Chưa cho phép truy cập", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        activityResultLauncher.launch(Intent.createChooser(intent, "Select Picture"));
    }


    private void setControl() {
        toolbar = findViewById(R.id.toolbar_manhinhchinh);
        viewFlipper = findViewById(R.id.viewflipper_manhinhchinh);
        navigationDrawer = findViewById(R.id.nav_drawer_manhinhchinh);
        recyclerView = findViewById(R.id.recyclerview);
        drawerLayout = findViewById(R.id.drawer_manhinhchinh);
        listView = findViewById(R.id.lvDanhsach);

        imageview_nav_header = navigationDrawer.getHeaderView(0).findViewById(R.id.image_nav_header);
        txtTen = navigationDrawer.getHeaderView(0).findViewById(R.id.hoten_nav_header);
        txtEmail = navigationDrawer.getHeaderView(0).findViewById(R.id.email_nav_header);
    }
}