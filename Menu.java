import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Menu {
    public static void main(String[] args) {

        Metodos m = new Metodos();

        Queue<ObjTurnosBanco> cola = new LinkedList<>();
        Queue<ObjTurnosBanco> atendidos = new LinkedList<>();

        boolean seguir = true;
        int opt;
        int turno = 1;

        while (seguir) {

            System.out.println("\n--- BANCO LD ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver siguiente cliente");
            System.out.println("4. Mostrar cola");
            System.out.println("5. Mostrar turnos");
            System.out.println("6. Salir");

            opt = m.validarEntero();

            switch (opt) {

                case 1:
                    cola = m.LLenarColaCliente(cola); 
                    break;

                case 2:
                    m.AtenderCliente(cola);
                    break;

                case 3:
                    m.VerSiguiente(cola);
                    break;

                case 4:
                    m.MostrarColaTurnosBanco(cola);
                    break;

                case 5:
                    m.MostrarColaTurnosBanco(atendidos);
                    break;

                case 6:
                    System.out.println("Gracias por usar el sistema");
                    seguir = false;
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}