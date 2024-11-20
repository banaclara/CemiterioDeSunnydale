package factory;

import inimigos.*;

public class InimigoFactory {
    public static Inimigo criarInimigo(String tipo) {
        switch (tipo) {
            case "Vampiro":
                return new VampiroBasico("Vampiro", 35, 15, 15);
            case "Demônio":
                return new DemonioBasico("Demônio", 40, 10, 10);
            case "Zumbi":
                return new Zumbi("Zumbi", 30, 10, 10);
            case "Feiticeiro":
                return new Feiticeiro("Feiticeiro", 50, 10, 10);
        }
        return null;
    }
}
