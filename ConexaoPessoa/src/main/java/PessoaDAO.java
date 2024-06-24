import jakarta.persistence.*;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class PessoaDAO {
        static EntityManagerFactory emf=null;
        static EntityManager em;
    public void iniciar(){
        emf= Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }



public void encerrar(){
    em.close();
    emf.close();
}


public int inserir(Pessoa pessoa){
try {
    em.getTransaction().begin();
    em.persist(pessoa);
    em.getTransaction().commit();
    return 0;
} catch (PersistenceException pe){
    if (pe.getCause().getCause() instanceof ConstraintViolationException) {
        pe.printStackTrace();
        System.out.println(pe.getLocalizedMessage());
        return 1;
    }
    return -1;
}
}

public int alterar(String alteracao, String campoAlteracao, String campoBase, String valorBase){
    Pessoa pessoa;
    try {
        em.getTransaction().begin();
        if (campoBase.equals("codigo")){
            int codigo = Integer.parseInt(valorBase);
            pessoa = em.find(Pessoa.class,codigo);
        } else if (campoBase.equals("nome")) {
            String nome=valorBase;
            pessoa = em.find(Pessoa.class,nome);
        } else if (campoBase.equals("idade")) {
            int idade= Integer.parseInt(valorBase);
            pessoa = em.find(Pessoa.class,idade);
        }else if (campoBase.equals("altura")) {
            double altura= Double.parseDouble(valorBase);
            pessoa = em.find(Pessoa.class,altura);
        }else if (campoBase.equals("peso")) {
            double peso = Double.parseDouble(valorBase);
            pessoa = em.find(Pessoa.class, peso);
        }else if (campoBase.equals("genero")) {
            pessoa = em.find(Pessoa.class,valorBase);
        }else if (campoBase.equals("estado")) {
            pessoa = em.find(Pessoa.class,valorBase);
        } else if (campoBase.equals("musica")) {
            int musica= Integer.parseInt(valorBase);
            pessoa = em.find(Pessoa.class,musica);
        } else if (campoBase.equals("cinema")) {
            int cinema= Integer.parseInt(valorBase);
            pessoa = em.find(Pessoa.class,cinema);
        } else if (campoBase.equals("leitura")) {
            int leitura= Integer.parseInt(valorBase);
            pessoa = em.find(Pessoa.class,leitura);
        } else if (campoBase.equals("esportes")) {
            int esportes= Integer.parseInt(valorBase);
            pessoa = em.find(Pessoa.class,esportes);
        }else {
            return 2;
        }
        if (campoAlteracao.equals("nome")){
            pessoa.setNome(alteracao);
        }else if (campoAlteracao.equals("idade")) {
            int idade=Integer.parseInt(alteracao);
            pessoa.setIdade(idade);
        }else if (campoAlteracao.equals("altura")){
            double altura = Double.parseDouble(alteracao);
            pessoa.setAltura(altura);
        }else if (campoAlteracao.equals("peso")){
            double peso = Double.parseDouble(alteracao);
            pessoa.setPeso(peso);
        }else if (campoAlteracao.equals("genero")){
            pessoa.setGenero(alteracao);
        }else if (campoAlteracao.equals("estado")){
            pessoa.setEstado(alteracao);
        }else if (campoAlteracao.equals("musica")) {
            int musica=Integer.parseInt(alteracao);
            pessoa.setMusica(musica);
        }else if (campoAlteracao.equals("cinema")) {
            int cinema=Integer.parseInt(alteracao);
            pessoa.setCinema(cinema);
        }else if (campoAlteracao.equals("leitura")) {
            int leitura=Integer.parseInt(alteracao);
            pessoa.setLeitura(leitura);
        }else if (campoAlteracao.equals("esportes")) {
            int esporte=Integer.parseInt(alteracao);
            pessoa.setEsportes(esporte);
        }else {
            return 2;
        }
        em.getTransaction().commit();
        return 0;
    }catch (NullPointerException npe){
        npe.printStackTrace();
        return 1;
    } catch (PersistenceException pe){
        pe.printStackTrace();
        return -1;
    }
}

public int remover(String campoRemover,String valorBase){

    List<Pessoa>  pessoas=null;
    int cont = 0;
    try {
        pessoas =buscarTudo(campoRemover,valorBase);
        if (pessoas == null) {
            return 1;
        }

        for (Pessoa pes:pessoas) {
            em.getTransaction().begin();
            em.remove(pes);
            em.getTransaction().commit();
            cont++;
        }
        return 0;
    }catch (Exception e){
        e.printStackTrace();
        return cont == pessoas.size() ? 1 : -2;
    }
}

public List<Pessoa> buscarTudo(String campo,String valor){
    try{
        Query query=null;
        if (campo.equals("nome")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.nome=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("idade")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.idade=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("altura")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.altura=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("peso")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.peso=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("genero")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.genero=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("estado")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.estado=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("cinema")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.cinema=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("musica")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.musica=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("leitura")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.leitura=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("esportes")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.esportes=:valor");
            query.setParameter("valor", valor);
        }else if (campo.equals("codigo")){
            query = em.createQuery("Select pessoa from Pessoa pessoa where pessoa.codigo=:valor");
            query.setParameter("valor", valor);
        }
        List<Pessoa>  pessoas =query.getResultList();
        return pessoas;
    }catch (NullPointerException npe){
        npe.printStackTrace();
        return null;
    }catch (Exception e){
        return null;
    }
}
}
