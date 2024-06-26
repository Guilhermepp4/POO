import java.util.ArrayList;

public class Encomenda {
    
    private String nome;
    private String nif;
    private String morada;
    private int numEnc;
    private int[] data;
    private ArrayList<LinhaEncomenda> encomenda;

    //Construtores:
    // Construtor por Omissão
    public Encomenda(){
        this.nome = "";
        this.nif = "";
        this.morada = "";
        this.numEnc = 0;
        this.data = new int[] {0,0,0};
        this.encomenda = new ArrayList<>();
    }

    // Construtor Parametrizado
    public Encomenda(String nome, String nif, String morada, int numEnc, int[] data, ArrayList<LinhaEncomenda> encomenda){
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numEnc = numEnc;
        this.data = data;
        this.encomenda = encomenda;
    }

    // Construtor Cópia
    public Encomenda(Encomenda e){
        this.nome = e.getNome();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.numEnc = e.getNumEnc();
        this.data = e.getData();
        this.encomenda = e.getEncomenda();
    }

    //Getters e Setters:
    public String getNome(){
        return this.nome;
    }

    public String getNif(){
        return this.nif;
    }

    public String getMorada(){
        return this.morada;
    }

    public int getNumEnc(){
        return this.numEnc;
    }   

    public int[] getData(){
        return this.data;
    }       

    public ArrayList<LinhaEncomenda> getEncomenda(){
        return this.encomenda;
    }   

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNif(String nif){
        this.nif = nif;
    }

    public void setMorada(String morada){
        this.morada = morada;
    }

    public void setNumEnc(int numEnc){
        this.numEnc = numEnc;
    }

    public void setData(int[] data){
        this.data = data;
    }

    public void setEncomenda(ArrayList<LinhaEncomenda> encomenda){
        this.encomenda = encomenda;
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public String toString(){
        return "Nome: " + this.nome + "\n" +
               "NIF: " + this.nif + "\n" +
               "Morada: " + this.morada + "\n" +
               "Número de Encomenda: " + this.numEnc + "\n" +
               "Data: " + this.data[0] + "/" + this.data[1] + "/" + this.data[2] + "\n" +
               "Encomenda: " + this.encomenda.toString() + "\n";
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Encomenda e = (Encomenda) o;
        return this.nome.equals(e.getNome()) &&
               this.nif.equals(e.getNif()) &&
               this.morada.equals(e.getMorada()) &&
               this.numEnc == e.getNumEnc() &&
               this.data.equals(e.getData()) &&
               this.encomenda.equals(e.getEncomenda());
    }

    //método que determina o valor total da encomenda 
    
    public double calculaValorTotal(){
        double valor = 0.0;
        for(LinhaEncomenda linha : this.encomenda){
            valor += linha.calculaValorLinhaEnc();
        }
        return valor;
    }

    //Método que determina o valor total dos descontos obtidos nos diversos produtos encomendados 
    public double calculaValorDesconto(){
        double descontoTotal = 0.0;
        for(LinhaEncomenda linha : this.encomenda){
            descontoTotal += linha.calculaValorDesconto();
        }
        return descontoTotal;
    }

    //Método que determina o número total de produtos a receber
    public int numeroTotalProdutos(){
        int numero = 0;
        for(LinhaEncomenda linha : this.encomenda){
            numero += linha.getQuantidade();
        }
        return numero;
    }

    //Método que determina se um produto vai ser encomendado, 
    public boolean existeProdutoEncomenda(String refProduto){
        for(LinhaEncomenda linha : this.encomenda){
            if(linha.getCodigo() == refProduto){
                return true;
            }
        }
        return false;
    }

    //Método que adiciona uma nova linha de encomenda
    public void adicionaLinha(LinhaEncomenda linha){
        this.encomenda.add(linha);
    }

    //Método que remove uma linha de encomenda dado a referência do produto 
    public void removeProduto(String codProd){
        for(LinhaEncomenda linha : encomenda){
            if(linha.getCodigo() == codProd){
                encomenda.remove(linha);
                break;
            }
        }
    }
}
