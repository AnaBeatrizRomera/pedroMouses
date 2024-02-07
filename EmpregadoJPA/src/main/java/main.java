import jakarta.persistence.Query;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[]args){
      EmpregadoDAO conexao = new EmpregadoDAO();
        Scanner input = new Scanner(System.in);

      conexao.iniciar();
      int opcao = 1;
      boolean verificar = false;
      float mgr;
      float empno;
      String ename;
      String job;
      Date hiredate;
      float sal;
      float comm;
      float deptno;

      while (opcao!=0){
          while(verificar==false){
              try{
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
                  if (opcao>7||opcao<1){
                      throw new Exception();
                  }
                  verificar=true;
              }catch (InputMismatchException ime){
                  System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                  input.nextLine();
                  verificar = false;
              }catch (Exception e){
                  System.out.println("\u001b[31mOps,algo deu errado,digite uma opção válida:  \u001b[m");
                  input.nextLine();
                  verificar = false;
              }
          }
          switch (opcao){
              case 1 ->{
                  verificar=false;
                  while (verificar==false){
                      try{
                          System.out.println("Vamos inserir!");
                          System.out.println("Digite o código do empregado: ");
                          empno = input.nextFloat();
                          if (empno<0){
                              throw new Exception();
                          }
                          verificar=true;
                      }catch (InputMismatchException ime){
                          System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                          input.nextLine();
                          verificar = false;
                      }catch (Exception e){
                          System.out.println("\u001b[31mOps,algo deu errado,digite um número positivo:  \u001b[m");
                          input.nextLine();
                          verificar = false;
                      }
                      input.nextLine();
                      System.out.println("Digite o nome do empregado: ");
                      ename = input.nextLine();
                      System.out.println("Digite o nomne do trabalho: ");
                      job = input.nextLine();

                      verificar=false;
                      while (verificar=false){
                          try {
                              System.out.println("Digite o número do gerente: ");
                              mgr = input.nextFloat();
                              if (mgr<0){
                                  throw new Exception();
                              }
                              verificar=true;
                          }catch (InputMismatchException ime){
                              System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                              input.nextLine();
                              verificar = false;
                          }catch (Exception e){
                              System.out.println("\u001b[31mOps,algo deu errado,digite um número positivo:  \u001b[m");
                              input.nextLine();
                              verificar = false;
                          }
                      }
                      verificar=false;
                      while (verificar=false){
                          while (verificar=false){
                            try {
                                System.out.println("Digite o dia da sua contratação: ");
                                int dia = input.nextInt();
                                if (dia<1||dia>31){
                                    throw new Exception();
                                }
                                verificar=true;
                            }catch (InputMismatchException ime){
                                System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                input.nextLine();
                                verificar = false;
                            }catch (Exception e){
                                System.out.println("\u001b[31mOps,algo deu errado,digite um dia válido:  \u001b[m");
                                input.nextLine();
                                verificar = false;
                            }
                          }
                          verificar=false;
                          while (verificar=false){
                              try {
                                  System.out.println("Digite o mês da sua contratação: ");
                                  int mes = input.nextInt();
                                  if (mes1||mes>12){
                                      throw new Exception();
                                  }
                                  verificar=true;
                              }catch (InputMismatchException ime){
                                  System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                  input.nextLine();
                                  verificar = false;
                              }catch (Exception e){
                                  System.out.println("\u001b[31mOps,algo deu errado,digite um mês válido:  \u001b[m");
                                  input.nextLine();
                                  verificar = false;
                              }
                          }
                          verificar=false;
                          while (verificar=false){
                              try {
                                  System.out.println("Digite o ano da sua contratação: ");
                                  int ano = input.nextInt();
                                  if (ano<1950||ano>2024){
                                      throw new Exception();
                                  }
                                  verificar=true;
                              }catch (InputMismatchException ime){
                                  System.out.println("\u001b[31mOps,algo deu errado,digite apenas números: \u001b[m");
                                  input.nextLine();
                                  verificar = false;
                              }catch (Exception e){
                                  System.out.println("\u001b[31mOps,algo deu errado,digite um ano válido:  \u001b[m");
                                  input.nextLine();
                                  verificar = false;
                              }
                          }



                      }


                  }



              }
          }
      }



        conexao.encerrar();
    }





}
