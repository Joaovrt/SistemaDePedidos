public class Item {
    private int qtd;
    private Produto p;
    private double valorTotal;

    public Item(int qtd, Produto p) {
        this.qtd = qtd;
        this.p = p;
        valorTotal = qtd*p.getValorUnitario();
    }

    public void imprimeDados(){
        p.imprimeDados();
        System.out.println("Quantidade: "+qtd);
        System.out.println("Valor total: R$"+valorTotal);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
