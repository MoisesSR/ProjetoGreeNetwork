package com.greenetwork.greenetwork.DAO;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Win10Moises on 27/10/2017.
 */

public class ConfiguracaoFirebase {
    private static DatabaseReference refecenciaFirebase;
    private static FirebaseAuth autenticacao;

    public static DatabaseReference getFibase(){
        if (refecenciaFirebase == null){
            refecenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }
        return refecenciaFirebase;
    }
    public static FirebaseAuth getFirebaseAutenticacao(){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }
}
