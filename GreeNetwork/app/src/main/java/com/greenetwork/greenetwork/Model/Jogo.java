package com.greenetwork.greenetwork.Model;

/**
 * Created by Win10Moises on 31/10/2017.
 */

public class Jogo {
    private int idJogo;
    private int pontuacaoJogo;
    private Usuarios Usuario;
    private int idAssunto;
    private int modoDeJogo;

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getPontuacaoJogo() {
        return pontuacaoJogo;
    }

    public void setPontuacaoJogo(int pontuacaoJogo) {
        this.pontuacaoJogo = pontuacaoJogo;
    }

    public Usuarios getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuarios usuario) {
        Usuario = usuario;
    }

    public int getIdAssunto() {
        return idAssunto;
    }

    public void setIdAssunto(int idAssunto) {
        this.idAssunto = idAssunto;
    }

    public int getModoDeJogo() {
        return modoDeJogo;
    }

    public void setModoDeJogo(int modoDeJogo) {
        this.modoDeJogo = modoDeJogo;
    }

    public Jogo() {
    }
}
