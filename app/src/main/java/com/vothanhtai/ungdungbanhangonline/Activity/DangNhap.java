package com.vothanhtai.ungdungbanhangonline.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vothanhtai.ungdungbanhangonline.R;

public class DangNhap extends AppCompatActivity {

    FirebaseAuth Auth;
    EditText edtUsername_DN, edtPassword_DN;
    Button btnDangnhap, btnDangKi;
    DrawerLayout drawerLayout;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        Auth = FirebaseAuth.getInstance();

        setControl();
        setEvent();
    }

    private void setEvent() {


        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dangki = new Intent(DangNhap.this, DangKi.class);
                startActivity(dangki);
            }
        });

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtUsername_DN.getText().toString().trim();
                String password = edtPassword_DN.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    edtUsername_DN.setError("Mời bạn nhập username");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    edtPassword_DN.setError("Mời bạn nhập password");
                    return;
                }
                progressDialog.show();
                Auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent dangnhap = new Intent(DangNhap.this, Home.class);
                            startActivity(dangnhap);
                        } else {

                            Toast.makeText(DangNhap.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }


    private void setControl() {
        edtUsername_DN = findViewById(R.id.edtUsername);
        edtPassword_DN = findViewById(R.id.edtPassword);
        btnDangnhap = findViewById(R.id.btnDangNhap);
        btnDangKi = findViewById(R.id.btnDangKi);
        drawerLayout = findViewById(R.id.nav_drawer_menu);
        progressDialog = new ProgressDialog(this);
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
            case R.id.Quaylai:
                Intent intent = new Intent(DangNhap.this, Home.class);
                startActivity(intent);
                Toast.makeText(this, "Trở về thành công", Toast.LENGTH_SHORT).show();
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
