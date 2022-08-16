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
        String sair; 
        int peso;
        boolean direcao;

// Leitura dos Vértices
        UI.limparTela();    
        for (int i = 0; i < 3; i++) {
            System.out.print("Entre com o " + (i+1) + " vertice: ");
            listaVertice.add(new Vertice(sc.next()));
        }
        
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

                if(direcao){
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
            sair = sc.next();
        }while(sair.charAt(0) != 'n');
        
        UI.imprimirCaminhos(listaVertice);

    }

    
}
