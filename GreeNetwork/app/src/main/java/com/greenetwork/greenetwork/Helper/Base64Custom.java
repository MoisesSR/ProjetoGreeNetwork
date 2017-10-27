package com.greenetwork.greenetwork.Helper;

import android.util.Base64;

/**
 * Created by Win10Moises on 27/10/2017.
 */

public class Base64Custom {
    public static String codificarBase64(String texto){
        return Base64.encodeToString(texto.getBytes(), Base64.DEFAULT).replace("(\\n|\\r)","");
    }
    public static String decodificarBase64(String textoCodificador){
        return new String(Base64.decode(textoCodificador, Base64.DEFAULT));
    }
}
