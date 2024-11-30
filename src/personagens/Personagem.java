package personagens;

import inimigos.Inimigo;
import itens.Item;
//import main.Combate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.GameUtils.*;
import static utils.GameUtils.limparConsole;

public abstract class Personagem {
    String nome;
    String race;
    String classType;
    int hp;
    int maxHp;
    int ac;
    String[] skills;
    private int barreiraAtiva = 0;
    String alignment;
    boolean temItem = false;
    List<Item> mochila;

    public int getBarreiraAtiva() {
        return barreiraAtiva;
    }

    public void setBarreiraAtiva(int barreiraAtiva) {
        this.barreiraAtiva = barreiraAtiva;
    }
    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        this.hp = Math.min(hp, maxHp);
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public List<Item> getMochila() {
        return mochila;
    }

    public Personagem(String nome, String race, String classType, int hp, int ac, String[] skills, String alignment) {
        this.nome = nome;
        this.race = race;
        this.classType = classType;
        this.hp = hp;
        this.maxHp = hp;
        this.ac = ac;
        this.skills = skills;
        this.alignment = alignment;
        this.mochila = new ArrayList<>();
    }

    //como é uma ação do personagem, acho que faz mais sentido deixar aqui
    //Seria bom criar um metodo de drop de itens no combate para adicionar coisas na mochila
    public void adicionarItemNaMochila(Item item) {
        mochila.add(item);

    }


    public void displayStats(Personagem personagem) {
        limparConsole();
        printTitulo("STATUS DO PERSONAGEM");
        System.out.println("HP: " + personagem.hp + "\nNome: " + personagem.nome );
        printSeparador(20);
        System.out.println("Raça: " + personagem.race + "\nClasse: " + personagem.classType);
        printSeparador(20);
        System.out.println("Classe de Armadura (CA): " + personagem.ac);
        System.out.print("Habilidades: ");
        for (String skill : personagem.skills) {
            System.out.print(skill + " ");
        }
        System.out.println();
        System.out.println("Tendência: " + personagem.alignment);
        printSeparador(20);
        continuarHistoria();
        limparConsole();
    }

    public abstract void iniciarNarrativa();

    public void escolhaDeAcao() {
        Scanner scanner = new Scanner(System.in);
        // Oferece as opções de ação para o jogador
        System.out.println("\nEscolha uma ação:");
        System.out.println("1. Explorar a área");
        System.out.println("2. Tentar identificar os murmúrios");
        System.out.println("3. Procurar por itens");
        System.out.println("4. Seguir em frente");
        System.out.print("Digite o número da opção: ");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                explorarArea();
                break;
            case 2:
                identificarMurmurios();
                break;
            case 3:
                procurarItens();
                break;
//            case 4:
//                seguirEmFrente();
//                break;
//            default:
//                System.out.println("Opção inválida, tente novamente.");
//                escolhaDeAcao();
//                break;
        }
    }

    public void explorarArea() {
        System.out.println("\nVocê começa a explorar a área ao seu redor. A floresta é densa e o ar está pesado.");
        System.out.println("Conforme anda, você vê sinais de uma presença misteriosa: pegadas grandes e arranhões nas árvores.");
        System.out.println("Você decide seguir por esse caminho, mais cauteloso, mas mais determinado a desvendar o mistério.");
    }

    public void identificarMurmurios() {
        System.out.println("\nVocê para para ouvir atentamente. Os murmúrios parecem vir de uma direção específica.");
        System.out.println("À medida que você se aproxima, vê sombras movendo-se entre as árvores. Um frio na espinha percorre seu corpo.");
        System.out.println("Você decide avançar com cuidado, mas sente que está se aproximando de algo que talvez não queira encontrar...");
    }

    public void procurarItens() {
        System.out.println("\nVocê olha ao redor, procurando por qualquer coisa que possa ajudá-lo em sua jornada.");
        System.out.println("Embaixo de uma árvore caída, você encontra uma mochila velha. Dentro dela, há uma poção de cura e uma faca afiada.");
        System.out.println("Agora, com novos recursos em mãos, você se sente mais preparado para enfrentar o que quer que esteja à frente.");
        temItem = true;
    }

//    public void seguirEmFrente() {
//        System.out.println("\nVocê decide seguir em frente, sem hesitar. O caminho à frente é sombrio e denso, mas você sente uma estranha energia no ar.");
//        System.out.println("À medida que avança, você ouve sons que parecem vir de um ser desconhecido...");
//        System.out.println("De repente, um inimigo surge de entre as árvores! Um combate está prestes a começar!");
//
//        Inimigo inimigo = new Inimigo("Goblin", 30, 12, 15);
//        Combate combate = new Combate(this, inimigo);
//        combate.iniciarCombate();
//    }
}
