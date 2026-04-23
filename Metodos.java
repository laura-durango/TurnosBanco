import java.util.Queue;
import java.util.Scanner;

public class Metodos {

    Scanner sc = new Scanner(System.in);

    private int contador = 1;

  
    public int validarEntero(Scanner sc) {
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(sc.nextLine());
                return numero;
            } catch (Exception e) {
                System.out.println("Error, ingrese un número válido:");
            }
            return sc.nextInt();
        }
    }

    
    public int validarRango(int min, int max, int valor, Scanner sc) {
        while (valor < min || valor > max) {
            System.out.println("Ingrese un valor entre " + min + " y " + max);
            valor = validarEntero(sc);
        }
        return valor;
    }

    
    public String validarTexto(Scanner sc) {
        String texto = sc.next();
        while (texto.trim().isEmpty()) {
            System.out.println("No puede estar vacío. Ingrese nuevamente:");
            texto = sc.next();
        }
        return texto;
    }

    public Queue<ObjTurnosBanco> encolarCliente(Queue<ObjTurnosBanco> cola, Scanner sc) {

        System.out.print("Nombre: ");
        String nombre = validarTexto(sc);

        System.out.print("Tipo de servicio: ");
        String servicio = validarTexto(sc);

        System.out.print("Hora llegada: ");
        String hora = validarTexto(sc);

        ObjTurnosBanco cliente = new ObjTurnosBanco(contador++, nombre, servicio, hora, false);

        cola.add(cliente);
        System.out.println("Cliente agregado correctamente.");

        return cola;
    }

    
    public void atenderCliente(Queue<ObjTurnosBanco> cola) {

        if (cola.isEmpty()) {
            System.out.println("No hay clientes en espera.");
        } else {
            ObjTurnosBanco cliente = cola.poll();
            cliente.setAtendido(true);
            System.out.println("Atendiendo cliente:");
            System.out.println(cliente);
        }
    }

   
    public void verSiguiente(Queue<ObjTurnosBanco> cola) {

        if (cola.isEmpty()) {
            System.out.println("No hay clientes en espera.");
        } else {
            System.out.println("Siguiente cliente:");
            System.out.println(cola.peek());
        }
    }

    
    public void mostrarCola(Queue<ObjTurnosBanco> cola) {

        if (cola.isEmpty()) {
            System.out.println("Cola vacía.");
        } else {
            System.out.println("Clientes en espera:");
            for (ObjTurnosBanco c : cola) {
                System.out.println(c);
            }
        }
    }
}



    
