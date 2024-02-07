import java.sql.*;

public class Conexao {

//    Atributos

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;


//    Conectar
    public boolean conectar(){
        try{
            //Informando qual driver de conexão será utilizado pelo DriveManager
            Class.forName("org.postgresql.Driver");
            //Criando conexão com o BD
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://kesavan.db.elephantsql.com:5432/vlcwpmye","vlcwpmye","XiIDiMIHAOn3IPRjm5n31ERZnB7oteCw"
            );
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            return false;
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
        return true;

    }

//    Desconectar
    public void desconectar(){
        try{

            if(conn!=null &&conn.isClosed()){
//                Desconectando do DB
                conn.close();;
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }


// Inserir
    public boolean inserir(int custid, String name, String address, String city, String state, String zip,int area, String phone, int repid, double creditlimit, String comments){

        try{
            conectar(); //Conectando ao banco
            pstm = conn.prepareStatement("INSERT INTO CUSTOMER(CUSTID,NAME,ADDRESS,CITY,STATE,ZIP,AREA,PHONE,REPID,CREDITLIMIT,COMMENTS) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
    // Setando valor de parametro
            pstm.setInt(1,custid);
            pstm.setString(2,name);
            pstm.setString(3, address);
            pstm.setString(4,city);
            pstm.setString(5,state);
            pstm.setString(6,zip);
            pstm.setInt(7,area);
            pstm.setString(8,phone);
            pstm.setInt(9,repid);
            pstm.setDouble(10,creditlimit);
            pstm.setString(11,comments);
            return pstm.execute();//Executando ocomando sql preparedstatement

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            desconectar();
        }
    }



// Alterar
    public boolean alterarNome(int custid, String name){
        try {

            conectar();//conectando ao banco
            pstm=conn.prepareStatement("UPDATE CUSTOMER SET NAME = ? WHERE CUSTID = ?");
            //setando paramêtros
            pstm.setString(1,name);
            pstm.setDouble(2,custid);
            return pstm.execute();//executando o comando sql do prepareStatment
            }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            desconectar();
        }
    }


//Delete
    public boolean remover(int custid){
        try {

            conectar();//conectando ao banco

            pstm=conn.prepareStatement("DELETE FROM CUSTOMER WHERE CUSTID = ?");

            //setando paramêtro
            pstm.setInt(1,custid);

            return pstm.execute();//Executando o comando sql do prepareStatement

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            desconectar();
        }
    }




//    Buscar
    public ResultSet buscar(){
        try {
            conectar();//conectando ao banco
// Instanciando objeto prepareStatment(pstm)
            pstm=conn.prepareStatement("SELECT  * FROM CUSTOMER ");

            rs = pstm.executeQuery();

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }finally {
            desconectar();
        }

        return rs;
    }



}
