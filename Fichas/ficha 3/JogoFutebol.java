public class JogoFutebol {
    
    private Estado estado;
    private int golosCasa;
    private int golosVis;

    public enum Estado{
        POR_INICIAR, A_DECORRER, TERMINADO
    }

    // Construtores:
    // Construtor por omissão
    public JogoFutebol(){
        this.estado = Estado.POR_INICIAR;
        this.golosCasa = 0;
        this.golosVis = 0;
    }

    // Construtor Parametrizado
    public JogoFutebol(Estado estado, int golosCasa, int golosVis){
        this.estado = estado;
        this.golosCasa = golosCasa;
        this.golosVis = golosVis;
    }
    
    //Construtor Cópia
    public JogoFutebol(JogoFutebol jF){
        this.estado = jF.getEstado();
        this.golosCasa = jF.getGolosCasa();
        this.golosVis = jF.getGolosVis();
    }

    //Getters:
    public Estado getEstado(){
        return this.estado;
    }

    public int getGolosCasa(){
        return this.golosCasa;
    }

    public int getGolosVis(){
        return this.golosVis;
    }

    // Setters:
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void setGolosCasa(int golosCasa){
        this.golosCasa = golosCasa;
    }

    public void setGolosVis(int golosVis){
        this.golosVis = golosVis;
    }

    public JogoFutebol clone(){
        return new JogoFutebol(this);
    }

    public boolean equals(Object o){
        if( this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        JogoFutebol jF = (JogoFutebol) this;
        return(this.estado == jF.estado && this.golosCasa == jF.golosCasa && this.golosVis == jF.golosVis);
    }
    
    //Metodo que da inicio ao jogo

    public void startGame(){
        this.setEstado(Estado.A_DECORRER);
    }

    //Metodo que da fim ao jogo
    public void endGame(){
        this.setEstado(Estado.TERMINADO);
    }

    //Metodo que adiciona um golo a equipa da casa
    public void goloVisitado(){
        this.golosCasa++;
    }

    //Metodo que adiciona um golo a equipa da visitante
    public void goloVisitante(){
        this.golosVis++;
    }

    //Metodo que devolve o resultado do jogo atual
    public String resultadoActual(){
        return "O jogo encontra-se " + this.estado + ", a equipa da casa marcou um total de " + this.golosCasa + 
        " e a equipa visitante marcou " + this.golosVis;
    }

    public String toString(){
        switch (this.estado) {
            case POR_INICIAR:
                return "O jogo neste momento está: " + this.estado;
            
            case A_DECORRER:
                return "O jogo neste momento está: " + this.estado +
                       "A equipa da casa marcou " + this.golosCasa + " golos!" +
                       "A equipa visitante marcou " + this.golosVis + " golos!" + 
                       "neste momento está: " + this.resultadoActual() + "!";

            default:
                return "O jogo neste momento está: " + this.estado + "\n" +
                       "A equipa da casa marcou " + this.golosCasa + " golos!\n" +
                       "A equipa visitante marcou " + this.golosVis + " golos!\n" +
                       "O jogo terminou: " + this.resultadoActual() + "!";
        }
    }

}
