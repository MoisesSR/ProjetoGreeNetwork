package com.greenetwork.greenetwork.Helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Win10Moises on 27/10/2017.
 */

public class Preferencias {
    private Context contex;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "projetoFirebase";
    private int MODE = 0;
    private  SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "identificarUsuarioLogado";
    private String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias (Context context){
        this.contex = context;
        preferences = contex.getSharedPreferences(NOME_ARQUIVO, MODE );
        editor = preferences.edit();
    }

    public void salvarUsuarioPrefencias(String identificadorUsuario, String nomeUsuario){
        editor.putString(CHAVE_IDENTIFICADOR, identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }
    public String getNOME(){
        return preferences.getString(CHAVE_NOME, null);
    }
}
