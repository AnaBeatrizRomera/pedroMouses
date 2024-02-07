import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="emp")
public class Empregado {
@Id
private float empno;
private String ename;
private String job;
private Float mgr;
private Date hiredate;
private float sal;
private Float comm;
private float deptno;

    public float getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public float getMgr() {
        return mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public float getSal() {
        return sal;
    }

    public float getComm() {
        return comm;
    }

    public float getDeptno() {
        return deptno;
    }

    public void setEmpno(float empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setMgr(float mgr) {
        this.mgr = mgr;
    }

    public void setHiredate(Date hiredadate) {
        this.hiredate = hiredate;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public void setComm(float comm) {
        this.comm = comm;
    }

    public void setDeptno(float deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "\nNome: "+ename+"\nCargo: "+job+"\nGerente: "+mgr+"\nData de contratação: "+hiredate+"\nSalário: "+sal+"\nComissão: "+comm+"\nNúmero do departamento: "+deptno;
    }
}
