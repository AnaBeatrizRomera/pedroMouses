import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//Input
        Scanner input = new Scanner(System.in);

//  Atributos
    int opcao=1;
    boolean verificacao=false;
    int custid=0;
    String name;
    String address;
    String city;
    String state;
    String zip;
    int area=0;
    String phone;
    int repid=0;
    double creditlimit=0;
    String comments;






    //    Instanciando classe
        Conexao conexao = new Conexao();



        do {
            while (verificacao==false) {
                try {
                    System.out.println("""
                                Escolha uma opção:
                        [1] Inserir
                        [2] Alterar
                        [3] Remover
                        [4] Buscar
                        [5] Conectar
                        [6] Desconectar
                        [0] Sair 
                               
                                
                                """);
                    opcao = input.nextInt();
                    if (opcao<0 || opcao>6){
                        throw new Exception();
                    }
                    verificacao=true;

                }catch (InputMismatchException ime){
                    System.out.println("\u001B[31mOps,algo deu errado,digite apenas números: \u001B[m");
                    input.nextLine();
                    verificacao=false;
                }catch (Exception e){
                    System.out.println("\u001B[31mOps,algo deu errado,digite uma opção válida:  \u001B[m");
                    input.nextLine();
                    verificacao=false;
                }

            }

            switch (opcao){

                case 1 -> {

                    System.out.println("Vamos inserir!");
                    verificacao = false;
                    while (verificacao==false) {
                        try {
                            System.out.println("Digite o cutid: ");
                            custid = input.nextInt();
                            if (custid < 0) {
                                throw new Exception();
                            }
                            verificacao=true;
                        } catch (InputMismatchException ime) {
                            System.out.println("\u001B[31mOps,algo deu errado,digite apenas números: \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        } catch (Exception e) {
                            System.out.println("\u001B[31mOps,algo deu errado,digite um número positivo:  \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }

                    }
                    System.out.println("Digite o nome: ");
                    input.nextLine();
                    name = input.nextLine();
                    System.out.println("Digite o endereço: ");
                    address = input.nextLine();
                    System.out.println("Digite a cidade: ");
                    city = input.nextLine();
                    System.out.println("Digite o estado: ");
                    state = input.nextLine();
                    System.out.println("Digite o CEP: ");
                    zip = input.nextLine();
                    verificacao=false;
                    while (verificacao==false) {
                        try {
                            System.out.println("Digite o código de área: ");
                            area = input.nextInt();
                            if (area<0){
                                throw new Exception();
                            }
                            verificacao=true;
                        }catch (InputMismatchException ime){
                            System.out.println("\u001B[31mOps,algo deu errado,digite apenas números: \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }catch (Exception e){
                            System.out.println("\u001B[31mOps,algo deu errado,digite um número positivo:  \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }

                    }
                    input.nextLine();
                    System.out.println("Digite o telefone: ");
                    phone=input.nextLine();
                    verificacao=false;
                    while (verificacao==false){
                        try {
                            System.out.println("Digite o repid: ");
                            repid = input.nextInt();
                            if (repid<0){
                                throw new Exception();
                            }
                            verificacao=true;
                        }catch (InputMismatchException ime){
                            System.out.println("\u001B[31mOps,algo deu errado,digite apenas números: \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }catch (Exception e){
                            System.out.println("\u001B[31mOps,algo deu errado,digite um número positivo:  \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }
                    }
                    verificacao=false;
                    while (verificacao==false){
                        try {
                            System.out.println("Digite o limite de crédito: ");
                            creditlimit = input.nextDouble();
                            if (creditlimit<0){
                                throw new Exception();
                            }
                            verificacao=true;
                        }catch (InputMismatchException ime){
                            System.out.println("\u001B[31mOps,algo deu errado,digite apenas números: \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }catch (Exception e){
                            System.out.println("\u001B[31mOps,algo deu errado,digite um número positivo:  \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }
                    }
                    input.nextLine();
                    System.out.println("Digite o complemento: ");
                    comments = input.nextLine();

                    boolean inserir=conexao.inserir(custid,name,address,city,state,zip,area,phone,repid,creditlimit,comments);

                    if (inserir==false){
                        System.out.println("Inserido com sucesso!");
                    }else {
                        System.out.println("Erro ao inserir!");
                    }
                    verificacao=false;
                } case 2 ->{
                    System.out.println("Vamos alterar o nome!");
                    verificacao=false;
                    while (verificacao==false){
                        try {
                            System.out.println("Digite o cutid: ");
                            custid=input.nextInt();
                            if (custid<0){
                                throw new Exception();
                            }
                            verificacao=true;
                        }catch (InputMismatchException ime){
                            System.out.println("\u001B[31mOps,algo deu errado,digite apenas números: \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }catch (Exception e){
                            System.out.println("\u001B[31mOps,algo deu errado,digite um número positivo:  \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }
                    }
                    input.nextLine();
                    System.out.println("Digite o novo nome: ");
                    name=input.nextLine();
                    boolean alterarNome = conexao.alterarNome(custid,name);
                    if (alterarNome==false){
                        System.out.println("Alteração feita com sucesso!");
                    }else {
                        System.out.println("Erro ao alterar!");
                    }
                    verificacao=false;
                }case 3 ->{
                    System.out.println("Vamos remover!");
                    verificacao=false;
                    while (verificacao==false){
                        try {
                            System.out.println("Digite o cutid a ser removido: ");
                            custid=input.nextInt();
                            if (custid<0){
                                throw new Exception();
                            }
                            verificacao=true;
                        }catch (InputMismatchException ime){
                            System.out.println("\u001B[31mOps,algo deu errado,digite apenas números: \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }catch (Exception e){
                            System.out.println("\u001B[31mOps,algo deu errado,digite um número positivo:  \u001B[m");
                            input.nextLine();
                            verificacao=false;
                        }
                    }
                    boolean remover = conexao.remover(custid);
                    if (remover==false){
                        System.out.println("Sucesso ao remover!");
                    }else {
                        System.out.println("Erro ao remover!");
                    }
                    verificacao=false;
                } case 4 -> {
                    System.out.println("Vamos buscar!");

                    ResultSet rs =conexao.buscar();
                    try {

                        while (rs.next()){
            String lista = ("\nCustid: "+rs.getInt("CUSTID")+"\n-"+"Nome: "+
                    rs.getString("NAME")+"\n-"+"Endereço: "+rs.getString("ADDRESS")+
                    "\n-"+"Cidade: "+rs.getString("CITY")+"\n-"+"Estado: "+rs.getString("STATE")+
                    "\n-"+"CEP: "+rs.getString("ZIP")+"\n-"+"Código de área: "+rs.getInt("AREA")+
                    "\n-"+"Telefone: "+rs.getString("PHONE")+"\n-"+"Repid: "+rs.getInt("REPID")+
                    "\n-"+"Limite de crédito: "+rs.getDouble("CREDITLIMIT")+"\n-"+"Complemento: "+rs.getString("COMMENTS"));
            System.out.println(lista);
                        }

                    }catch (SQLException sqle){
                        System.out.println("Erro no comando SQL");
                    }
                    verificacao=false;
                } case 5 -> {
                    System.out.println("Vamos conectar ao banco!");
                    boolean conectar = conexao.conectar();
                    if (conectar==false){
                        System.out.println("Conectado com sucesso!");
                    }else {
                        System.out.println("Erro ao conectar!");
                    }
                    verificacao=false;
                } case 6 -> {
                    conexao.desconectar();
                    verificacao=false;
                }

            }

        }while (opcao!=0);
    }
}