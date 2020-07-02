package pitstop;

public class Lista {
    // ATRIBUTOS
    private NoLista inicio;
    private NoLista fim;
    private int tamanho;

    // CONSTRUTOR
    public Lista(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    // GETTERS
    public NoLista getInicio(){
        return this.inicio;
    }
    public NoLista getFim(){
        return this.fim;
    }
    public int getTamanho(){
        return this.tamanho;
    }
    // SETTERS
    public void setInicio(final NoLista novoInicio) {
        this.inicio = novoInicio;
    }
    public void setFim(final NoLista novoFim) {
        this.fim = novoFim;
    }
    public void setTamanho(final int novoTamanho) {
        this.tamanho = novoTamanho;
    }

    // MÉTODOS
    // Método para verificar se a lista está vazia
    public boolean isEmpty() {
        return this.getTamanho() == 0;
    }

    // Método para limpar a lista
    public void clear(){
        if ( !this.isEmpty() ) {
            this.setInicio(null);
            this.setFim(null);
            this.setTamanho(0);
        }
    }

    // Método para inserir um espectador na lista
    public void insert(final Pessoa p, final Ingresso i, int pos) {
        if(!((pos < 0) || (pos > this.getTamanho()))) {
            
            NoLista no = new NoLista(p, i);

            // Se a lista estiver vazia
            if(this.isEmpty()) {
                this.setInicio(no);
                this.setFim(no);
            } 
            // Se a inserção for na primeira posição
            else if (pos == 0) {
                    no.setProximo(this.getInicio());
                    this.getInicio().setAnterior(no);
                    this.setInicio(no);
            }
            // Se a inserção for no fim da lista
            else if (pos == this.getTamanho()) {
                no.setAnterior(this.getFim());
                this.getFim().setProximo(no);
                this.setFim(no);
            }
            // Se a inserção for no meio da lista
            else {
                NoLista aux = this.getInicio();
                // Iterar até a posição anterior a que vai ser inserido o novo nó
                for(int x = 0; x < (pos - 1); x++) {
                    aux = aux.getProximo();
                }
                no.setProximo(aux.getProximo());
                aux.getProximo().setAnterior(no);
                aux.setProximo(no);
                no.setAnterior(aux);
            }

            this.setTamanho(this.getTamanho() + 1);
            System.out.println("Inserção realizada com sucesso!\n");

        } else {
            System.out.println("Não foi possível realizar a inserção!\n");
        }
    }

    // Método para remover um espectador da lista pelo código do ingresso
    public Ingresso remove(int cod) {
        if((!(this.isEmpty())) && (cod > 0) && (cod <= 75)) {
            
            // Se a lista tiver apenas um nó
            if((this.getTamanho() == 1) && (cod == this.getInicio().getIngresso().getCodigo())) {
                NoLista aux = this.getInicio();

                this.setInicio(null);
                this.setFim(null);
                
                this.setTamanho(this.getTamanho() - 1);
                System.out.println("Ingresso: " + cod + " removido com Sucesso!\n");
                return aux.getIngresso();
            }
            // Se a remoção for no primeiro nó
            else if (cod == this.getInicio().getIngresso().getCodigo()){
                NoLista aux = this.getInicio();

                aux.getProximo().setAnterior(null);
                this.setInicio(aux.getProximo());
                aux.setProximo(null);
                
                this.setTamanho(this.getTamanho() - 1);
                System.out.println("Ingresso: " + cod + " removido com Sucesso!\n");
                return aux.getIngresso();
            }
            // Se a remoção for no último nó
            else if (cod == this.getFim().getIngresso().getCodigo()){
                NoLista aux = this.getFim();

                aux.getAnterior().setProximo(null);
                this.setFim(aux.getAnterior());
                aux.setAnterior(null);
                
                this.setTamanho(this.getTamanho() - 1);
                System.out.println("Ingresso: " + cod + " removido com Sucesso!\n");
                return aux.getIngresso();
            }
            else {
                NoLista aux = this.getInicio();

                while(true) {
                    if (cod == aux.getIngresso().getCodigo()){
                        // O nó posterior ao nó removido, vai apontar para o nó anterior ao nó removido
                        aux.getProximo().setAnterior(aux.getAnterior());
                        // O nó anterior ao nó removido, vai apontar para o nó posterior ao nó removido
                        aux.getAnterior().setProximo(aux.getProximo());
                        // Limpar os acessos do nó removido
                        aux.setAnterior(null);
                        aux.setProximo(null);
                        this.setTamanho(this.getTamanho() - 1);
                        System.out.println("Ingresso: " + cod + " removido com Sucesso!\n");
                        return aux.getIngresso();
                    } else {
                        aux = aux.getProximo();
                        if (aux == null) {
                            System.out.println("Ingresso " + cod + " ainda não foi distribuído!\n");
                            return null;
                        }
                    }
                }
            }
        } else {
            System.out.println("Não é possível remover o item da lista!\n");
            return null;
        }
    }

    // Método para listar todas as pessoas e seus respectivos ingressos
    public void show() {
        if (this.isEmpty()) {
            System.out.println("Não há ninguém nas salas!\n\n");
            return;
        }

        NoLista aux = this.getInicio();

        do {
            System.out.printf("Nome: %s - Telefone: %s - e-mail: %s", aux.getPessoa().getNome(), aux.getPessoa().getCelular(), aux.getPessoa().getEmail());
            System.out.printf("\nCódigo: %d - Sala: %d", aux.getIngresso().getCodigo(), aux.getIngresso().getSala());
            System.out.println("\n---------------------------------------------\n\n");
            
            aux = aux.getProximo();
        } while (aux != null);
    }

}
