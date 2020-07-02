package pitstop;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Principal {
 
    public static void main(String[] args) throws IOException {

        // caminho relativo dos arquivos de entrada e saída
        String logFile = new File("../PitStop/PitStop/src/pitstop/log/log.txt").getCanonicalPath();

        File f = new File(logFile);
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("#########\n#########\n< START >\n#########\n#########\n");

        pw.println(">> Gerando Ingressos e empilhando\n---------------------------------\n");
        Lista espectadores = new Lista();
        Pilha ingressos = Ingresso.getIngressos(); // Inicia a pilha com 15 ingressos para cada sala
        Fila pessoas = new Fila();

        pw.println(">>> Enchendo a fila com os inscritos até o momento\n--------------------------------------------------\n");
        // Adicionando os 80 inscritos na fila para receber o ingresso
        for (int i = 0; i < 80; i++) {
            pessoas.enqueue(new Pessoa());
        }

        while(true) {
            pw.println("#####################################\n#####################################\n>>>> Apresentando menu para o usuário\n-------------------------------------\n");
            String op = Usuario.menu();
        
            switch (op) {
                case "0":
                    // Sair do sistema
                    pw.println(">>>>> Selecionado: 0 - Sair do sistema\n--------------------------------------");
                    pw.println("\n#######\n#######\n< END >\n#######\n#######");
                    pw.close();
                    fw.close();
                    System.exit(1);
                    break;
                
                case "1":
                    // Entrega ingresso
                    pw.println(">>>>> Selecionado: 1 - Entregar ingresso\n----------------------------------------");
                    String[] dados = Usuario.cadastroPessoa();
                    // Validação dos dados digitados
                    if (dados[0] == null || dados[2] == null){
                        pw.println(">>>>>> Falha na entrega\nDados digitados incorretamente\n------------------------------\n");
                        System.out.println("Dados inválidos, tente novamente!\n");
                        break;
                    }
                    // remover ingresso da pilha, e pessoa da fila
                    pw.println(">>>>>> Buscando ingresso e pessoa\n---------------------------------");
                    Ingresso ing = ingressos.pop();
                    Pessoa pes = pessoas.dequeue();
                    // adicionar dados inseridos, à pessoa
                    pw.println(">>>>>>> Atualizando dados da pessoa\n----------------------------------");
                    pes.setNome(dados[0]);
                    pes.setCelular(dados[1]);
                    pes.setEmail(dados[2]);
                    // Inserir na Lista de pessoas contempladas
                    pw.println(">>>>>>>> Inserindo dados na Lista de contemplados\n-------------------------------------------------\n");             
                    espectadores.insert(pes, ing, espectadores.getTamanho());
                    break;
                
                case "2":
                    // Sair da sala de cinema
                    pw.println(">>>>> Selecionado: 2 - Sair da sala\n-----------------------------------");
                    int cod = 0;
                    // Validação do valor digitado
                    try {
                        cod = Integer.parseInt(Usuario.removePessoa());
                    } catch (NumberFormatException e) {
                        pw.println(">>>>>> Formato de código inválido\n---------------------------------\n");
                        System.out.println("Valor Inválido!\n");
                        break;
                    }
                    // remover pessoa e ingresso da lista de espectadores
                    pw.println(">>>>>> Removendo da lista de contemplados\n-----------------------------------------");
                    Ingresso ingRemovido = espectadores.remove(cod);
                    // Repondo o ingresso na pilha de ingressos
                    if (ingRemovido != null){
                        pw.println(">>>>>>> Sucesso na remoção\n--------------------------");
                        pw.println(">>>>>>>> Devolvendo ingresso para a pilha\n-----------------------------------------\n");
                        ingressos.push(ingRemovido);
                    } else {
                        pw.println(">>>>>>> Falha na remoção, código do ingresso inválido\n-----------------------------------------------------\n");
                    }
                    break;
                
                case "3":
                    // adicionar nova pessoa na fila de espera
                    pw.println(">>>>> Selecionado: 3 - Nova pessoa na fila\n------------------------------------------");
                    pessoas.enqueue(new Pessoa());
                    pw.println(">>>>>> Nova pessoa adicionada na fila\n-------------------------------------\n");
                    System.out.println("Nova pessoa inserida com sucesso!\n");
                    break;
                
                case "4":
                    // apresentar pessoas contempladas
                    pw.println(">>>>> Selecionado: 4 - Exibir pessoas contempladas\n--------------------------------------------------");
                    pw.println(">>>>>> Exibindo dados dos contemplados no console\n-------------------------------------------------\n");
                    System.out.println("Pessoas contempladas:\n");
                    espectadores.show();
                    break;
                    
                    case "5":
                    // apresentar todos os ingressos na pilha
                    pw.println(">>>>> Selecionado: 5 - Apresentar ingressos\n-------------------------------------------");
                    pw.println(">>>>>> Exibindo dados dos ingressos no console\n----------------------------------------------\n");
                    System.out.println("Ingressos disponíveis na pilha:\n");
                    ingressos.show();
                    break;
                
                    case "6":
                    // apresentar o total de pessoas aguardando na fila
                    pw.println(">>>>> Selecionado: 6 - Apresentar tamanho da fila\n-------------------------------------------------");
                    pw.println(">>>>>> Exibindo tamanho da fila no console\n------------------------------------------\n");
                    System.out.printf("Quantidade de pessoas na fila: %s\n\n", pessoas.getTamanho());
                    break;
                    
                default:
                    // validação, caso digitem um valor inválido no menu
                    pw.println(">>>>> Selecionado: "+ op +" - Valor inválido\n--------------------------------------\n");
                    System.out.println("Digite um valor válido!\n");
                    break;
            }
            
        }

    }

}
