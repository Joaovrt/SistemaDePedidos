import java.util.ArrayList;

public class Pedido {
    private int id;
    private Data data;
    private double valorTotal;
    private String cpf;
    private boolean pago;
    private ArrayList<Item> itens;

    public Pedido(int id, Data data, String cpf) {
        this.id = id;
        this.data = data;
        this.cpf = cpf;
        itens=new ArrayList<>();
        pago = false;
    }

    public Pedido(){}

    public void imprimeDados(){
        System.out.println("\nId pedido: "+id);
        System.out.println("Data efetuado: "+data.getData());
        System.out.println("Valor total: R$"+valorTotal);
        System.out.println("Cpf/cnpj do cliente: "+cpf);
        System.out.print("Pago? ");
        if(pago)
            System.out.print("Sim");
        else
            System.out.print("Nao");
        for(Item i: itens)
            i.imprimeDados();
    }

    public boolean estaDentroDoIntervalo(Data dataInf, Data dataSup){
        boolean estaDentro = false;
        if(data.retornaAno()>dataInf.retornaAno()&&data.retornaAno()<dataSup.retornaAno())
            estaDentro=true;
        else{
            if(data.retornaAno()==dataInf.retornaAno()){
                if(data.retornaMes()>dataInf.retornaMes())
                    estaDentro=true;
                else{
                    if(data.retornaMes()==dataInf.retornaMes()){
                        if(data.retornaDia()>=dataInf.retornaDia())
                            estaDentro=true;
                    }
                }
            }
            if(data.retornaAno()==dataSup.retornaAno()){
                if(data.retornaMes()<dataSup.retornaMes())
                    estaDentro=true;
                else{
                    if(data.retornaMes()==dataSup.retornaMes()){
                        if(data.retornaDia()<=dataSup.retornaDia())
                            estaDentro=true;
                    }
                }
            }
        }
        return estaDentro;
    }

    public void calculaValorTotal(){
        valorTotal=0;
        for(Item i: itens)
            valorTotal+=i.getValorTotal();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
