package com.greenetwork.greenetwork.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.greenetwork.greenetwork.Classes.Usuarios;
import com.greenetwork.greenetwork.DAO.ConfiguracaoFirebase;
import com.greenetwork.greenetwork.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private Button btnLogar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
        btnLogar = (Button) findViewById(R.id.btnEntrar);
        btnLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick (View v){
                if (!editEmail.getText().toString().equals("") && !editSenha.getText().toString().equals("")){
                    usuarios = new Usuarios();
                    usuarios.setEmail(editEmail.getText().toString());
                    usuarios.setSenha(editSenha.getText().toString());
                    ValidarLogin();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Preença os campos de Email e Senha", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    private void ValidarLogin(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuarios.getEmail(),
                usuarios.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
             if (task.isSuccessful()){
                 Toast.makeText(LoginActivity.this, "Login efetuado com Sucesso", Toast.LENGTH_SHORT).show();
                 abrirTelaPrincinpal();
             }else{
                 Toast.makeText(LoginActivity.this, "Senha ou Email Incorreto", Toast.LENGTH_SHORT).show();
             }
            }
        });
    }
    public void abrirTelaPrincinpal(){
        Intent intentAbrirPrincinpal = new Intent(LoginActivity.this, PrincinpalActivity.class);
        startActivity(intentAbrirPrincinpal);
    }
    public void onClickCadastrar(View Cadastrar ){
        Intent intentCadastrar = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(intentCadastrar);
    }

}
