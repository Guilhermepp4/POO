import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashSet;




public class CasaInteligente {

    private ArrayList<Lampada> lampadas;

    //Construtor por omissao
    public CasaInteligente(){
        this.lampadas = new ArrayList<>();
    }

    //Construtor parametrizado
    public CasaInteligente(ArrayList<Lampada> lampadas){
        this.lampadas = lampadas;
    }

    //Construtor copia
    public CasaInteligente(CasaInteligente casaS){
        this.lampadas = casaS.getLampadas();
    }

    public ArrayList<Lampada> getLampadas(){
        return this.lampadas;
    }

    public void setLampadas(ArrayList<Lampada> lampadas){
        this.lampadas = lampadas;
    }

    public String toString(){
        return "lampadas: " + this.lampadas;
    }

    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        CasaInteligente cI = (CasaInteligente) o;
        return(this.lampadas == cI.lampadas);
    }

    //Metodo que adiciona mais uma lâmpada à casa
    public void addLampada(Lampada l){
        this.lampadas.add(l);
    }

    //Metodo que liga no modo de consumo máximo a lâmpada que está na posição indicada
    public void ligaLampadaNormal(int index){
        this.lampadas.get(index).lampON();
    }

    //Metodo que liga no modo de consumo económico a lâmpada que está na posição indicada
    public void ligaLampadaEco(int index){
        this.lampadas.get(index).lampECO();
    }

    //Metodo que determina quantas lâmpadas é que estão ligadas em modo económico.
    public int qtEmEco(){
        int soma = 0;
        for(Lampada lampada : lampadas){
            if(lampada.getEstado() == Lampada.Estado.ECO){
                soma += 1;
            }
        }
        return soma;
    }

    //Metodo  que remove a lâmpada da posição passada como parâmetro

    public void removeLampada(int index){
        this.lampadas.remove(index);
    }

    //Metodos que liga todas as lâmpadas da casa respectivamente em modo Eco e em modo de consumo máximo
    public void ligaTodasEco(){
        for(Lampada lampada : lampadas){
                lampada.lampECO();       
            }
        }
    
    
    public void ligaTodasMax(){
        for(Lampada lampada : lampadas){
                lampada.totalConsumo();
            }
        }

    
    //Metodo que devolve um conjunto com todas as lâmpadas que se encontram em modo económico.

    public Set<Lampada> lampadasEmModoEco(){
        Set<Lampada> lista = new LinkedHashSet<>();
        for(Lampada lampada : lampadas){
            if(lampada.getEstado().equals(Lampada.Estado.ECO)){
                lista.add(lampada);
            }
        }
        return lista;
    }
    //Metodo  que efectua o reset do contador parcial de consumo em todas as lâmpadas
    public void reset(){
        for(Lampada lampada : this.lampadas){
            lampada.setMilisecs(0);
        }
    }

    //Metodo  que devolve as três lâmpadas mais económicas da casa
    public Set<Lampada> podiumEconomia(){
        Set<Lampada> lampadasOrd = new TreeSet<>(new LampadaComparatorECO());
        Set<Lampada> lampadasPodium = new HashSet<>();
        for(Lampada lampada: this.lampadas){
            lampadasOrd.add(lampada);
        }
        int i = 0;
        for(Lampada lampada: lampadasOrd){
            lampadasPodium.add(lampada);
            i++;
            if(i>2) break;
        }
        return lampadasPodium;
    }

    // Classe auxiliar que permite comparar as lampadas no método acima
    private class LampadaComparatorECO implements Comparator<Lampada> {

        public int compare(Lampada lampada1, Lampada lampada2) {
            
            return (Integer.compare(lampada1.getConsumoEco(), lampada2.getConsumoEco()));
        }
    }

}