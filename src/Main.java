import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String dbURL="jdbc:mysql://localhost:3306/estudiante";
        String dbuserName="root";
        String dbpassword="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection casita= DriverManager.getConnection(dbURL, dbuserName, dbpassword);
            if(casita != null){
                System.out.println("Conectado exitosamente a la base de datos");
            }

            Statement statement;
            statement=casita.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM grades");
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
    }
}