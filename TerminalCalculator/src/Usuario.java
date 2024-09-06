import java.util.*;

public class Usuario {
    static int opcao;
    static int opcoes;
    static int Menu;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Scanner scanMenu = new Scanner(System.in);
        Scanner retornaMenu = new Scanner(System.in);

        do{
            System.out.println("Digite a opção que deseja escolher: ");
            System.out.println("1 - Pratos executivos\n2 - Bebidas\n3 - Sobremesas ");
            opcao = scan.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.println("Opções:\n1: Hambúrguer com fritas, arroz, feijão e salada\n2: Filé mignon com fritas, arroz, feijão e salada mista\n3: Bife à parmegiana com fritas, arroz, feijão e salada mista");
                    opcoes = scanMenu.nextInt();
                    break;
                case 2:
                    System.out.println("Opções:\n1: Sucos naturais\n2: Refrigerantes\n3: Chopp");
                    opcoes = scanMenu.nextInt();
                break;
                case 3:
                    System.out.println("Opções:\n1: Sorvete\n2: Torta holandesa\n3: Bolo");
                    opcoes = scanMenu.nextInt();
                break;
                default:
                    break;
            }
            
            if(opcao == 1){
                if(opcoes == 1){
                    System.out.println("Você escolheu a opção "+opcao+"-Pratos executivos e solicitou o prato executivo nº "+opcoes+": Hambúrguer com fritas, arroz, feijão e salada");
                }
                if(opcoes == 2){
                    System.out.println("Você escolheu a opção "+opcao+"-Pratos executivos e solicitou o prato executivo nº "+opcoes+": Filé mignon com fritas, arroz, feijão e salada mista");
                }
                if(opcoes == 3){
                    System.out.println("Você escolheu a opção "+opcao+"-Pratos executivos e solicitou o prato executivo nº "+opcoes+": Bife à parmegiana com fritas, arroz, feijão e salada mista");
                }
            }
            if(opcao == 2){
                if(opcoes == 1){
                    System.out.println("Você escolheu a opção "+opcao+"-Bebidas e solicitou a opção nº "+opcoes+": Sucos naturais");
                }
                if(opcoes == 2){
                    System.out.println("Você escolheu a opção "+opcao+"-Bebidas e solicitou a opção nº "+opcoes+": Refrigerantes");
                }
                if(opcoes == 3){
                    System.out.println("Você escolheu a opção "+opcao+"-Bebidas e solicitou a opção nº "+opcoes+": Chopp");
                }
            }
            if(opcao == 3){
                if(opcoes == 1){
                    System.out.println("Você escolheu a opção "+opcao+"-Sobremesas e solicitou a opção nº "+opcoes+": Sorvete");
                }
                if(opcoes == 2){
                    System.out.println("Você escolheu a opção "+opcao+"-Sobremesas e solicitou a opção nº "+opcoes+": Torta holandesa");
                }
                if(opcoes == 3){
                    System.out.println("Você escolheu a opção "+opcao+"-Sobremesas e solicitou a opção nº "+opcoes+": Bolo");
                }
            }
        System.out.println("Deseja acrescentar mais alguma coisa no seu pedido?\nDigite 1 para incrementar seu pedido.");
        Menu = retornaMenu.nextInt();
        }while(Menu == 1);      
    }
}
