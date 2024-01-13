import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        int opcion;
        Scanner entrada = new Scanner(System.in);

        String dbURL="jdbc:mysql://localhost:3306/estudiante";
        String dbuserName="root";
        String dbpassword="1726405390";

        opcion=0;
        while(opcion!=5){
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Ingresar datos");
            System.out.println("2. Editar datos");
            System.out.println("3. Mostrar datos");
            System.out.println("4. Eliminar datos");
            System.out.println("5. Salir");
            System.out.print("Ingresa la opcion que deseas: ");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    Ingresar login = new Ingresar();
                    login.ingresarDatos();
                    break;
                case 2:
                    Editor edit = new Editor();
                    edit.editarDatos();
                    break;
                case 3:
                    Mostrar show = new Mostrar();
                    show.mostrarDatos();
                    break;
                case 4:
                    Eliminar delete = new Eliminar();
                    delete.eliminarDatos();
                    break;
                case 5:
                    System.out.println("Gracias por utilizar nuestro sistema");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }
}