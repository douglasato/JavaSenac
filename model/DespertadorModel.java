package model;

public class DespertadorModel {
    // aqui no model vocês terão que inserir as opções ue o usuário tem (adiar ou parar alarme)
    public static String[] despertadorOpcoes = {"Adiar", "Desligar", "Matar-Despertador"};
    
    public static String[] escolherOpcoes() {
        return despertadorOpcoes;
    }
}
