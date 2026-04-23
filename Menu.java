import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();

        Queue<ObjTurnosBanco> cola = new LinkedList<>();
        boolean seguir = true;
        int opt = 0, numero = 0;
        while (seguir) {
            System.out.println("Bienvenid al sistema de Turnos");
            System.out.println("\n--- BANCO LD ---");
            System.out.println("\n Que deseas hacer");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver siguiente cliente");
            System.out.println("4. Mostrar cola");
            System.out.println("5. Salir");
            opt = m.validarEntero(sc);
            opt = m.validarRango(1, 5, opt, sc);
            switch (opt) {
                case 1:
                    cola = m.encolarCliente(cola, sc);
                    break;

                case 2:
                    m.atenderCliente(cola);
                    break;

                case 3:
                    m.verSiguiente(cola);
                    break;

                case 4:
                    m.mostrarCola(cola);
                    break;

                case 5:
                    System.out.println("Gracias por usar el sistema");
                    seguir = false;
                    break;
            }

        }
    }
}