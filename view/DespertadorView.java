package view;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import controller.*;

public class DespertadorView {
    private static int escolhaDaPessoa;
    private static int min;
    public static void main(String[] args) {
        int horaAtual;
        int minutoAtual;
        int segundoAtual;

        int minAtrasados = 0;
        int horaDespertar = 16;
        int minutoDespertar = 55 + minAtrasados;
        int segundoDespertar = 0;

        Timer timer = new Timer();

        Date date = null;
        Calendar calendar = null;
        boolean sair = false;
        int adiar = 10; // segundos

        Scanner scnDespertador = new Scanner(System.in);
        Scanner adiarDespertador = new Scanner(System.in);

        while (sair == false) {
            date = new Date();
            calendar = GregorianCalendar.getInstance();
            calendar.setTime(date);
            horaAtual = calendar.get(Calendar.HOUR_OF_DAY);
            minutoAtual = calendar.get(Calendar.MINUTE);
            segundoAtual = calendar.get(Calendar.SECOND);

            if (horaAtual >= horaDespertar && minutoAtual >= minutoDespertar && segundoAtual >= segundoDespertar) {
                if(escolhaDaPessoa != 1){
                    System.out.println("Acorda, seu despertador está chamando.");
                    String[] escolha = DespertadorController.escolherOpcoes();
                        for(int i = 0; i < escolha.length;i++){
                            System.out.println(String.format("[%d] >> %s", i + 1, escolha[i]));
                        }
                        escolhaDaPessoa = scnDespertador.nextInt();

                        if(escolhaDaPessoa == 1){
                            System.out.println("Quantos minutos deseja adiar ?");
                            min = adiarDespertador.nextInt();
                            minutoDespertar = minutoDespertar + minAtrasados;
                        }
                }
                // aqui vocês terão que chamar o switch/case da controller q vai perguntar pro usuário o que ele deseja fazer, se vai adiar ou se vai parar o despertador
                

                System.out.println(DespertadorController.respostaDaEscolha(escolhaDaPessoa));
            }
            System.out.println(String.format("Agora são: %d:%d:%d", horaAtual, minutoAtual, segundoAtual));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }
    }
}