public class Data {
    String data;

    public int retornaDia(){
        int dia=Integer.parseInt(data.substring(0,2));
        return dia;
   }

    public int retornaMes(){
        int mes=Integer.parseInt(data.substring(3,5));
        return mes;
    }

    public int retornaAno(){
        int ano=Integer.parseInt(data.substring(6,10));
        return ano;
    }

    public Data(String data) {
        this.data = data;
    }

    public Data(){}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
