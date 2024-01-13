import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Editor {
    String dbURL="jdbc:mysql://localhost:3306/estudiante";
    String dbuserName="root";
    String dbpassword="1726405390";
    public void editarDatos(){
        float nota1, nota2;
        int id, cedula;
        String nombre;

        Scanner entrada = new Scanner(System.in);
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            //conectar a la base de datos
            Connection casita= DriverManager.getConnection(dbURL, dbuserName, dbpassword);


            System.out.print("Ingrese el id que va a editar: ");
            id = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Ingrese el nuevo nombre: ");
            nombre= entrada.nextLine();

            System.out.print("Ingrese la nueva cedula: ");
            cedula= entrada.nextInt();

            System.out.print("Ingrese su nueva nota 1: ");
            nota1= entrada.nextFloat();

            System.out.print("Ingrese su nueva nota 2: ");
            nota2= entrada.nextFloat();

            //actualizar datos
            String sql = "Update grades set  nombre= ? , cedula= ?, nota1=?, nota2=? where id="+id;

            //stataement es la variable que se encarga de setear los valores a la base de datos
            PreparedStatement statement = casita.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setInt(2, cedula);
            statement.setFloat(3,nota1);
            statement.setFloat(4, nota2);
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
