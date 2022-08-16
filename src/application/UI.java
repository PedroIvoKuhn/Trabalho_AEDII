package application;

import java.util.List;
import java.util.Scanner;

import entities.EntitiesExeption;
import entities.Vertice;

public class UI {
    
    public static int lerPeso(Scanner sc) {
        int x;
        x = sc.nextInt();

        if(x >= 0){
            return x;
        }
        throw new EntitiesExeption("Valor inserido inválido!");
    }

    public static boolean lerDirecao(Scanner sc) {
        String aux;
        aux = sc.next();

        if(aux.charAt(0) == 's'){
            return true;
        }else{
            return false;
        }
    }

    public static Vertice busca(String nome, List<Vertice> listaVertice) {
        for (Vertice vertice : listaVertice) {
            if(nome.equals(vertice.getNome())){
                return vertice;
            }
        }
        throw new EntitiesExeption("Vértice não encontrado!");   
    }
}
