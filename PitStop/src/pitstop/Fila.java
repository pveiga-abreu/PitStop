package pitstop;

public class Fila {
    // ATRIBUTOS
    private NoFila inicio;
    private NoFila fim;
    private int tamanho;

    // CONSTRUTOR
    public Fila(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    // GETTERS
    public NoFila getInicio(){
        return this.inicio;
    }
    public NoFila getFim(){
        return this.fim;
    }
    public int getTamanho(){
        return this.tamanho;
    }
    // SETTERS
    public void setInicio(NoFila novoInicio){
        this.inicio = novoInicio;
    }
    public void setFim(NoFila novoFim){
        this.fim = novoFim;
    }
    public void setTamanho(int novoTamanho){
        this.tamanho = novoTamanho;
    }

    // MÉTODOS
    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
         return ((this.getInicio() == null) && (this.getFim() == null));
    }

    // Método para adicionar novo nó na fila
    public void enqueue(Pessoa p) {
        NoFila no = new NoFila(p);
        
        // Verifica se a fila está vazia
        if (this.isEmpty()) {
            this.setInicio(no);
            this.setFim(no);
        } else {
            this.getFim().setProximo(no);
            this.setFim(no);
        }

        // Atualizar tamanho da Fila
        this.setTamanho(this.getTamanho() + 1);
    }

    // Método para remover um nó da lista, e retornar a pessoa
    public Pessoa dequeue() {
        // Verificar se a fila está vazia
        if (this.isEmpty()) {
            System.out.println("Fila vazia!\n");
            return null;
        }

        NoFila aux = this.getInicio();

        this.setInicio(aux.getProximo());
        aux.setProximo(null);
        
        this.setTamanho(getTamanho() - 1);
        return aux.getPessoa();
    }

    // Método para listar todas as pessoas na fila atual
    public void show() {
        if (this.isEmpty()) {
            System.out.println("Não há pessoas na fila!\n");
            return;
        }

        NoFila aux = this.getInicio();

        do {
            System.out.printf("Nome: %s - Telefone: %s - e-mail: %s", aux.getPessoa().getNome(), aux.getPessoa().getCelular(), aux.getPessoa().getEmail());
            System.out.println("\n----------------------------------------\n");
            
            aux = aux.getProximo();
        } while (aux != null);
    }

}
