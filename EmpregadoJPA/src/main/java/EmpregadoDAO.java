import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.Date;
import java.util.List;

public class EmpregadoDAO {

    private static EntityManagerFactory emf;

    public void iniciar(){
        emf=Persistence.createEntityManagerFactory("default");
    }
    public void encerrar(){emf.close(); }

public boolean inserir(float empno, String ename, String job, float mgr, Date hiredate, float sal, float comm, float deptno){
    EntityManager em = emf.createEntityManager();
    try {
        Empregado emp = new Empregado();
        emp.setEmpno(empno);
        emp.setEname(ename);
        emp.setJob(job);
        emp.setMgr(mgr);
        emp.setHiredate(hiredate);
        emp.setSal(sal);
        emp.setComm(comm);
        emp.setDeptno(deptno);
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        return true;
    }catch (Exception e){
        e.printStackTrace();
        return false;
    }finally {
        em.close();
    }
}

 public boolean alterarNome(String nome, float empno){
     EntityManager em = emf.createEntityManager();

      try {
          em.getTransaction().begin();
          Empregado emp = em.find(Empregado.class,empno);
          emp.setEname(nome);
          em.getTransaction().commit();
          return true;
      }catch (Exception e){
          e.printStackTrace();
          return false;
      }finally {
          em.close();
      }

 }
    public boolean alterarSal(float sal, float empno){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Empregado emp = em.find(Empregado.class,empno);
            emp.setSal(sal);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            em.close();
        }

    }

    public boolean remover(float empno){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Empregado emp = em.find(Empregado.class,empno);
            em.remove(emp);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            em.close();
        }

    }

    public List<Empregado> buscarTudo(){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("Select emp from Empregado emp");
            List<Empregado>  empregados =query.getResultList();
            System.out.println(empregados);
            return empregados;
        }catch (Exception e){
            return null;
        }finally {
            em.close();
        }


    }

}
