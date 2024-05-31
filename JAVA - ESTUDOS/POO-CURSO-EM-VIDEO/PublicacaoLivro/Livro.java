package com.mycompany.publicacaolivro;

public class Livro implements Publicacao{
    private String titulo, autor;
    private int totPaginas, pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int totPaginas, Pessoa leitor) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setTotPaginas(totPaginas);
        this.setPagAtual(0);
        this.setAberto(false);
        this.setLeitor(leitor);
    }
      
    private String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String getAutor() {
        return autor;
    }

    private void setAutor(String autor) {
        this.autor = autor;
    }

    private int getTotPaginas() {
        return totPaginas;
    }

    private void setTotPaginas(int totPaginas) {
        this.totPaginas = totPaginas;
    }

    private int getPagAtual() {
        return pagAtual;
    }

    private void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    private boolean isAberto() {
        return aberto;
    }

    private void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    private Pessoa getLeitor() {
        return leitor;
    }

    private void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }
    
    public void Detalhes(){
        System.out.println();
        System.out.println("### DETALHES ###");        
        System.out.println("Livro: " + this.getTitulo());
        System.out.println("Autor: " + this.getAutor());
        System.out.println("Total de paginas: " + this.getTotPaginas());
        System.out.println("Pagina atual: " + this.getPagAtual());
        System.out.println("Esta aberto? " + (this.isAberto() ? "Aberto" : "Fechado"));
        System.out.println("Leitor: " + this.getLeitor().getNome() + " de " + this.getLeitor().getIdade() + " anos e sexo " + this.getLeitor().getSexo());
        System.out.println();
    }

    @Override
    public void abrir() {
        if(this.isAberto() == false){
            System.out.println("Abrindo o livro " + this.getTitulo());
            this.setAberto(true);
        }else{
            System.out.println("Impossivel abrir um livro ja aberto");
        }
    }

    @Override
    public void fechar() {
        if(this.isAberto() == true){
            System.out.println("Fechando o livro " + this.getTitulo());
            this.setAberto(false);
        }else{
            System.out.println("Impossivel fechar um livro ja fechado");
        }
    }

    @Override
    public void folhear(int pagDes) {
        if(this.isAberto() == true){
            if(pagDes <= this.getTotPaginas()){
                System.out.println("Folheando ate a pagina " + pagDes);
                this.setPagAtual(pagDes);
            }else{
                System.out.println("Impossivel folhear o livro ate a pagina digitada");
            }
        }else{
            System.out.println("Livro fechado favor abrir");
        }
    }

    @Override
    public void avancarPag() {
        if(this.isAberto() == true){
            if(this.getPagAtual() < this.getTotPaginas()){
                System.out.println("Avancando uma pagina");
                this.setPagAtual(this.getPagAtual() + 1);
            }else{
                System.out.println("Livro ja na ultima pagina");
            }
        }else {
            System.out.println("Livro fechado favor abrir");
        }
    }

    @Override
    public void voltarPag() {
        if(this.isAberto() == true){
            if(this.getPagAtual() > 0){
                System.out.println("Voltando uma pagina");
                this.setPagAtual(this.getPagAtual() - 1);
            }else {
                System.out.println("Livro na primeira pagina");
            }
        }else {
            System.out.println("Livro fechado favor abrir");
        }
    }
}
