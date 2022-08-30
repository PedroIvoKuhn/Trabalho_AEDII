package application;

import java.util.List;

import entities.Aresta;
import entities.Vertice;

public class dijkstra {
    public static void busca(List<Vertice> listaVertice, Vertice origem, Vertice destino) {
        Vertice aux;
        origem.setVerticeAnterior(null);
        origem.setDistanciaPercorrida(0);
        int distancia;
        
        do{
            if (!origem.getList().isEmpty()){
                for (Aresta aresta : origem.getList()) {
                    aux = aresta.getB();
                    if(!aux.getPercorrido()){
                        distancia = aresta.getPeso() + origem.getDistanciaPercorrida();
                        if (distancia < aux.getDistanciaPercorrida()){
                            aux.setVerticeAnterior(aresta.getA());
                            aux.setDistanciaPercorrida(distancia); 
                        } 
                    }
                }
            }
            origem.setPercorrido(true);
            origem = menorCaminho(listaVertice);

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
            if (vertice.getPercorrido() != true){
                if(aux.getDistanciaPercorrida() > vertice.getDistanciaPercorrida()){
                    aux = vertice;
                }
            }
        }
        return aux;
    }
}
