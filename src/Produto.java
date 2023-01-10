public class Produto {
    private String nome;
    private String descricao;
    private double valorUnitario;
    private Fornecedor f;

    public Produto(){
        valorUnitario=-1;
    }

    public Produto(String nome, String descricao, double valorUnitario, Fornecedor f) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.f=f;
    }

    public void imprimeDados(){
        System.out.println("\nNome produto: "+nome);
        System.out.println("Descricao produto: "+descricao);
        System.out.println("Valo unitario: R$"+valorUnitario);
        System.out.println("Nome do fornecedor: "+f.getNome());
    }

    public Fornecedor getF() {
        return f;
    }

    public void setF(Fornecedor f) {
        this.f = f;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
