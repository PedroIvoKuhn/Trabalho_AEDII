package entities;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String nome;

    private List<Aresta> list = new ArrayList<Aresta>();

    public Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void addAresta(Aresta nova) {
       //*
        Aresta aux = null;
        for (Aresta aresta : list) {
            if(aresta.equals(nova)){
                aux = aresta;
            }
        }
        if(aux != null){
            list.remove(aux);
        }
        list.add(nova);
        //*/
    }

    public void removeAresta(Aresta remove) {
        list.remove(remove);
    }

    public void imprimirCaminhos() {
        System.out.println("\n--==== Caminhos do vertice: " + this + " ====--");
        for (Aresta aresta : list) {
            System.out.println(aresta);
        }
    }

    public int pegarPeso(Vertice alvo) {
        for (Aresta aresta : list) {
            if(aresta.getB() == alvo){
                return aresta.getPeso();
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return nome;
    }
}
