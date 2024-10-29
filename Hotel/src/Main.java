import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class Main {
    // constantes
        // Precio max de habitación
    public static final double MAX_PRECIO = 5000.00;
        // limite máximo de plantas
    public static final int MAX_PLANTAS = 3;

        // limite máximo de habitaciones
    public static final int MAX_HABITACIONES = 12;

        // inicializo el array de habitaciones solo indicando el tope de plantas
    public static final Habitacion[][] hotel = new Habitacion[MAX_PLANTAS][];
    public static final Random rand = new Random(); // usado para crear un nro random de habitaciones


    public static void main(String[] args) {
        inicializaHotel(hotel);
        rellenaHotel(hotel);
        muestraHotel(hotel); // prueba de funcionamiento antes de la burbuja

        System.out.println("----------------------------------------------------------------------");

        double gananciaBookings = calcularGanancia(hotel);
        System.out.println("La ganancia total de las habitaciones alquiladas por Bookings es: " + gananciaBookings);

        System.out.println("----------------------------------------------------------------------");
        ordenaHabitaciones(hotel);
        muestraHotel(hotel);


    }

    private static void ordenaHabitaciones(Habitacion[][] hotel) {
        // burbuja
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length - 1; j++) {
                for (int k = 0; k < hotel[i].length - 1 - j; k++) {
                    if (hotel[i][k].camas < hotel[i][k + 1].camas) {
                        Habitacion temp = hotel[i][k];
                        hotel[i][k] = hotel[i][k + 1];
                        hotel[i][k + 1] = temp;
                    }
                }
            }
        }
    }

    private static double calcularGanancia(Habitacion[][] hotel) {
        double ganancia = 0.0f;

        // si una habitacion esta ocupada y puesta en bookings sumo sus ganancias
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (hotel[i][j].bookings && hotel[i][j].ocupada){
                    ganancia += hotel[i][j].precio;
                }
            }
        }

        return ganancia;
    }

    private static void inicializaHotel(Habitacion[][] hotel) {
        int nroHabitaciones = 0;
        int aux = 0;

        for (int i = 0; i < hotel.length; i++){
            // genero un número random de habitaciones y las sobrantes las asigno a la última planta
            if (i < hotel.length-1){
                if (aux == MAX_HABITACIONES) break; // si la 1ra o 2da planta tiene el tope de habitaciones rompo bucle
                nroHabitaciones = rand.nextInt((MAX_HABITACIONES - aux))+1;
                hotel[i] = new Habitacion[nroHabitaciones];
                aux += nroHabitaciones;
            } else {
                hotel[i] = new Habitacion[MAX_HABITACIONES-aux];
            }

            System.out.println("Planta " + i + ": " + hotel[i].length + "habitaciones"); //prueba
        }

    }

    private static void rellenaHotel(Habitacion[][] hotel) {
        boolean suiteHab;
        int camasHab;
        double precioHab;
        boolean bookingsHab;
        boolean ocupadaHab;

        int contadorP0 = 0;
        int contadorP1 = 0;
        int contadorP2 = 0;

        for (int i = 0; i < hotel.length; i++){
            // relleno habitaciones
            for (int j = 0; j < hotel[i].length; j++){

                suiteHab = rand.nextBoolean();

                do {
                    camasHab = rand.nextInt(5);
                } while (camasHab == 0);

                precioHab = rand.nextDouble(MAX_PRECIO);

                bookingsHab = rand.nextBoolean();

                ocupadaHab = rand.nextBoolean();


                if (i == 0) {
                    hotel[i][contadorP0] = new Habitacion(suiteHab, camasHab, precioHab, bookingsHab, ocupadaHab);
                    contadorP0++;
                } else if (i == 1) {
                    hotel[i][contadorP1] = new Habitacion(suiteHab, camasHab, precioHab, bookingsHab, ocupadaHab);
                    contadorP1++;
                } else {
                    hotel[i][contadorP2] = new Habitacion(suiteHab, camasHab, precioHab, bookingsHab, ocupadaHab);
                    contadorP2++;
                }
            }
        }
    }

    private static void muestraHotel(Habitacion[][] hotel) {
        for (int i = 0; i < hotel.length; i++) {
            System.out.println("Planta " + i + ":");
            for (int j = 0; j < hotel[i].length; j++) {
                if (hotel[i][j] != null) {
                    System.out.println("\tHabitación " + j + ": " + hotel[i][j]);
                } else {
                    System.out.println("\tHabitación " + j + ": Vacía");
                }
            }
        }
    }
}