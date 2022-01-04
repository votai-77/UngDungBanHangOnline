package com.vothanhtai.ungdungbanhangonline.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.vothanhtai.ungdungbanhangonline.Model.ChiTietSanPham;
import com.vothanhtai.ungdungbanhangonline.Model.LoaiSP;
import com.vothanhtai.ungdungbanhangonline.R;

public class DetailMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_main);

        setControl();
        setEvent();
    }

    private void setEvent() {
        Bundle bundle = getIntent().getExtras();
        if(bundle == null)
        {
            return;
        }

        LoaiSP loaiSP = (LoaiSP) bundle.get("Object");
        TextView view = findViewById(R.id.TieudeSP);
        view.setText(loaiSP.getTenloaiSP());
    }

    private void setControl() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Quaylai:
                Intent intent = new Intent(DetailMainActivity.this,Home.class);
                startActivity(intent);
                Toast.makeText(DetailMainActivity.this, "Quay lại thành công", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}