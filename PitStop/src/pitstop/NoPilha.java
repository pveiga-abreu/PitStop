package pitstop;

public class NoPilha {
    // ATRIBUTOS
    private Ingresso ingresso;
    private NoPilha proximo;

    // CONSTRUTOR
    public NoPilha(Ingresso i){
        this.ingresso = i;
        this.proximo = null;
    }

    // GETTERS
    public Ingresso getIngresso(){
        return this.ingresso;
    }
    public NoPilha getProximo(){
        return this.proximo;
    }
    // SETTERS
    public void setIngresso(Ingresso ingresso){
        this.ingresso = ingresso;
    }
    public void setProximo(NoPilha proximo){
        this.proximo = proximo;
    }
    
}
