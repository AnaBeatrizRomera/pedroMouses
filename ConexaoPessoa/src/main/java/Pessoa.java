import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
    @Id
    @Column(name = "pessoaid")
    private int codigo;
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String genero;
    private String estado;
    private int musica;
    private int cinema;
    private int leitura;
    private int esportes;


    public Pessoa(){};
    public Pessoa(int codigo,String nome,int idade, double altura, double peso,String genero, String estado, int musica, int cinema, int leitura, int esporte){
        this.codigo=codigo;
        this.nome=nome;
        this.idade=idade;
        this.altura=altura;
        this.peso=peso;
        this.genero=genero;
        this.estado=estado;
        this.musica=musica;
        this.cinema=cinema;
        this.leitura=leitura;
        this.esportes=esporte;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getGenero(){
        return genero;
    }

    public String getEstado() {
        return estado;
    }

    public int getMusica() {
        return musica;
    }

    public int getCinema() {
        return cinema;
    }

    public int getLeitura() {
        return leitura;
    }

    public int getEsportes(){
        return esportes;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMusica(int musica) {
        this.musica = musica;
    }

    public void setCinema(int cinema) {
        this.cinema = cinema;
    }

    public void setLeitura(int leitura) {
        this.leitura = leitura;
    }

    public void setEsportes(int esportes) {
        this.esportes = esportes;
    }

    @Override
    public String toString() {
        return "\nCódigo pessoa: "+codigo+"\nNome: "+nome+"\nIdade: "+idade+"\nAltura: "+altura+"\nPeso: "+peso+"\nGênero: "+genero+"\nEstado: "+estado+"\nMúsica: "+musica+"\nCinema: "+cinema+"\nLeitura: "+leitura+"\nEsportes: "+esportes;
    }
}
