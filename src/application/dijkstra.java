package application;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import entities.Aresta;
import entities.Vertice;

public class dijkstra {
    public static void busca(List<Vertice> listaVertice, Vertice origem, Vertice destino) {
        Vertice aux;
        origem.setVerticeAnterior(null);
        origem.setDistanciaPercorrida(0);
        int distancia;
        List<Vertice> nPercorridos;
        
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

            nPercorridos = listaVertice.stream().filter(v -> (v.getPercorrido()==false)).collect(Collectors.toList());
            if(!nPercorridos.isEmpty())
                origem = nPercorridos.stream().min(Comparator.comparing(Vertice::getDistanciaPercorrida)).get();

        }while(!nPercorridos.isEmpty());
    }
}
