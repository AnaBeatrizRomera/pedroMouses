import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class Principal {
    private static final EntityManagerFactory emf=
            Persistence.createEntityManagerFactory("default");

    public static void main(String[]args){
        EntityManager em = emf.createEntityManager();

        //Inserir, alterar, remover e selecinar aqui

        //Mostrar um registro
//        em.getTransaction().begin();
//        Departamento dept1=em.find(Departamento.class,40);
//        System.out.println(dept1);
//        em.getTransaction().commit();

//        //Inserir
            Departamento dept1 = new Departamento();
            dept1.setNumDept(75);
            dept1.setdName("Marketing");
            dept1.setLoc("Osasco");
            em.getTransaction().begin();
            em.persist(dept1);
            em.getTransaction().commit();





//        //Alterar
//        em.getTransaction().begin();
//        Departamento dept2 = em.find(Departamento.class,75);
//        dept2.setdName("Administrativo");
//        em.getTransaction().commit();

//        //Excluir
//        em.getTransaction().begin();
//        Departamento dept2 = em.find(Departamento.class,75);
//        em.remove(dept2);
//        em.getTransaction().commit();

        //Mostrar todos os registros
//        Query query = em.createQuery("Select dept3 from Departamento dept3 order by dept3.numDept");
//        List<Departamento> departamentos= query.getResultList();
//        for (Departamento depart:departamentos){
//            System.out.println(depart);
//        }

//        Mostrar mais de um registro de busca
        String cidade="NEW YORK";
        Query query1 = em.createQuery("Select dept4 from Departamento dept4 where dept4.loc = :local order by dept4.numDept");
        query1.setParameter("local",cidade);
        List<Departamento> departamentos1 = query1.getResultList();
        for (Departamento depart : departamentos1){
            System.out.println(depart);
        }



        em.close();
        emf.close();
    }
}
