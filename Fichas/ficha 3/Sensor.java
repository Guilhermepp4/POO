public class Sensor {
    // Variáveis de Instância
    private double pressao;

    // Construtores de Classe:
    // Construtor por omissão
    public Sensor(){
        this.pressao = 0;
    }

    //Construtor Parametrizado
    public Sensor(double pressao){
        this.pressao = pressao;
    }

    //Construtor Copia
    public Sensor(Sensor s){
        this.pressao = s.getPressao();
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    //Metodo clone

    public Sensor clone(){
        return new Sensor(this);
    }

    //Metodo toString

    public String toString(){
        return "A pressao deste Sensor é de: " + this.pressao;
    }

    //Metodo equals

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;

        Sensor s = (Sensor) o;
        return this.pressao == s.pressao;
    }
}
