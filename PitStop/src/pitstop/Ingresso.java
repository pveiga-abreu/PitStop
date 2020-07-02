package pitstop;

import java.util.Random;

public class Ingresso {
    // ATRIBUTOS
    private int codigo;
    private int sala;

    // CONSTRUTOR
    public Ingresso(int cod, int s){
        this.codigo = cod;
        this.sala = s;
    }

    // GETTERS
    public int getCodigo(){
        return this.codigo;
    }
    public int getSala(){
        return this.sala;
    }
    // SETTERS
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setSala(int sala){
        this.sala = sala;
    }

    // MÉTODO GERADOR DE INGRESSOS, GERA 15 INGRESSOS POR SALA
    private static Ingresso[] gerarIngressos(){
        Ingresso[] ingressosGerados = new Ingresso[75];

        for(int c = 0; c < 75; c++){
            ingressosGerados[c] = new Ingresso((c+1),((c/15) + 1));
        }

        return ingressosGerados;
    }

    // MÉTODO PARA VERIFICAR A EXISTENCIA DE UM VALOR EM UM ARRAY int[]
    private static boolean contains(int cod, int[] arrCod) {
        for (int i = 0; i < arrCod.length; i++) {
            if (cod == arrCod[i]) {
                return true;
            }
        }

        return false;
    }
    
    // MÉTODO QUE RETORNARÁ, PARA A CLASSE PRINCIPAL, UMA PILHA DE INGRESSOS EMBARALHADOS
    public static Pilha getIngressos(){
        Ingresso[] ingressosGerados = gerarIngressos();
        int[] codRetirados = new int[75];

        Pilha ingressos = new Pilha();
        Random random = new Random();
        int contRetidadas = 0;

        while (contRetidadas < 74) {
            int randomCod = random.nextInt(ingressosGerados.length);

            if (!contains(randomCod, codRetirados)) {
                codRetirados[randomCod] = randomCod;
                ingressos.push(ingressosGerados[randomCod]);

                contRetidadas++;
            }

        }

        return ingressos;
    }

}
