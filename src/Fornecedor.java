public class Fornecedor {
    private String nome;
    private String cnpj;
    private Produto p;

    public Fornecedor(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        p=new Produto();
    }

    public Fornecedor(){}

    public void imprimeDados(){
        System.out.println("\nNome fornecedor: "+nome);
        System.out.println("Cnpj fornecedor: "+cnpj);
        if(p.getValorUnitario()==-1)
            System.out.println("Fornecedor ainda sem produto");
        else
            p.imprimeDados();
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
