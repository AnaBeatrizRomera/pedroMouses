import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="dept")
public class Departamento {

    @Id
    @Column(name="deptNo")
    private float numDept;

    private String dName;

    private String loc;

    public float getNumDept() {
        return numDept;
    }

    public String getdName() {
        return dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void setNumDept(float numDept) {
        this.numDept = numDept;
    }

    @Override
    public String toString() {
        return "Número do departamento: "+numDept+"\nNome: "+dName+"\nLocalização: "+loc;
    }
}
