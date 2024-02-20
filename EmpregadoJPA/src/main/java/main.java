import jakarta.persistence.Query;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[]args) {
        EmpregadoDAO conexao = new EmpregadoDAO();
        Scanner input = new Scanner(System.in);


        int opcao = 1;
        boolean verificar = false;
        float mgr = 0;
        float empno = 0;
        String ename = "Null";
        String job= "Null";
        float sal = 0;
        float comm = 0;
        float deptno = 0;
        int ano = 0;
        int dia = 0;
        int mes = 0;
        boolean funcionou;
        String nomeAlterar = "Null";
        conexao.iniciar();
        while (opcao != 0) {
            while (verificar == false) {
                try {
                    System.out.println("""
                                Menu
                            [1] Inserir
                            [2] Alterar nome
                            [3] Alterar salário
                            [4] Remover
                            [5] Buscar tudo
                            [6] Buscar por número
                            [7] Buscar por trabalho
                            [0] Sair
                                """);
                    opcao = input.nextInt();
                    if (opcao > 7 || opcao < 1) {
                        throw new Exception();
                    }
                    verificar = true;
                } catch (InputMismatchException ime) {
                    System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                    input.nextLine();
                    verificar = false;
                } catch (Exception e) {
                    System.out.println("\u001b[31mOps,algo deu errado,digite uma opção válida:  \u001b[m");
                    input.nextLine();
                    verificar = false;
                }
            }
            switch (opcao) {
                case 1 -> {
                    verificar = false;
                    while (verificar == false) {
                        try {
                            System.out.println("Vamos inserir!");
                            System.out.println("Digite o código do empregado: ");
                            empno = input.nextFloat();
                            if (empno < 0) {
                                throw new Exception();
                            }
                            verificar = true;
                        } catch (InputMismatchException ime) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                            input.nextLine();
                            verificar = false;
                        } catch (Exception e) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite um número positivo:  \u001b[m");
                            input.nextLine();
                            verificar = false;
                        }
                        input.nextLine();
                        System.out.println("Digite o nome do empregado: ");
                        ename = input.nextLine();
                        System.out.println("Digite o nomne do trabalho: ");
                        job = input.nextLine();

                        verificar = false;
                        while (verificar == false) {
                            try {
                                System.out.println("Digite o número do gerente: ");
                                mgr = input.nextFloat();
                                if (mgr < 0) {
                                    throw new Exception();
                                }
                                verificar = true;
                            } catch (InputMismatchException ime) {
                                System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                input.nextLine();
                                verificar = false;
                            } catch (Exception e) {
                                System.out.println("\u001b[31mOps,algo deu errado,digite um número positivo:  \u001b[m");
                                input.nextLine();
                                verificar = false;
                            }
                        }
                        verificar = false;
                        while (verificar == false) {
                            while (verificar == false) {
                                try {
                                    System.out.println("Digite o dia da sua contratação: ");
                                    dia = input.nextInt();
                                    if (dia < 1 || dia > 31) {
                                        throw new Exception();
                                    }
                                    verificar = true;
                                } catch (InputMismatchException ime) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                } catch (Exception e) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite um dia válido:  \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                }
                            }
                            verificar = false;
                            while (verificar == false) {
                                try {
                                    System.out.println("Digite o mês da sua contratação: ");
                                    mes = input.nextInt();
                                    if (mes < 1 || mes > 12) {
                                        throw new Exception();
                                    }
                                    verificar = true;
                                } catch (InputMismatchException ime) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                } catch (Exception e) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite um mês válido:  \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                }
                            }
                            verificar = false;
                            while (verificar == false) {
                                try {
                                    System.out.println("Digite o ano da sua contratação: ");
                                    ano = input.nextInt();
                                    if ( ano > 2025) {
                                        throw new Exception();
                                    }
                                    verificar = true;
                                } catch (InputMismatchException ime) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                } catch (Exception e) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite um ano válido:  \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                }
                            }
                            verificar = false;
                            while (verificar == false) {
                                try {
                                    System.out.println("Digite seu salário: ");
                                    sal = input.nextFloat();
                                    if (sal < 0) {
                                        throw new Exception();
                                    }
                                    verificar = true;
                                } catch (InputMismatchException ime) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                } catch (Exception e) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite um salário válido:  \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                }
                            }
                            verificar = false;
                            while (verificar == false) {
                                try {
                                    System.out.println("Digite o valor da comissão: ");
                                    comm = input.nextFloat();
                                    verificar = true;
                                } catch (InputMismatchException ime) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                }
                            }
                            verificar = false;
                            while (verificar == false) {
                                try {
                                    System.out.println("Digite o número do departamento: ");
                                    deptno = input.nextFloat();
                                    if (deptno < 0) {
                                        throw new Exception();
                                    }
                                    verificar = true;
                                } catch (InputMismatchException ime) {
                                } catch (Exception e) {
                                    System.out.println("\u001b[31mOps,algo deu errado,digite um departamento válido:  \u001b[m");
                                    input.nextLine();
                                    verificar = false;
                                }


                            }
                        }

                    }
                    int funcionou1 = conexao.inserir(empno, ename, job, mgr, new Date(dia,mes,ano), sal, comm, deptno);
                    if (funcionou1==1) {
                        System.out.println("A chave primária já existe1");
                    } else {
                        System.out.println("Não foi possível inserir!");
                    }
                    verificar = false;
                }
                case 2 -> {
                    verificar = false;
                    while (verificar == false) {
                        try {
                            System.out.println("Digite o código do empregado que você deseja alterar: ");
                            empno = input.nextFloat();
                            if (empno < 0) {
                                throw new Exception();
                            }
                            verificar = true;

                        } catch (InputMismatchException ime) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                            input.nextLine();
                            verificar = false;
                        } catch (Exception e) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite um código válido:  \u001b[m");
                            input.nextLine();
                            verificar = false;
                        }
                        input.nextLine();
                        System.out.println("Digite o nome para alterar: ");
                        nomeAlterar = input.nextLine();

                    }
                    funcionou = conexao.alterarNome(nomeAlterar, empno);
                    if (funcionou) {
                        System.out.println("Nome alterado com sucesso!");
                    } else {
                        System.out.println("Não foi possível alterar o nome!");
                    }
                    verificar = false;

                }
                case 3 -> {
                    verificar = false;
                    while (verificar == false) {
                        try {
                            System.out.println("Digite o código do empregado que você deseja alterar: ");
                            empno = input.nextFloat();
                            if (empno < 0) {
                                throw new Exception();
                            }
                            verificar = true;

                        } catch (InputMismatchException ime) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                            input.nextLine();
                            verificar = false;
                        } catch (Exception e) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite um código válido:  \u001b[m");
                            input.nextLine();
                            verificar = false;
                        }
                        verificar = false;
                        while (verificar == false) {
                            try {
                                System.out.println("Digite o salário para alterar: ");
                                sal = input.nextFloat();
                                if (sal < 0) {
                                    throw new Exception();
                                }
                                verificar = true;
                            } catch (InputMismatchException ime) {
                                System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                input.nextLine();
                                verificar = false;
                            } catch (Exception e) {
                                System.out.println("\u001b[31mOps,algo deu errado,digite um salário válido:  \u001b[m");
                                input.nextLine();
                                verificar = false;
                            }
                        }

                    }
                    funcionou = conexao.alterarSal(sal, empno);
                    if (funcionou) {
                        System.out.println("Salário alterado com sucesso!");
                    } else {
                        System.out.println("Não foi possível alterar o salário!");
                    }
                    verificar = false;
                }
                case 4 -> {
                    verificar = false;
                    while (verificar == false) {
                        try {
                            System.out.println("Digite o código do usuário que deve ser removido: ");
                            empno = input.nextFloat();
                            if (empno < 0) {
                                throw new Exception();
                            }
                            verificar = true;
                        } catch (InputMismatchException ime) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                            input.nextLine();
                            verificar = false;
                        } catch (Exception e) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite um código válido:  \u001b[m");
                            input.nextLine();
                            verificar = false;
                        }
                    }
                    funcionou = conexao.remover(empno);
                    if (funcionou) {
                        System.out.println("Removido com sucesso!");
                    } else {
                        System.out.println("Não foi possível remover!");
                    }
                    verificar = false;
                }
                case 5 -> {
                    System.out.println("Vamos buscar tudo!!");
                    List<Empregado> empregados = conexao.buscarTudo();
                    for (Empregado emp : empregados) {
                        System.out.println(emp);
                    }
                    verificar = false;
                }
                case 6 -> {
                    verificar = false;
                    while (verificar == false) {
                        try {
                            System.out.println("Digite o código do usuário que deve ser removido: ");
                            empno = input.nextFloat();
                            if (empno < 0) {
                                throw new Exception();
                            }
                            verificar = true;
                        } catch (InputMismatchException ime) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                            input.nextLine();
                            verificar = false;
                        } catch (Exception e) {
                            System.out.println("\u001b[31mOps,algo deu errado,digite um código válido:  \u001b[m");
                            input.nextLine();
                            verificar = false;
                        }
                    }
                    System.out.println(conexao.buscarPorNum(empno));
                    verificar=false;
                } case 7->{
                    input.nextLine();
                    System.out.println("Digite o trabalho para busca: ");
                    job=input.nextLine();
                    List<Empregado> empregados1 = conexao.buscarPorTrabalho(job);
                    for (Empregado emp : empregados1) {
                        System.out.println(emp);
                    }
                    verificar=false;
                }case 0 ->{
                    verificar=true;
                    System.out.println("Finalizando o programa, adeus!!!");
                }
            }



        }
        conexao.encerrar();
    }
}
