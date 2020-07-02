package pitstop;

public class Pessoa {
    // ATRIBUTOS
    private String nome;
    private String celular;
    private String email;

    // CONSTRUTOR
    public Pessoa(){
        this.nome = "";
        this.celular = "";
        this.email = "";
    }

    // GETTERS
    public String getNome(){
        return this.nome;
    }
    public String getCelular(){
        return this.celular;
    }
    public String getEmail(){
        return this.email;
    }
    // SETTERS
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }
    public void setEmail(String email){
        this.email = email;
    }

}
