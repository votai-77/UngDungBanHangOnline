package com.vothanhtai.ungdungbanhangonline.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentDanhMuc;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentHome;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentTaiKhoan;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentThongBao;
import com.vothanhtai.ungdungbanhangonline.Fragment.FragmentTimKiem;
import com.vothanhtai.ungdungbanhangonline.R;

public class BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);


        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(this);
        bottomNav.setSelectedItemId(R.id.Home);
        openFragment(new Fragment());


    }

    void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentHome()).commit();
                return true;
            case R.id.DanhMuc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentDanhMuc()).commit();
                return true;
            case R.id.TaiKhoan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentTaiKhoan()).commit();
                return true;
            case R.id.Thongbao:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentThongBao()).commit();
                return true;
            case R.id.TimKiem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentTimKiem()).commit();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }
}