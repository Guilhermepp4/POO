import java.util.ArrayList;

public class Triangulo {
    private ArrayList<Ponto> pontos;

    //Construtor de omissão
    public Triangulo(){
        this.pontos = new ArrayList<Ponto>();
    }

    //Construtor parametrizado

    public Triangulo(ArrayList<Ponto> pontos){
        this.pontos = pontos;
    }

    //Construtor copia

    public Triangulo(Triangulo t){
        this.pontos = t.getPontos();
    }

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }

    public Triangulo clone(){
        return new Triangulo(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Triangulo t = (Triangulo) o;
        return (this.pontos == t.pontos);
    }

    public String toString(){
        return "Triangulo: " + this.pontos;
    }

    //Método que calcula a área do triângulo 
    public double calculaAreaTriangulo(){
        
        double a = this.pontos.get(0).distancia(this.pontos.get(1));
        double b = this.pontos.get(1).distancia(this.pontos.get(2));
        double c = this.pontos.get(2).distancia(this.pontos.get(0));
        double s = (a+b+c)/2;
        
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    //Método que calcula o perímetro do triângulo
    public double calculaPerimetroTriangulo(){
        
        double a = this.pontos.get(0).distancia(this.pontos.get(1));
        double b = this.pontos.get(1).distancia(this.pontos.get(2));
        double c = this.pontos.get(2).distancia(this.pontos.get(0));
        return a+b+c;
        
    }

    //Método que calcula a altura do triângulo, definido como sendo a distância no eixo dos y entre o ponto com menor coordenada em y e o ponto com maior coordenada.

    public double alturaTriangulo(){
        double min = Math.min(this.pontos.get(0).getY(), this.pontos.get(1).getY());
        min = Math.min(this.pontos.get(2).getY(), min);
        double max = Math.max(this.pontos.get(0).getY(), this.pontos.get(1).getY());
        max = Math.max(this.pontos.get(2).getY(), max);
        
        return max-min;
    }
}
