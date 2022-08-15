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
        list.add(nova);
    }

    public void removeAresta(Aresta remove) {
        list.remove(remove);
    }

    public void imprimirCaminhos() {
        for (Aresta aresta : list) {
            System.out.println(aresta);
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}
