import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Aresta;
import entities.Vertice;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static List<Vertice> listaVertice = new ArrayList<Vertice>();

    public static void main(String[] args){

        String numero;
        for (int i = 0; i < 3; i++) {
            System.out.println("Entre com o " + (i+1) + " vertice:");
            numero = sc.next();

            Vertice vertice = new Vertice(numero);
            listaVertice.add(vertice);
        }

        int x = 1, dire, peso;
        String aux; 
        boolean direcao;
        do{
            System.out.print("Entre com a origem: ");
            numero = sc.next();
            System.out.print("Destino: ");
            aux = sc.next();
            System.out.print("Peso: ");
            
            peso = sc.nextInt();
            System.out.println("Uma Direção?(0/1) ");
            dire = sc.nextInt();

            if(dire == 1){
                direcao = true;
            }else{
                direcao = false;
            }

            Vertice origem = busca(numero);
            Vertice destino = busca(aux);

            Aresta nova = new Aresta(peso, origem, destino, direcao);
            origem.addAresta(nova);

            System.out.println("Deseja continuar?(s=1, n=0)");
            x = sc.nextInt();
        }while(x != 0);
        
        for (Vertice vertice : listaVertice) {
            vertice.imprimirCaminhos();
        }


    }

    public static Vertice busca(String nome) {
        for (Vertice vertice : listaVertice) {
            if(nome.equals(vertice.getNome())){
                return vertice;
            }
        }
        return null;
    }
}
