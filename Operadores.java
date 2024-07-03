public class Operadores {   //classe pública com o nome Operadores; {} as chaves representam onde ficará o bloco de código, dentro das chaves. { -> inicio do bloco de código
    public static void main(String[] args) throws Exception { //public diz que pode importar e exportar a classe; static que é estático; void quer dizer sem retorno
        System.out.println("Operador de atribuição: ="); // system chama o sistema e o ponto o que estamos chaando dentro dele; out chamamos o método out; 
                                                        //println chama-se o método para imprimir algo na tela e fazer a quebra de linha e o ; representa o fechamento do código 
        String texto = "Texto";     //declaração da variável texto do tipo String que está recebendo o valor Texto
        System.out.println("String texto = \"Texto\";");  //imprime o texto e não o resultado da operação, por estr entre aspas
        System.out.println(texto); // imprime na tela a variável do tipo string chamada texto

        System.out.println("Operador de soma: +"); 
        int soma = 1 + 1;            // declaração da variável soma do tipo int (inteira) que recebe os valores 1 + 1; o +, nesse caso, é o operador de soma ou operador matemático 
                                     // o ; representa o fechamento do código 
        System.out.println("int soma = 1 + 1;"); //imprime o texto e não o resultado da operação
        System.out.println(soma);    // imprime o resultado da operação 1 + 1

        System.out.println("Operador de subtração: -");
        int subtracao = 1 - 1;       // declaração da variável subtracao do tipo int (inteira) que recebe os valores 1 - 1; o - é o operador de subtração
                                     // o ; representa o fechamento do código 
        System.out.println("int subtracao = 1 - 1;"); //imprime o texto e não o resultado da operação
        System.out.println(subtracao); // imprime o resultado da operação 1 - 1

        System.out.println("Operador de divisão: /");
        int divisao = 1 / 1;         // declaração da variável divisao do tipo int (inteira) que recebe os valores 1/1; o / é o operador de divisão
                                     // o ; representa o fechamento do código 
        System.out.println("int divisao = 1 / 1;"); //imprime o texto e não o resultado da operação
        System.out.println(divisao); // imprime o resultado da operação 1 / 1

        System.out.println("Operador de multiplicação: *");
        int multiplicacao = 1 * 1;   // declaração da variável multiplicacao do tipo int (inteira) que recebe os valores 1*1; o * é o operador de multiplicação 
                                     // o ; representa o fechamento do código  
        System.out.println("int multiplicacao = 1 * 1;"); //imprime o texto e não o resultado da operação
        System.out.println(multiplicacao); // imprime o resultado da operação 1 * 1

        System.out.println("Operador de concatenação de strings: +");
        String concatenacao = "Texto 1 + " + "Texto 2";     // declaração da variável concatenacao do tipo String (texto) que recebe os valores "Texto 1 + " + "Texto 2"; 
                                                            // o +, nesse caso, é o operador de concatenação (junção) e o ; representa o fechamento do código
        System.out.println("String concatenacao = \"Texto 1 + \" + \"Texto 2\";"); //imprime o texto e não o resultado da operação
        System.out.println(concatenacao);                   //imprime o resultado da operação "Texto 1 + " + "Texto 2"
    } // } -> fim do bloco de código
}