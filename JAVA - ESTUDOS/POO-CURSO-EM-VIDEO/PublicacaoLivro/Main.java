package com.mycompany.publicacaolivro;


public class Main {

    public static void main(String[] args) {
        
        Pessoa p[] = new Pessoa[2];
        Livro l[] = new Livro[2];
        
        // PESSOAS
        p[0] = new Pessoa("Sergio Luiz", "Masculino", 20);
        p[1] = new Pessoa("Maria Eduarda", "Feminino", 25);
        
        // LIVROS
        l[0] = new Livro("Java", "James Gosling", 300, p[0]);
        l[1] = new Livro("Python", "Guido van Rossum", 500, p[1]);
        
        l[0].Detalhes();
        l[0].abrir();
        l[0].folhear(250);
        l[0].Detalhes();
        
        l[1].Detalhes();
        l[1].abrir();
        l[1].avancarPag();
        l[1].Detalhes();
    }
}
