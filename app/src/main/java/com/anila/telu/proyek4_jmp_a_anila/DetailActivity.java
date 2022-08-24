package com.anila.telu.proyek4_jmp_a_anila;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anila.telu.proyek4_jmp_a_anila.helper.DBHelper;

public class DetailActivity extends AppCompatActivity {

    private DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.setTitle("Halaman Tambah Data");

        helper = new DBHelper(this);

        EditText etNama = findViewById(R.id.et_nama);
        EditText etAlamat = findViewById(R.id.et_alamat);
        Button tombol = findViewById(R.id.button);

        tombol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String alamat = etAlamat.getText().toString();
                if(nama.length() ==0 && alamat.length() ==0) {
                    Toast.makeText(DetailActivity.this,
                            "Nama atau alamat tidak boleh kosong",
                            Toast.LENGTH_SHORT).show();
                }else {
                    insert(nama, alamat);
                }
            }
        });
    }
    private void insert(String nama, String alamat) {
        helper.insert(nama, alamat);
        Toast.makeText(this, "Data diproses", Toast.LENGTH_SHORT).show();
        finish();
    }
}