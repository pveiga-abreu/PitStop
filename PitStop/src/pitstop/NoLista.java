package pitstop;

public class NoLista {
    // ATRIBUTOS
    private NoLista anterior;
    private NoLista proximo;
    private Pessoa pessoa;
    private Ingresso ingresso;

    // CONSTRUTOR
    public NoLista(Pessoa p, Ingresso i){
        this.anterior = null;
        this.proximo = null;
        this.pessoa = p;
        this.ingresso = i;
    }

    // GETTERS
    public NoLista getAnterior(){
        return this.anterior;
    }
    public NoLista getProximo(){
        return this.proximo;
    }
    public Pessoa getPessoa(){
        return this.pessoa;
    }
    public Ingresso getIngresso(){
        return this.ingresso;
    }
    // SETTERS
    public void setAnterior(NoLista novoAnterior){
        this.anterior = novoAnterior;
    }
    public void setProximo(NoLista novoProximo){
        this.proximo = novoProximo;
    }
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
    public void setIngresso(Ingresso ingresso){
        this.ingresso = ingresso;
    }

}
