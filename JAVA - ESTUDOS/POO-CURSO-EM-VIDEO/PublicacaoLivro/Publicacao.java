package com.mycompany.publicacaolivro;

public interface Publicacao {
    public abstract void abrir();
    public abstract void fechar();
    public abstract void folhear(int pagDes);
    public abstract void avancarPag();
    public abstract void voltarPag();
}
