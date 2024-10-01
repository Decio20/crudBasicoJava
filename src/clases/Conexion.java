package clases;
import java.sql.*;

public class Conexion {
    
    Connection        cn;
    PreparedStatement ps;
    ResultSet         rs;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_2", "root", "");
            System.out.println("Conectado a la base de Datos");
            
        } catch(Exception e){
            System.out.println("Error al conectar a la base de datos");
        }
    }
    
    public int ReUsuario(String nombre, String usuario, String clave, String correo){
        int respuesta = 0;
        try{
            ps = cn.prepareStatement("INSERT INTO usuario(nombres, usuario, clave, correo) VALUES(?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, clave);
            ps.setString(4, correo);
            respuesta = ps.executeUpdate();
            System.out.println("Usuario registrado correctamente");
            
        }catch(Exception e){
            System.out.println("Error al registrar");
        }
        
        return respuesta;
    }
    
    public int AcUsuario(String nombre, String usuario, String clave, String correo, String id){
        int respuesta = 0;
        try {
            ps = cn.prepareStatement("UPDATE usuario SET nombres=?, usuario=?, clave=?, correo=? WHERE id=? ");
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, clave);
            ps.setString(4, correo);
            ps.setString(5, id);
            
            respuesta = ps.executeUpdate();
            System.out.println("Datos modificados correctamente");
            
        } catch (Exception e) {
            System.out.println("Error al modificar datos");
        }
        
        return respuesta;
    }
}
