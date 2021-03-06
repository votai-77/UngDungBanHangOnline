package com.vothanhtai.ungdungbanhangonline.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vothanhtai.ungdungbanhangonline.Model.Thongtin_DangKi;
import com.vothanhtai.ungdungbanhangonline.R;

public class DangKi extends AppCompatActivity {

    EditText edtTendangnhap, edthoten, edtSdt, edtDiachi, edtMatkhau, edtNhaplaimatkhau, edtEmail;
    Button btnTieptuc, btnHuy;
    FirebaseAuth Auth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        Auth = FirebaseAuth.getInstance();

        setControl();
        setEvent();
    }

    private void setEvent() {
        Thongtin_DangKi thongtinDangKi = new Thongtin_DangKi();
        thongtinDangKi.setTen(edtTendangnhap.getText().toString());
        thongtinDangKi.setHovaten(edthoten.getText().toString());
        thongtinDangKi.setSDT(edtSdt.getText().toString());
        thongtinDangKi.setDiachi(edtDiachi.getText().toString());
        thongtinDangKi.setMatkhau(edtMatkhau.getText().toString());
        thongtinDangKi.setNhaplaimatkhau(edtNhaplaimatkhau.getText().toString());
        thongtinDangKi.setEmail(edtEmail.getText().toString());


        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tendangnhap = edtTendangnhap.getText().toString().trim();
                String hovaten = edthoten.getText().toString().trim();
                String sodienthoai = edtSdt.getText().toString().trim();
                String diachi = edtDiachi.getText().toString().trim();
                String matkhau = edtMatkhau.getText().toString().trim();
                String nhaplaimatkhau = edtNhaplaimatkhau.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                if (TextUtils.isEmpty(tendangnhap)) {
                    edtTendangnhap.setError("M???i b???n nh???p t??n ????ng nh???p");
                    return;
                }
                if (TextUtils.isEmpty(hovaten)) {
                    edthoten.setError("M???i b???n nh???p h??? v?? t??n");
                    return;
                }
                if (TextUtils.isEmpty(sodienthoai)) {
                    edtSdt.setError("M???i b???n nh???p s??? ??i???n tho???i");
                    return;
                }
                if (TextUtils.isEmpty(diachi)) {
                    edtDiachi.setError("M???i b???n nh???p ?????a ch???");
                    return;
                }
                if (TextUtils.isEmpty(matkhau)) {
                    edtMatkhau.setError("M???i b???n nh???p m???t kh???u");
                    return;
                }
                if (TextUtils.isEmpty(nhaplaimatkhau)) {
                    edtNhaplaimatkhau.setError("M???i b???n nh???p l???i m???t kh???u");
                    return;

                }
                if (TextUtils.isEmpty(nhaplaimatkhau)) {
                    edtNhaplaimatkhau.setError("M???t kh???u kh??ng ????ng");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    edtEmail.setError("M???i b???n nh???p email");
                    return;
                }
                progressDialog.show();
                Auth.createUserWithEmailAndPassword(email, matkhau).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(DangKi.this, "????ng k?? th??nh c??ng", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(DangKi.this, DangNhap.class);
                            startActivity(intent1);
                        } else {
                            Toast.makeText(DangKi.this, "????ng k?? th???t b???i", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);
                Toast.makeText(DangKi.this, "Quay l???i th??nh c??ng", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setControl() {
        edtTendangnhap = findViewById(R.id.nhaptentaikhoan_DK);
        edthoten = findViewById(R.id.hovaten_DK);
        edtSdt = findViewById(R.id.sodienthoai_DK);
        edtDiachi = findViewById(R.id.diachi_DK);
        edtMatkhau = findViewById(R.id.matkhau_DK);
        edtNhaplaimatkhau = findViewById(R.id.nhaplaimatkhau_DK);
        edtEmail = findViewById(R.id.email_DK);
        btnTieptuc = findViewById(R.id.btnTieptuc);
        btnHuy = findViewById(R.id.btnHuy);
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
                Intent intent = new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);
                Toast.makeText(this, "Tr??? v??? th??nh c??ng", Toast.LENGTH_SHORT).show();
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}