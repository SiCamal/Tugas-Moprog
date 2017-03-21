package com.sicamal.tugas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void klikButton(View v){
        EditText etNama = (EditText) findViewById(R.id.etNama);

        String panjang = etNama.getText().toString();


        Intent intent2 = getIntent();
        intent2.putExtra("strings", panjang);
        setResult(RESULT_OK, intent2);
        finish();

    }
}
