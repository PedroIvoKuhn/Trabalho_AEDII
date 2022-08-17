package entities;

public class Aresta {
    private int peso;
    private Vertice A,B;
    private boolean umaDirecao;
    
    public Aresta(int peso, Vertice a, Vertice b, boolean umaDirecao) {
        this.peso = peso;
        A = a;
        B = b;
        this.umaDirecao = umaDirecao;
    }

    public int getPeso() {
        return peso;
    }

    public Vertice getA() {
        return A;
    }

    public Vertice getB() {
        return B;
    }

    public Vertice destino(Vertice inicio) {
        if(umaDirecao || inicio.equals(A)){
            return B;
        }
        if(inicio.equals(B)){
            return A;
        }
        return null;   
    }

    public boolean isUmaDirecao() {
        return umaDirecao;
    }

    @Override
    public String toString() {
        if(umaDirecao){
           return "Destino: " + destino(A) + ", Distancia: " + peso + ", somente ida"; 
        }
        return "Destino: " + destino(A) + ", Distancia: " + peso;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aresta other = (Aresta) obj;
        if (A == null) {
            if (other.A != null)
                return false;
        } else if (!A.equals(other.A))
            return false;
        if (B == null) {
            if (other.B != null)
                return false;
        } else if (!B.equals(other.B))
            return false;
        return true;
    }
   
    
}
