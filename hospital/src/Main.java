import java.util.Random;
import java.util.Scanner;

public class Main {
    // Funciones
    public static final Random r = new Random();
    public static final Scanner sc = new Scanner(System.in);

    // constantes
    public static final int MAX_GLUCOSA = 10; // máximo nro de valores de glucosa
    public static final int[] VALORES_GLUCOSA = {70, 90, 120}; // Vector para almacenar los valores de la glucosa
    public static final String[] ESPECIALIDADES = {"Cabecera", "Quirófano", "Anestesia", "Cardioogía"}; // Vector de especialidades
    public static final int MAX_MEDICOS = 5; // maximo nro de médicos (editable)
    public static final int MAX_PACIENTES = 5; // máximo nro de pacientes (editable)
    public static final int[][] listaPacientes = new int[MAX_MEDICOS][MAX_PACIENTES]; // Matriz que controla los pacientes de cada médico

    public static void main(String[] args) {
        Medico[] medicos = new Medico[MAX_MEDICOS];
        agregaMedicos(medicos); // Agrego medicos generados aleatoriamente al vector

        Paciente[] pacientes = new Paciente[MAX_PACIENTES];
        agregaPacientes(pacientes); // lo mismo con los pacientes

        inicializaLista(listaPacientes); // Asigno pacientes a los médicos usando la matriz
        muestraPacientes(listaPacientes, medicos, pacientes); // listo los pacientes de cada médico y sus análisis de glucosa
    }

    private static void muestraPacientes(int[][] listaPacientes, Medico[] medicos, Paciente[] pacientes) {
        int medico;
        Paciente[] pacientePorMedico = new Paciente[MAX_PACIENTES];
        int contador = 0;

        do {
            System.out.println("Indica el id del médico para listar sus pacientes (1 a " + MAX_MEDICOS + "):");
            medico = sc.nextInt();
            sc.nextLine();
        } while (medico < 1 || medico > MAX_MEDICOS);
        medico--; // reduzco el valor para poder manejarlo en los arrays

        for (int i = 0; i < MAX_PACIENTES; i++){
            if (listaPacientes[medico][i] == 1){
                // los pacientes de ese médico se añaden en un array a parte
                pacientePorMedico[contador] = pacientes[i];
                contador++; // evita la sobreescritura de datos
            }
        }

        System.out.println("Pacientes de " + medicos[medico].nombre + ": ");
        for (int i = 0; i < pacientePorMedico.length; i++){
            if (pacientePorMedico[i] != null) { // Verifica que el paciente no sea nulo
                System.out.println("\nValores de glucosa del paciente " + (i+1) + ": ");
                for (int j = 0; j < MAX_GLUCOSA; j++){
                    // Segun el valor de la glucosa imprimo una cosa u otra
                    if (pacientePorMedico[i].glucosa[j] == VALORES_GLUCOSA[0]) System.out.printf("Bajo");
                    else if (pacientePorMedico[i].glucosa[j] == VALORES_GLUCOSA[1]) System.out.printf("Normal");
                    else System.out.printf("Alto");

                    if (j != MAX_GLUCOSA-1) System.out.printf(", ");
                }
            }
        }
    }

    private static void inicializaLista(int[][] listaPacientes) {
        for (int i = 0; i < listaPacientes.length; i++){
            for (int j = 0; j < listaPacientes[i].length; j++){
                // random 0/1 (si es 1 entonces es paciente del medico en concreto)
                listaPacientes[i][j] = r.nextInt(2);
            }
        }
    }

    private static void agregaPacientes(Paciente[] pacientes) {
        // aqui almaceno los datos de los 10 análisis de glucosa del paciente
        int[] glucosaPaciente;

        for (int i = 0; i < MAX_PACIENTES; i++){
            glucosaPaciente = new int[MAX_GLUCOSA];
            for (int j = 0; j < MAX_GLUCOSA; j++){
                glucosaPaciente[j] = VALORES_GLUCOSA[r.nextInt(VALORES_GLUCOSA.length)]; // valor random de glucosa
            }
            // añado paciente
            pacientes[i] = new Paciente(
                    i+1,
                    "Paciente "+(i+1),
                    glucosaPaciente
                    );
        }
    }

    private static void agregaMedicos(Medico[] medicos) {
        int especialidadRandom; // para ponerle una especialidad al azar al médico

        for (int i = 0; i < MAX_MEDICOS; i++){
            // especialidad random
            especialidadRandom = r.nextInt(ESPECIALIDADES.length);
            // añado médico
            medicos[i] = new Medico(
                    i+1,
                    "Medico "+(i+1),
                    ESPECIALIDADES[especialidadRandom]);
        }
    }
}