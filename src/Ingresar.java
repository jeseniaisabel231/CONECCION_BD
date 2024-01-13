import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ingresar {

    String dbURL="jdbc:mysql://localhost:3306/estudiante";
    String dbuserName="root";
    String dbpassword="1726405390";
    public void ingresarDatos(){
        float nota1, nota2;
        int id, cedula;
        String nombre;

        Scanner entrada = new Scanner(System.in);
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            //conectar a la base de datos
            Connection casita= DriverManager.getConnection(dbURL, dbuserName, dbpassword);
            String sql = "INSERT INTO grades" + "(id, nombre, cedula, nota1, nota2)" + "VALUES (?, ?, ?, ?, ?)";

            System.out.print("Ingrese su id: ");
            id = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Ingrese su nombre: ");
            nombre= entrada.nextLine();

            System.out.print("Ingrese su cedula: ");
            cedula= entrada.nextInt();

            System.out.print("Ingrese su nota 1: ");
            nota1= entrada.nextFloat();

            System.out.print("Ingrese su nota 2: ");
            nota2= entrada.nextFloat();

            //stataement es la variable que se encarga de setear los valores a la base de datos
            PreparedStatement statement = casita.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setString(2, nombre);
            statement.setInt(3, cedula);
            statement.setFloat(4,nota1);
            statement.setFloat(5, nota2);
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
