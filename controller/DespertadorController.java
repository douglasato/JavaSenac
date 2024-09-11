package controller;
import model.DespertadorModel;

public class DespertadorController {
    // aqui na controller vocês terão que colocar o switch/case
    public static String[] escolherOpcoes(){
        return DespertadorModel.escolherOpcoes();
    }

    public static String respostaDaEscolha(int respostaEscolha){
        String resposta;

    switch (respostaEscolha) {
        case 1:
            resposta = "O alarme do despertador será adiado !";
            break;
        case 2:
            resposta = "O alarme do despertador será desligado !"; 
            System.exit(0);
            break;
        case 3:
            resposta = "Excelente escolha! Vamos dar um fim no despertador de uma vez por todas!";
            System.exit(0);  
            break;  

        default:
            resposta = "Escolha inválida";
            break;
    }    

        return resposta;
    }
}
