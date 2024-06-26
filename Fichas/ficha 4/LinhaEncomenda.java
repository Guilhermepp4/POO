public class LinhaEncomenda {
    private String codigo;
    private String descricao;
    private double preco;
    private int quantidade;
    private double impostos;
    private double descontos;

    //Construtor por omissao
    public LinhaEncomenda(){
        this.codigo = "";
        this.descricao = "";
        this.preco = 0.0;
        this.quantidade = 0;
        this.impostos = 0.0;
        this.descontos = 0; 
    }
    
    //Construtor parametrizado
    public LinhaEncomenda(String codigo, String descricao, double preco, int quantidade, double impostos, double descontos){
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.impostos = impostos;
        this.descontos = descontos; 
    }


    //Construtor copia
    public LinhaEncomenda(LinhaEncomenda linhaE){
        this.codigo = linhaE.getCodigo();
        this.descricao = linhaE.getDescricao();
        this.preco = linhaE.getPreco();
        this.quantidade = linhaE.getQuantidade();
        this.impostos = linhaE.getImpostos();
        this.descontos = linhaE.getDescontos();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getImpostos() {
        return impostos;
    }

    public void setImpostos(double impostos) {
        this.impostos = impostos;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    //Metodo toString
    public String toString(){
        return "Referencia: " + this.codigo + "\n" +
               "Descrição: " + this.descricao + "\n" +
               "Preco: " + this.preco + "\n" +
               "Quantidade: " + this.quantidade + "\n" +
               "Imposto: " + this.impostos + "\n" + 
               "Desconto: " + this.descontos + "\n";
    }

    //Metodo clone
    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }

    //Metodo equals
    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        LinhaEncomenda s = (LinhaEncomenda) o;
        return this.codigo == s.codigo && this.descricao == s.descricao && this.preco == s.preco && 
        this.quantidade == s.quantidade && this.impostos == s.impostos&& this.descontos == s.descontos;
    }

    //Metodo que determina o valor da venda já considerados os impostos e os descontos
    public double calculaValorLinhaEnc(){
        return this.preco * this.impostos * this.quantidade/ this.descontos;
    }

    //Metodo  que determina o valor numérico (em euros) do desconto
    public double calculaValorDesconto(){
        double precoTotal = this.preco * this.impostos;
        double precoAfterDescont = precoTotal/this.descontos;
        return precoTotal - precoAfterDescont;
    }
}
