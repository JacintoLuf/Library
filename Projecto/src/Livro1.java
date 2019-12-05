public class Livro {
    private String nome;
    private String categoria;

    public Livro(String nome, String categoria){
        this.nome = nome;
        this.categoria = categoria;
    }

    public String nome(){ return nome;}
    public String getCategoria(){ return categoria;}
}
