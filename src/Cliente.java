public class Cliente {
    private String nome;
    private String email;
    private boolean fisica;
    private String cpf;
    private String cnpj;
    private int qtdMaxParcelamento;
    private Data prazoMaxFaturamento;

    public Cliente(String nome, String email, boolean fisica, String cpf, String cnpj, int qtdMaxParcelamento, Data prazoMaxFaturamento){
        this.nome=nome;
        this.email=email;
        this.fisica=fisica;
        if(fisica){
            this.cpf=cpf;
            this.qtdMaxParcelamento = qtdMaxParcelamento;
            this.cnpj="";
            this.prazoMaxFaturamento=prazoMaxFaturamento;
        }
        else{
            this.cnpj=cnpj;
            this.prazoMaxFaturamento=prazoMaxFaturamento;
            this.cpf="";
            this.qtdMaxParcelamento = 0;
        }
    }

    public void imprimeDados(){
        System.out.println("\nNome cliente: "+nome);
        System.out.println("E-mail cliente: "+email);
        if(fisica){
            System.out.println("Cpf cliente: "+cpf);
            System.out.println("Quantida maxima de parcelamento: "+qtdMaxParcelamento);
        }
        else{
            System.out.println("Cnpj cliente: "+cnpj);
            System.out.println("Prazo maximo de faturamento: "+prazoMaxFaturamento.getData());
        }
    }

    public boolean isFisica() {
        return fisica;
    }

    public void setFisica(boolean fisica) {
        this.fisica = fisica;
    }

    public Data getPrazoMaxFaturamento() {
        return prazoMaxFaturamento;
    }

    public void setPrazoMaxFaturamento(Data prazoMaxFaturamento) {
        this.prazoMaxFaturamento = prazoMaxFaturamento;
    }

    public int getQtdMaxParcelamento() {
        return qtdMaxParcelamento;
    }

    public void setQtdMaxParcelamento(int qtdMaxParcelamento) {
        this.qtdMaxParcelamento = qtdMaxParcelamento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
