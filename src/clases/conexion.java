package clases;
import java.sql.*;
public class conexion {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs; 
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diseñasalud","root","");
            System.out.println("Conectado DB");
        } catch (Exception e) {
            System.out.println("Error al conectar DB");
        }
    }
    
    public int Rusuario(int ID_persona, int identificacion, String nombres, String apellidos, String Estado_Civil, String Direccion_Residencia, Date Fec_Nac,String Sexo, String Telefono, String correo){
        int res =0;
        try {
            ps=cn.prepareStatement("insert into 01personas(ID_persona, identificacion, nombres, apellidos, Estado_Civil, Direccion_Residencia, Fec_Nac, Sexo, Telefono, correo)values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, ID_persona);
            ps.setInt(2, identificacion);
            ps.setString(3, nombres);
            ps.setString(4, apellidos);
            ps.setString(5, Estado_Civil);
            ps.setString(6, Direccion_Residencia);
            ps.setDate(7, Fec_Nac);
            ps.setString(8, Sexo);
            ps.setString(9, Telefono);
            ps.setString(10, correo);
            res = ps.executeUpdate(); // Ejecuta la consulta y devuelve el número de filas afectadas
            System.out.println("Persona registrada correctamente");
        } catch (Exception e) {
            System.out.println("Error al insertar datos en la base de datos");
        }
        return res;
    }
}
