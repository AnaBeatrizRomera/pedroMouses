import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        PessoaDAO conexao = new PessoaDAO();
        Scanner input = new Scanner(System.in);

        conexao.iniciar();
        List<Pessoa> pessoas = conexao.buscarTudo("idade","28");
        if (pessoas==null){
            System.out.println("Nenhum registro econtrado");
        }else {
            for (Pessoa emp : pessoas) {
                System.out.println(emp);
            }
        }
//        Pessoa pessoa = new Pessoa(105,"Ana Bia",16,1.50,42,"FEMNINO","SÃO PAULO - SP",0,1,1,1);
//        System.out.println(conexao.inserir(pessoa));
//        System.out.println(conexao.alterar("17","idade","codigo","105"));
        System.out.println(conexao.remover("nome","BIA"));

        conexao.encerrar();
    }
}
