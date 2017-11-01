package com.greenetwork.greenetwork.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.greenetwork.greenetwork.R;

public class PrincinpalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princinpal);
        Intent intent = getIntent();
    }
}
