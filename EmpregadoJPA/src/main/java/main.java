import jakarta.persistence.Query;

import java.sql.Date;
import java.util.List;

public class main {

    public static void main(String[]args){
      EmpregadoDAO conexao = new EmpregadoDAO();
      conexao.iniciar();
        List<Empregado> empregados = conexao.buscarTudo();

        System.out.println(empregados);

        for (Empregado emp: empregados){
            System.out.println(emp);
        }


        conexao.encerrar();
    }





}
