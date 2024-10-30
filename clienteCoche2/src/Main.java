import java.util.Random;
import java.util.Scanner;

public class Main {
    // Funciones
    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);

    // Constantes
    public static final int COCHES_POR_CLIENTE = 3;
    public static final int MAX_COCHE = 9;
    public static final int MAX_CLIENTE = 3;
    public static final String[] COLOR = {"Azul", "Rojo", "Verde", "Negro"};
    public static final String[] MARCA = {"Mazda", "Toyota", "Opel", "Renault"};

    // Variables
    public static int contadorCoches = 0;
    public static int totalCoches = 0;

    public static void main(String[] args) {
        Coche[] coches = creaCoche(); // array donde almaceno todos los coches
        Cliente[] clientes = creaCliente(coches); // almaceno clientes con 3 matriculas cada uno
        muestraCliente(clientes);
    }

    private static void muestraCliente(Cliente[] clientes) {
        int idCliente;

        do {
            System.out.println("Que cliente quieres mostrar (0 a " + (MAX_CLIENTE-1) + ")");
            idCliente = sc.nextInt();
            sc.nextLine();

            // controlo opciones
            if (idCliente == -1){
                System.out.println("Adios...");
                break;
            } else if (idCliente < -1 || idCliente >= MAX_CLIENTE){
                System.out.println("Escribe un valor válido");
            }else {
                System.out.println(clientes[idCliente]);
            }

        } while (true);
    }

    private static Cliente[] creaCliente(Coche[] coches) {
        Cliente[] clientes = new Cliente[MAX_CLIENTE];

        for (int i = 0; i < MAX_CLIENTE; i++){
            clientes[i] = new Cliente(
                    ("12345678" + (char)('A' + i)), // letra random
                    "Cliente " + (i+1),
                    "ApellidoRandom",
                    asignaCoches(coches)); // devuelve 3 matriculas;
            contadorCoches++;
        }

        return clientes;
    }

    private static String[] asignaCoches(Coche[] coches) {
        String[] matriculas = new String[COCHES_POR_CLIENTE];

        for (int i = 0; i < matriculas.length; i++){
            matriculas[i] = coches[totalCoches++].matricula;
        }

        return matriculas;
    }

    private static Coche[] creaCoche() {
        Coche[] cochesCliente = new Coche[MAX_COCHE];

        for (int i = 0; i < MAX_COCHE; i++){
            int color = r.nextInt(COLOR.length); // color random
            int marca = r.nextInt(MARCA.length); // marca random

            cochesCliente[i] = new Coche(
                    ("1234" + (char)('A' + contadorCoches++) +
                            (char)('A' + contadorCoches++) +
                            (char)('A' + contadorCoches++)), // letras random
                    MARCA[marca],
                    COLOR[color]
            );
            if (contadorCoches >= 24){
                contadorCoches = r.nextInt(24);
            }

        }

        return cochesCliente;
    }
}