import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Aresta;
import entities.EntitiesExeption;
import entities.Vertice;

// Trabalho realizado por Gabriel Muller Fischer e Pedro Ivo Kuhn

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static List<Vertice> listaVertice = new ArrayList<Vertice>();

    public App() {
    }
    
    private Vertice busca(String nome) {
        for (Vertice vertice : listaVertice) {
            if(nome.equals(vertice.getNome())){
                return vertice;
            }
        }
        throw new EntitiesExeption("Vértice não encontrado!");   
    }

    private int lerPeso() {
        int x;
        x = sc.nextInt();

        if(x >= 0){
            return x;
        }
        throw new EntitiesExeption("Valor inserido inválido!");
    }

    private boolean lerDirecao() {
        String aux;
        aux = sc.next();

        if(aux.charAt(0) == 's'){
            return true;
        }else{
            return false;
        }
    }

// =======================================================================
    public static void main(String[] args){

        App app = new App();
        Vertice origem, destino;
        String nome, aux, sair; 
        int peso;
        boolean direcao;

// Leitura dos Vértices
        for (int i = 0; i < 3; i++) {
            System.out.print("Entre com o " + (i+1) + " vertice: ");
            nome = sc.next();

            Vertice vertice = new Vertice(nome);
            listaVertice.add(vertice);
        }
        
// Leitura das arestas
        do{
            try{
                System.out.print("\nEntre com a origem: ");
                nome = sc.next();
                origem = app.busca(nome);
                System.out.print("Destino: ");
                aux = sc.next();
                destino = app.busca(aux);
                System.out.print("Peso: ");
                peso = app.lerPeso();
                System.out.println("Uma Direção?(s/n) ");
                direcao = app.lerDirecao();
                
                Aresta nova = new Aresta(peso, origem, destino, direcao);

                if(direcao){
                    origem.addAresta(nova);
                }else{
                    Aresta novaVoltando = new Aresta(peso, destino, origem, direcao);
                    origem.addAresta(nova);
                    destino.addAresta(novaVoltando);
                }

            }
            catch(EntitiesExeption e){
                System.out.println(e.getMessage() + "\n\n");
                sc.nextLine();
            }

            System.out.println("Deseja continuar?(s/n)");
            sair = sc.next();
        }while(sair.charAt(0) != 'n');
        

//  Impressão dos pontos e caminhos
        for (Vertice vertice : listaVertice) {
            vertice.imprimirCaminhos();
        }
    }

    
}
