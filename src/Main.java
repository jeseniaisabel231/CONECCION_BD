import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String dbURL="jdbc:mysql://localhost:3306/estudiante";
        String dbuserName="root";
        String dbpassword="";
        try{
            //la descarga de mysqlconnector(watsap)
            //el "com" pertenece a external librarys
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection casita= DriverManager.getConnection(dbURL, dbuserName, dbpassword);
            //casita es diferente a que no encontro nada
            if(casita != null){
                System.out.println("Conectado exitosamente a la base de datos");
            }

            //crear unac conexion a la base de datos
            Statement statement;
            statement=casita.createStatement();

            //es para ejecutar el codigo de select sql
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM grades");

            //variables cualquier para igualar a la tabla que ya tengo
            int id;
            String nombre;
            while(resultSet.next()){
                id=resultSet.getInt("id");
                nombre=resultSet.getString("nombre");
                System.out.println(id + " " + nombre);
            }

        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            //System.out.println("Ingrese su indice: ");


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection casita= DriverManager.getConnection(dbURL, dbuserName, dbpassword);
            String sql = "INSERT INTO grades" + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = casita.prepareStatement(sql);
            statement.setInt(1,400);
            statement.setString(2, "Adrian");
            statement.setInt(3, 34);
            statement.setString(4,"Carlos");
            statement.setString(5, "Jose");
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("datos insertados correctamente");
            }
        } catch (Exception e) {}
    }
}