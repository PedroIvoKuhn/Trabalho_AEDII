package entities;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String nome;
    private Vertice verticeAnterior = null;
    private int distanciaPercorrida = 2147483647;
    private boolean percorrido = false;

    private List<Aresta> list = new ArrayList<Aresta>();

    public Vertice(String nome) {
        this.nome = nome;
    }

    public Vertice() {
    }

    public String getNome() {
        return nome;
    }

    public List<Aresta> getList() {
        return list;
    }

    public Vertice getVerticeAnterior() {
        return verticeAnterior;
    }

    public void setVerticeAnterior(Vertice verticeAnterior) {
        this.verticeAnterior = verticeAnterior;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public boolean getPercorrido() {
        return percorrido;
    }

    public void setPercorrido(boolean percorrido) {
        this.percorrido = percorrido;
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
