import java.util.Arrays;

public class Paciente {
    int id;
    String nombre;
    int[] glucosa;

    public Paciente(int id, String nombre, int[] glucosa) {
        this.id = id;
        this.nombre = nombre;
        this.glucosa = glucosa;
    }
}
