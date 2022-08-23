package application;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Aresta;
import entities.EntitiesExeption;
import entities.Vertice;

// Trabalho realizado por Gabriel Muller Fischer e Pedro Ivo Kuhn

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static List<Vertice> listaVertice = new ArrayList<Vertice>();

    public static void main(String[] args){

        Vertice origem, destino;
        String aux; 
        int peso, contador = 0;
        boolean direcao;

// Leitura dos Vértices
        UI.limparTela();    
        do{
            System.out.print("Entre com o " + (contador+1) + " vertice (0 para sair): ");
            aux = sc.next();
            if(aux.charAt(0) != '0'){
               listaVertice.add(new Vertice(aux)); 
            }
            contador++;
        }while(aux.charAt(0) != '0' && contador != 20);
// Leitura das arestas        
        do{       
            try{
                UI.limparTela();
                UI.imprimirVertices(listaVertice);
                System.out.print("\nEntre com a origem: ");
                origem = UI.busca(sc.next(), listaVertice);
                System.out.print("Destino: ");
                destino = UI.busca(sc.next(), listaVertice);
                System.out.print("Peso: ");
                peso = UI.lerPeso(sc);
                System.out.println("Uma Direção?(s/n) ");
                direcao = UI.lerDirecao(sc);
                
                Aresta nova = new Aresta(peso, origem, destino, direcao);

                if(direcao || origem == destino){
                    origem.addAresta(nova);
                }else{
                    origem.addAresta(nova);
                    destino.addAresta(new Aresta(peso, destino, origem, direcao));
                }
            }
            catch(EntitiesExeption e){
                System.out.println("\n" + e.getMessage() + "\n");
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("\nErro de digitação\n");
                sc.nextLine();
            }

            System.out.println("Deseja continuar?(s/n)");
            aux = sc.next();

            }while(aux.charAt(0) != 'n');
            UI.limparTela();
            UI.imprimirCaminhos(listaVertice);
            UI.imprimirMatriz(listaVertice);
            sc.nextLine();
            sc.nextLine();
            UI.limparTela();

// DIJKSTRA
            do{
                aux = "n";
                try{
                    UI.imprimirVertices(listaVertice);
                    System.out.print("\nDigite o ponto de partida: ");
                    origem = UI.busca(sc.next(), listaVertice);
                    System.out.print("Digite o ponto de chegada: ");
                    destino = UI.busca(sc.next(), listaVertice);

                    dijkstra.busca(listaVertice, origem, destino);
                    UI.imprimirMenorCaminho(origem, destino);

                }
                catch(EntitiesExeption e){
                    System.out.println("\n" + e.getMessage() + "\n");
                    sc.nextLine();
                    System.out.println("Deseja continuar?(s/n)");
                    aux = sc.next();
                }
            }while(aux.charAt(0) != 'n');
    }
}
