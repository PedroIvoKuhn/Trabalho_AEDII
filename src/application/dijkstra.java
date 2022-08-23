package application;

import java.util.List;

import entities.Aresta;
import entities.Vertice;

public class dijkstra {
    public static void busca(List<Vertice> listaVertice, Vertice origem, Vertice destino) {
        Vertice aux;
        origem.setVerticeAnterior(null);
        origem.setDistanciaPercorrida(0);
        
        do{

            for (Aresta aresta : origem.getList()) {
                if (!origem.getList().isEmpty()){
                aux = aresta.getB();
                    if(!aux.getPercorrido()){
                        aux.setVerticeAnterior(aresta.getA());
                        aux.setDistanciaPercorrida(aresta.getPeso() + origem.getDistanciaPercorrida());
                    }
                
                }
            }
            origem.setPercorrido(true);
            origem = menorCaminho(listaVertice);
            System.out.println("banana");

        }while(verificaPercorridos(listaVertice));
        
    }

    private static boolean verificaPercorridos(List<Vertice> listaVertice) {
        for (Vertice vertice : listaVertice) {
            if(!vertice.getPercorrido()){
               return true; 
            }
        }
        return false;       
    }

    private static Vertice menorCaminho(List<Vertice> listaVertice) {
        Vertice aux = new Vertice();
        for (Vertice vertice : listaVertice) {
            System.out.println("batata");
            if (vertice.getPercorrido() != true){
                System.out.println("alface");
                if(aux.getDistanciaPercorrida() > vertice.getDistanciaPercorrida()){
                    System.out.println("== morango ==");
                    aux = vertice;
                }
            }
        }
        return aux;
    }

}
