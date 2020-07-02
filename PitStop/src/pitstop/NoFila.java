package pitstop;

public class NoFila {
    // ATRIBUTOS
    private Pessoa pessoa;
    private NoFila proximo;
    
    // CONSTRUTOR
    public NoFila(Pessoa p){
        this.pessoa = p;
        this.proximo = null;
    }

    // GETTERS
    public Pessoa getPessoa(){
        return this.pessoa;
    }
    public NoFila getProximo(){
        return this.proximo;
    }
    // SETTERS
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    public void setProximo(NoFila novoProximo){
        this.proximo = novoProximo;
    }

}
