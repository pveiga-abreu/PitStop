package pitstop;

public class Pilha {
    // ATRIBUTOS
    private NoPilha topo;
    private int tamanho;

    // CONSTRUTOR
    public Pilha(){
        this.topo = null;
        this.tamanho = 0;
    }

    // GETTERS
    public NoPilha getTopo(){
        return this.topo;
    }
    public int getTamanho(){
        return this.tamanho;
    }
    // SETTERS
    public void setTopo(NoPilha novoTopo){
        this.topo = novoTopo;
    }
    public void setTamanho(int novoTamanho){
        this.tamanho = novoTamanho;
    }

    // MÉTODOS
    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return this.getTamanho() == 0;
    }
    
    // Métodos para adicionar um nó na Pilha
    public void push(Ingresso i) {
        NoPilha no = new NoPilha(i);

        // Verifica se a lista está vazia
        if (this.isEmpty())
            // Se a lista está vazia, o nó não terá próximo
            no.setProximo(null);
        else
            no.setProximo(this.getTopo());

        // Atualizando o topo da Pilha
        this.setTopo(no);
        // Atualizando tamanho da PIlha
        this.setTamanho(this.getTamanho() + 1);

    }

    // Método para remover um nó da Pilha, e retornar o Ingresso removido
    public Ingresso pop() {
        // Persiste o nó a ser removido 
        NoPilha aux = this.getTopo();
        // Altera o topo da Pilha para o próximo nó 
        this.setTopo(aux.getProximo());
        // Altera o próximo do antigo topo para nulo
        aux.setProximo(null);
        // Retorna o ingresso do nó removido
        return aux.getIngresso();
    }

    // Método para listar todos os os ingressos na pilha atual
    public void show() {
        if (this.isEmpty()) {
            System.out.println("Não há ingressos na pilha!\n");
            return;
        }

        NoPilha ing = this.getTopo();

        do {
            System.out.printf("Código: %d - Sala: %d", ing.getIngresso().getCodigo(), ing.getIngresso().getSala());
            System.out.println("\n---------------------------------\n");
            
            ing = ing.getProximo();
        } while (ing != null);

    }

}
