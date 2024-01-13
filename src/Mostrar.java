import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Mostrar {
    Scanner entrada = new Scanner(System.in);
    String dbURL="jdbc:mysql://localhost:3306/estudiante";
    String dbuserName="root";
    String dbpassword="1726405390";
    public void mostrarDatos(){

        try{
            //la descarga de mysqlconnector(watsap)
            //el "com" pertenece a external librarys
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection casita= DriverManager.getConnection(dbURL, dbuserName, dbpassword);
            //casita es diferente a que no encontro nada
            if(casita != null){
                System.out.println("Conectado exitosamente a la base de datos");
            }

            //crear una conexion a la base de datos
            Statement statement;
            statement=casita.createStatement();

            //es para ejecutar el codigo de select sql
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM grades");

            //variables cualquier para igualar a la tabla que ya tengo
            int id;
            String nombre;
            int cedula;
            float nota1, nota2;

            while(resultSet.next()){
                id=resultSet.getInt("id");
                nombre=resultSet.getString("nombre");
                cedula=resultSet.getInt("cedula");
                nota1=resultSet.getFloat("nota1");
                nota2=resultSet.getFloat("nota2");

                System.out.println(id + " " + nombre+ " "+cedula + " " + nota1 +" " + " "+ nota2);
            }

        }catch(Exception ex){
            System.out.println("Ten cuidado, algo esta mal");
        }
    }
}
