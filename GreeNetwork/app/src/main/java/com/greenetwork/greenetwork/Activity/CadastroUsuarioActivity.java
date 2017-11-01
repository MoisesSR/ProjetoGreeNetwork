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
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.greenetwork.greenetwork.Model.Usuarios;
import com.greenetwork.greenetwork.DAO.ConfiguracaoFirebase;
import com.greenetwork.greenetwork.Helper.Base64Custom;
import com.greenetwork.greenetwork.Helper.Preferencias;
import com.greenetwork.greenetwork.R;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private EditText editConfirmarSenha;
    private EditText editNome;
    private EditText editApelido;
    private Usuarios usuarios;
    private Button bntGravar;
    private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        Intent intent = getIntent();
        editEmail = (EditText) findViewById(R.id.editEmail);
        editSenha = (EditText) findViewById(R.id.edtSenha);
        editConfirmarSenha = (EditText) findViewById(R.id.editConfirmarSenha);
        editNome = (EditText) findViewById(R.id.editNome);
        editApelido = (EditText) findViewById(R.id.editApelido);
        bntGravar = (Button) findViewById(R.id.btnCadastrar);
        bntGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editSenha.getText().toString().equals(editConfirmarSenha.getText().toString())){
                    usuarios = new Usuarios();
                    usuarios.setNome(editNome.getText().toString());
                    usuarios.setApelido(editApelido.getText().toString());
                    usuarios.setEmail(editEmail.getText().toString());
                    usuarios.setSenha(editSenha.getText().toString());
                }else {
                    Toast.makeText(CadastroUsuarioActivity.this,"As senhas não são iguais", Toast.LENGTH_LONG).show();
                }
                cadastroUsuario();
            }
        });
    }
    private void cadastroUsuario(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuarios.getEmail(),
                usuarios.getSenha()
        ).addOnCompleteListener(CadastroUsuarioActivity.this , new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CadastroUsuarioActivity.this,"Usuario Cadastrado com sucesso", Toast.LENGTH_LONG).show();
                    String identificadorUsuario = Base64Custom.codificarBase64(usuarios.getEmail());
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    usuarios.setId(identificadorUsuario);
                    usuarios.Salvar();

                    Preferencias preferencias = new Preferencias(CadastroUsuarioActivity.this);
                    preferencias.salvarUsuarioPrefencias(identificadorUsuario, usuarios.getNome());

                    AbrirLoginUsuario();
                }else {
                    String erroExeccao;
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthActionCodeException erro){
                        erroExeccao = "Digite uma senha mais forte, contento no minino 8 caracteres de letras e numeros";
                    }
                    catch (FirebaseAuthInvalidCredentialsException erro){
                        erroExeccao = "O E-mail digitado é invalido, digite um novo E-mail";
                    }
                    catch (FirebaseAuthUserCollisionException erro){
                        erroExeccao = "Esse E-mail já está cadastrado";
                    }
                    catch (Exception erro){
                        erroExeccao = "Erro ao efetuar o cadastro";
                        erro.printStackTrace();
                    }
                    Toast.makeText(CadastroUsuarioActivity.this,"Erro: " + erroExeccao , Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    public void AbrirLoginUsuario(){
        Intent intentLogin = new Intent(CadastroUsuarioActivity.this, LoginActivity.class);
        startActivity(intentLogin);
    }
}
