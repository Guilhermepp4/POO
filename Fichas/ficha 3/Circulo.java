public class Circulo {
    private double x;
    private double y;
    private double raio;


    //Construtor por omissao

    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0.0;
    }


    //Construtor parametrizado

    public Circulo (double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    //Constritor copia

    public Circulo(Circulo circulo){
        circulo.x = this.x;
        circulo.y = this.y;
        circulo.raio = this.raio;
    }


    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }


    public double getRaio() {
        return raio;
    }


    public void setRaio(double raio) {
        this.raio = raio;
    }

    
    //Metodo que devolve um objeto clone

    public Circulo clone(){
        return new Circulo(this);
    }

    //Metodo toString

    public String toString(){
        return "O Circulo de centro: " + this.x + " " + this.y + " e de raio: " + this.raio; 
    }

    //Metodo equals

    public boolean equals(Object o){
        if (this == o) return true;
        
        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Circulo c = (Circulo) o;
        return this.x == c.x && this.y == c.y && this.raio == c.raio;
    }


    //Metodo que altera 
    public void alteraCentro(double x, double y){

        this.x = x;
        this.y = y;
    }

    //Metodo que calcula a area do circulo

    public double calculaArea(){
        return (Math.PI) * Math.pow(this.raio, 2);
    }

    //Metodo que calcula o perimetro do circulo

    public double calculaPerimetro(){
        return 2 * (Math.PI) * this.raio; 
    }

    //



}
