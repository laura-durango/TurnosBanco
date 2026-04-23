import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Metodos {

    Scanner sc = new Scanner(System.in);

    // ===== VALIDACIONES =====

    public int validarEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("Digite un número válido:");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public String validarTexto() {
        sc.nextLine();
        String texto;
        while (true) {
            texto = sc.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.println("No puede estar vacío:");
        }
    }

    public String validarServicio() {
        String s;
        while (true) {
            s = sc.nextLine().toLowerCase();
            if (s.equals("retiro") || s.equals("consignacion") || s.equals("asesoria")) {
                return s;
            }
            System.out.println("Servicio inválido (retiro, consignacion, asesoria):");
        }
    }

    public String validarHora() {
        String h;
        while (true) {
            h = sc.nextLine();
            if (h.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) return h;
            System.out.println("Formato inválido (HH:mm):");
        }
    }


    public Queue<ObjTurnosBanco> LLenarColaCliente(Queue<ObjTurnosBanco> c) {

        boolean preguntar = true;

        while (preguntar) {

            ObjTurnosBanco o = new ObjTurnosBanco();

            System.out.println("Digite ID:");
            int id = validarEntero();

            System.out.println("Digite nombre:");
            String nombre = validarTexto();

            System.out.println("Digite tipo de servicio:");
            String servicio = validarServicio();

            System.out.println("Digite hora de llegada:");
            String hora = validarHora();

            o.setId(id);
            o.setNombre(nombre);
            o.setTipoServicio(servicio);
            o.setHoraLlegada(hora);
            o.setAtendido(false);

            c.offer(o);

            System.out.println("¿Desea continuar? 1) Sí 2) No");
            int opt = validarEntero();

            if (opt == 2) {
                preguntar = false;
            }
        }

        return c;
    }

   

    public void MostrarColaTurnosBanco(Queue<ObjTurnosBanco> c) {
        for (ObjTurnosBanco o : c) {
            mostrarCliente(o);
        }
    }

    

    public void AtenderCliente(Queue<ObjTurnosBanco> c) {

        if (!c.isEmpty()) {

            ObjTurnosBanco o = c.poll();
            o.setAtendido(true);

            System.out.println("Atendiendo a:");
            mostrarCliente(o);

        } else {
            System.out.println("No hay clientes en la cola");
        }
    }

    

    public void VerSiguiente(Queue<ObjTurnosBanco> c) {

        if (!c.isEmpty()) {
            System.out.println("Siguiente cliente:");
            mostrarCliente(c.peek());
        } else {
            System.out.println("No hay clientes");
        }
    }

    

    public void mostrarCliente(ObjTurnosBanco o) {
        System.out.println("ID: " + o.getId()
                + " | Nombre: " + o.getNombre()
                + " | Servicio: " + o.getTipoServicio()
                + " | Hora: " + o.getHoraLlegada()
                + " | Atendido: " + o.isAtendido());
    }
}