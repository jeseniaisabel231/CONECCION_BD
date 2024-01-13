import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Eliminar {
    String dbURL="jdbc:mysql://localhost:3306/estudiante";
    String dbuserName="root";
    String dbpassword="1726405390";
    public void eliminarDatos(){
        float nota1, nota2;
        int id, cedula;
        String nombre;

        Scanner entrada = new Scanner(System.in);
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            //conectar a la base de datos
            Connection casita= DriverManager.getConnection(dbURL, dbuserName, dbpassword);


            System.out.print("Ingrese el id que desea eliminar: ");
            id = entrada.nextInt();
            entrada.nextLine();

            String sql = "DELETE FROM grades WHERE id= "+id;

            //stataement es la variable que se encarga de setear los valores a la base de datos
            PreparedStatement statement = casita.prepareStatement(sql);

            int rowsInserted = statement.executeUpdate();
            //mensaje de advertencia
            if(rowsInserted > 0){
                System.out.println("datos insertados correctamente");
            }
        }catch (Exception e) {
            System.out.println("Ten cuidado, algo esta mal");
        }
    }
}
