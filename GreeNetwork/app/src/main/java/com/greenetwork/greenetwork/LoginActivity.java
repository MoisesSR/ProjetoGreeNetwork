package com.greenetwork.greenetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnLogar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail = (EditText) findViewById(R.id.editLogin);
        edtSenha = (EditText) findViewById(R.id.editSenha);
        btnLogar = (Button) findViewById(R.id.btnEntrar);
        btnLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick (View v){
                if (edtEmail.getText().toString().equals("") && edtSenha.getText().toString().equals("")){

                }else{
                    Toast.makeText(LoginActivity.this, "Preença os campos de Email e Senha", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}
