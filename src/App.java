import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        int op,opRelatorio,qtdMaxParcelamento=0,idPedidos=1,qtd=0;
        String nome="", email="", cpf="", cnpj="",descricao="",prazo="";
        Data data=new Data(), dataMaisNova;
        char fisicaOuJuridica,opcao=' ';
        double valorUnitario=0,totalPedidosAbertos=0;
        boolean achouCpf=false,achouProduto=false,achouPedido=false,achouFornecedor=false;
        Scanner entrada = new Scanner(System.in);
        Scanner entradaStr = new Scanner(System.in);
        Cliente c;
        Fornecedor f = new Fornecedor();
        Produto p = new Produto();
        Pedido pedido = new Pedido();
        Item i;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        do 
        {
            achouCpf=false;
            achouProduto=false;
            achouPedido=false;
            achouFornecedor=false;
            totalPedidosAbertos=0;
            op = escolhaMenu();
            switch(op) {

                case 1: 
                        System.out.println("\n--- Cadastro Cliente ---");
                        System.out.println("Digite o nome:");
                        nome = entradaStr.nextLine(); 
                        System.out.println("Digite o email:");
                        email = entradaStr.nextLine(); 
                        do
                        {
                            System.out.println("Tecle [F] para pessoa fisica ou [J] para juridica:");
                            fisicaOuJuridica = entradaStr.nextLine().charAt(0);
                            if(fisicaOuJuridica=='f' || fisicaOuJuridica=='F'){

                                boolean verifica = false;
                                do{
                                System.out.println("Digite o cpf (apenas numeros):");
                                
                                cpf = entradaStr.nextLine();
                                if(clientes.size() == 0){
                                    verifica = true;
                                }
                                for(int j=0; j<clientes.size();j++){
                                    if(clientes.get(j).getCpf().equals(cpf)){
                                        System.out.println("CPF já utilizado");
                                        verifica = false;
                                        j = clientes.size();
                                    }
                                    else{
                                        verifica = true;
                                    }
                                    
                                }
                                }while(verifica == false);


                                System.out.println("Digite a quantidade maxima de parcelamento possivel:");
                                qtdMaxParcelamento = entrada.nextInt();
                            }
                            else if(fisicaOuJuridica=='j' || fisicaOuJuridica=='J'){
                                
                                boolean verifica = false;
                                do{
                                System.out.println("Digite o cnpj (apenas numeros):");

                                cnpj = entradaStr.nextLine();
                                if(clientes.size() ==0)
                                    verifica=true;
                                
                                for(int j=0; j<clientes.size(); j++){
                                    if(clientes.get(j).getCnpj().equals(cnpj)){
                                        System.out.println("CPNJ já utilizado");
                                        verifica = false;
                                        j = clientes.size();
                                    }
                                    else{
                                        verifica = true;
                                    }
                                }
                                }while(verifica == false);
                                do
                                {
                                    System.out.println("Digite o prazo maximo para faturamento no formato xx/xx/xxxx:");
                                    prazo = entradaStr.nextLine();
                                    if(!(verificaData(prazo)))
                                        System.out.println("Formato da data incorreto");
                                }while(!(verificaData(prazo)));
                            }
                            else
                                System.out.println("Letra digitada incorretamente");
                        } while(!(fisicaOuJuridica=='f'|| fisicaOuJuridica=='F'||fisicaOuJuridica=='j' || fisicaOuJuridica=='J'));
                        data=new Data(prazo);
                        if(fisicaOuJuridica=='f'|| fisicaOuJuridica=='F')
                            c = new Cliente(nome, email, true, cpf, cnpj, qtdMaxParcelamento, data);
                        else
                            c = new Cliente(nome, email, false, cpf, cnpj, qtdMaxParcelamento, data);
                        clientes.add(c);
                        System.out.print("\nTecle [ENTER] para continuar ");
                        System.in.read();
                        break;

                case 2: 
                        System.out.println("\n-- Cadastro Fornecedor -");
                        System.out.println("Digite o nome:");
                        nome = entradaStr.nextLine();

                        boolean verifica = false;
                        do{
                            System.out.println("Digite o cnpj (apenas numeros):");


                            cnpj = entradaStr.nextLine();
                            if(fornecedores.size() ==0)
                                verifica=true;
                            for(int j=0; j<fornecedores.size(); j++){
                                if(fornecedores.get(j).getCnpj().equals(cnpj)){
                                    System.out.println("CPNJ já utilizado");
                                    verifica = false;
                                    j = fornecedores.size();
                                }
                                else{
                                    verifica = true;
                                }
                            }
                        }while(verifica == false);
                        f = new Fornecedor(nome, cnpj);
                        fornecedores.add(f);
                        System.out.print("\nTecle [ENTER] para continuar ");
                        System.in.read();
                        break;

                case 3: 
                        if(fornecedores.isEmpty())
                            System.out.println("\nNenhum fornecedor cadastrado");
                        else{
                            System.out.println("\n--- Cadastro Produto ---");
                            System.out.println("Digite o nome:");
                            nome = entradaStr.nextLine();
                            System.out.println("Digite a descricao:");
                            descricao = entradaStr.nextLine();
                            System.out.println("Digite o valor unitario:");
                            valorUnitario = entrada.nextDouble();
                            System.out.println("Digite o cnpj do Fornecedor:");
                            cnpj = entradaStr.nextLine();
                            for(Fornecedor fornecedor: fornecedores)
                                if(fornecedor.getCnpj().equals(cnpj))
                                    if(fornecedor.getP().getValorUnitario()==-1)
                                    {
                                        f=fornecedor;
                                        achouFornecedor=true;
                                    }
                            if(achouFornecedor){
                                p = new Produto(nome, descricao, valorUnitario,f);
                                f.setP(p);
                                produtos.add(p);
                            }
                            else
                                System.out.println("Fornecedor nao encontrado ou ja possui produto");
                        }
                        System.out.print("\nTecle [ENTER] para continuar ");
                        System.in.read();
                        break;
                        
                case 4: 
                        if(clientes.isEmpty()||produtos.isEmpty()){
                            System.out.println("\nClientes e/ou produtos nao registrados");
                        }
                        else{
                            System.out.println("\n----- Efetua Pedido ----");
                            do
                            {
                            System.out.println("Digite o cpf/cnpj do cliente:");
                            cpf = entradaStr.nextLine();
                            for (Cliente cliente: clientes){
                                if(cliente.getCpf().equals(cpf)||cliente.getCnpj().equals(cpf)){
                                    achouCpf=true;
                                }
                            }
                            if(!achouCpf){
                                System.out.println("Cpf/cnpj nao encontrado");
                            }
                            else{
                                do
                                {
                                    System.out.println("Digite a data do pedido no formato XX/XX/XXXX:");
                                    prazo = entradaStr.nextLine();
                                    if(!(verificaData(prazo)))
                                        System.out.println("Formato da data incorreto");
                                }while(!(verificaData(prazo)));
                                data = new Data(prazo);
                                pedido = new Pedido(idPedidos, data, cpf);
                                do
                                {
                                    achouProduto=false;
                                    System.out.println("Digite o nome do item:");
                                    nome = entradaStr.nextLine();
                                    for(Produto produto: produtos)
                                        if(produto.getNome().equals(nome)){
                                            achouProduto=true;
                                            p=produto;
                                            break;
                                        }
                                    if(!achouProduto)
                                        System.out.println("Produto nao encontrado");
                                    else{
                                        System.out.println("Digite a quantidade:");
                                        qtd=entrada.nextInt();
                                        i=new Item(qtd, p);
                                        pedido.getItens().add(i);
                                        do{
                                            System.out.println("Deseja adicionar mais um item? [S]im ou [N]ao:");
                                            opcao = entradaStr.nextLine().charAt(0);
                                            if(opcao!='s'&&opcao!='S'&&opcao!='n'&&opcao!='N')
                                                System.out.println("Opcao invalida");
                                        }while(opcao!='s'&&opcao!='S'&&opcao!='n'&&opcao!='N');
                                    }
                                }while(!achouProduto||(opcao=='s'||opcao=='S'));
                                pedido.calculaValorTotal();
                                pedidos.add(pedido);
                                idPedidos++;
                                System.out.println("ID do pedido: " + pedido.getId());
                            }
                            }while(!achouCpf);
                        }
                        
                        System.out.print("\nTecle [ENTER] para continuar ");
                        System.in.read();
                        break;

                case 5: 
                        if(pedidos.isEmpty()){
                            System.out.println("\nNao há pedidos registrados");
                        }
                        else{
                            System.out.println("\n--- Baixa de pedido ---");
                            do
                            {
                                System.out.println("Digite o ID do pedido a ser pago:");
                                qtd = entrada.nextInt();
                                for(Pedido ped: pedidos)
                                    if(ped.getId()==qtd){
                                        pedidos.get(pedidos.indexOf(ped)).setPago(true);
                                        achouPedido=true;
                                    }
                                if(achouPedido)
                                    System.out.println("Pedido pago");
                                else
                                    System.out.println("Pedido nao encontrado");
                            }while(!achouPedido);
                        }
                        System.out.print("\nTecle [ENTER] para continuar ");
                        System.in.read();
                        break;

                case 6: 
                        opRelatorio = escolhaRelatorio();
                        switch(opRelatorio){
                            case 1:
                                    if(clientes.isEmpty())
                                        System.out.println("\nNenhum cliente cadastrado");
                                    else{
                                        System.out.println("-\n--- Listagem Clientes ----");
                                        for(Cliente cliente: clientes)
                                            cliente.imprimeDados();
                                    }
                                    break;
                                    
                            case 2:
                                    if(fornecedores.isEmpty())
                                        System.out.println("\nNenhum fornecedor cadastrado");
                                    else{
                                        System.out.println("\n-- Listagem Fornecedores --");
                                        for(Fornecedor fornecedor: fornecedores)
                                            fornecedor.imprimeDados();
                                    }
                                    break;

                            case 3:
                                    if(produtos.isEmpty())
                                        System.out.println("\nNenhum produto cadastrado");
                                    else{
                                        System.out.println("\n---- Listagem Produtos ----");
                                        for(Produto produto: produtos)
                                            produto.imprimeDados();
                                        }
                                    break;

                            case 4:
                                    if(pedidos.isEmpty())
                                        System.out.println("\nNenhum pedido cadastrado");
                                    else{
                                        System.out.println("\n----- Listagem Pedidos ----");
                                        for(Pedido ped: pedidos)
                                            ped.imprimeDados();
                                    }
                                    break;

                            case 5:
                                    if(pedidos.isEmpty()){
                                        System.out.println("\nNao há pedidos registrados");
                                    }
                                    else{
                                        System.out.println("\n---- Pedidos entre datas ---");
                                        do
                                        {
                                            do
                                            {
                                                System.out.println("Digite a data mais antiga:");
                                                prazo = entradaStr.nextLine();
                                                if(!(verificaData(prazo)))
                                                    System.out.println("Formato da data incorreto");
                                            }while(!(verificaData(prazo)));
                                            data = new Data(prazo);
                                            do
                                            {
                                                System.out.println("Digite a data mais nova:");
                                                prazo = entradaStr.nextLine();
                                                if(!(verificaData(prazo)))
                                                    System.out.println("Formato da data incorreto");
                                            }while(!(verificaData(prazo)));
                                            dataMaisNova = new Data(prazo);
                                            for(Pedido ped:pedidos)
                                                if(ped.estaDentroDoIntervalo(data, dataMaisNova)==true){
                                                    ped.imprimeDados();
                                                    achouPedido=true;
                                                }
                                            if(!achouPedido)
                                                System.out.println("Pedidos nao encontrados dentro do intervalo"); 
                                        }while(!achouPedido);    
                                    }
                                    break;

                            case 6:
                                    if(pedidos.isEmpty()){
                                        System.out.println("\nNao há pedidos registrados");
                                    }
                                    else{
                                        System.out.println("\n- Busca pedido por numero -");
                                        do
                                        {
                                            System.out.println("\nDigite o numero do pedido:");
                                            qtd = entrada.nextInt();
                                            for(Pedido ped: pedidos)
                                                if(ped.getId()==qtd){
                                                    pedido=ped;
                                                    achouPedido=true;
                                                }
                                            if(achouPedido)
                                                pedido.imprimeDados();
                                            else
                                                System.out.println("Pedido nao encontrado");
                                        }while(!achouPedido);
                                    }
                                    break;

                            case 7:
                                    if(pedidos.isEmpty())
                                            System.out.println("\nNenhum pedido cadastrado");
                                    else{
                                        System.out.println("\n-- Listagem Pedidos Pagos -");
                                        for(Pedido ped: pedidos)
                                            if(ped.isPago()==true)
                                                ped.imprimeDados();
                                    }
                                    break;

                            case 8:
                                    if(produtos.isEmpty()){
                                        System.out.println("\nNao há produtos registrados");
                                    }
                                    else{
                                        System.out.println("\n-- Busca produto por nome -");
                                        do
                                        {
                                            System.out.println("Digite o nome do produto:");
                                            nome = entradaStr.nextLine();
                                            for(Produto produto: produtos)
                                                if(produto.getNome().equals(nome)){
                                                    p=produto;
                                                    achouProduto=true;
                                                }
                                            if(achouProduto)
                                                p.imprimeDados();
                                            else
                                                System.out.println("Produto nao encontrado");
                                        }while(!achouProduto);
                                    }
                                    break;

                            case 9:
                                    if(pedidos.isEmpty())
                                    System.out.println("\nNenhum pedido cadastrado");
                                    else{
                                        System.out.println("\n- Total Pedidos em aberto -");
                                        for(Pedido ped: pedidos)
                                            if(ped.isPago()==false)
                                                totalPedidosAbertos+=ped.getValorTotal();
                                        System.out.println("Valor: "+totalPedidosAbertos);
                                    }
                                    break;
                        }
                        System.out.print("\nTecle [ENTER] para continuar ");
                        System.in.read();
                        break;

                case 7: 
                        System.out.println("\n--- Finalizando programa");
                        break;
            }
        }while(op!=7);
    }

    public static  int escolhaMenu() {
        Scanner entrada = new Scanner(System.in);
        int op; 
        System.out.println("--------- Menu ---------");
        System.out.println("[1] Cadastrar Cliente");
        System.out.println("[2] Cadastrar Fornecedor");
        System.out.println("[3] Cadastrar Produto");
        System.out.println("[4] Efetuar Pedido");
        System.out.println("[5] Baixa de pagamento");
        System.out.println("[6] Relatorios");
        System.out.println("[7] Sair");
        System.out.println("------------------------");
      
        do 
        {
            System.out.print("Escolha uma opcao: ");
            op = entrada.nextInt();
        } while (op < 1 || op > 7);
        return op;
    }

    public static  int escolhaRelatorio() {
        Scanner entrada = new Scanner(System.in);
        int op; 
        System.out.println("-------- Relatorios -------");
        System.out.println("[1] Listagem Clientes");
        System.out.println("[2] Listagem Fornecedores");
        System.out.println("[3] Listagem Produtos");
        System.out.println("[4] Listagem Pedidos");
        System.out.println("[5] Pedidos entre datas");
        System.out.println("[6] Pedido por id");
        System.out.println("[7] Pedidos pagos");
        System.out.println("[8] Produto por nome");
        System.out.println("[9] Total pedidos em aberto");
        System.out.println("---------------------------");
      
        do 
        {
            System.out.print("Escolha uma opcao: ");
            op = entrada.nextInt();
        } while (op < 1 || op > 9);
        return op;
    }

    public static boolean verificaData(String data){
        boolean ok;
        if(data.length() == 10 && Integer.parseInt(data.substring(6,10))>=1900){
            if (Integer.parseInt(data.substring(3,5))>=1 && Integer.parseInt(data.substring(3,5))<=12) //se mês está entre 1 e 12
            {
                if((Integer.parseInt(data.substring(3,5))==4 || Integer.parseInt(data.substring(3,5))==6 || Integer.parseInt(data.substring(3,5))==9 || Integer.parseInt(data.substring(3,5))==11) && (Integer.parseInt(data.substring(0,2))>=1 && Integer.parseInt(data.substring(0,2))<=30))//se for um dos meses que tem trinta dias e o dia está entre 1 e 30
                    ok=true;//válido
                else if ((Integer.parseInt(data.substring(3,5))==1 || Integer.parseInt(data.substring(3,5))==3 || Integer.parseInt(data.substring(3,5))==5 || Integer.parseInt(data.substring(3,5))==7 || Integer.parseInt(data.substring(3,5))==8 || Integer.parseInt(data.substring(3,5))==10 || Integer.parseInt(data.substring(3,5))==12) && (Integer.parseInt(data.substring(0,2))>=1 && Integer.parseInt(data.substring(0,2))<=31)) //se for um dos meses que tem trinta e um dias e o dia está entre 1 e 31
                    ok=true; //válido
                else if (Integer.parseInt(data.substring(3,5))==2 && bissexto(Integer.parseInt(data.substring(6,10)))==1 && (Integer.parseInt(data.substring(0,2))>=1 && Integer.parseInt(data.substring(0,2))<=29)) //se for em fevereiro, ano bissexto e dia entre 1 e 29
                    ok=true; //válido
                else if (Integer.parseInt(data.substring(3,5))==2 && bissexto(Integer.parseInt(data.substring(6,10)))==0 && (Integer.parseInt(data.substring(0,2))>=1 && Integer.parseInt(data.substring(0,2))<=28)) //se for em fevereiro, ano não bissexto e dia entre 1 e 28
                    ok=true; //válido
                else
                    ok=false; //inválido
            }
            else
                ok=false; //inválido
        }
        else
        {
            ok=false;
        }

        return ok;
    }

    public static int bissexto(int ano){
      
        if(ano%4==0) //divisível por quatro
         {
             if(ano%100==0) //divisível por cem
            {
                 if(ano%400==0) //divisível por 400
                     return 1; //é bissexto
                 else
                    return 0; //não é bissexto			
            }
            else
                 return 1; //é bissexto
        }
        else
            return 0; //não é bissexto
    }
}