package com.vothanhtai.ungdungbanhangonline.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vothanhtai.ungdungbanhangonline.Activity.DangNhap;
import com.vothanhtai.ungdungbanhangonline.Activity.Home;
import com.vothanhtai.ungdungbanhangonline.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checklogin();
            }
        },2000);
    }

    private void checklogin() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null)
        {
            //chua login
            Intent intent = new Intent(this, DangNhap.class);
            startActivity(intent);
        }
        else {
            // đãng đăng nhập
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
        finish();
    }
}