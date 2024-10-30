import java.util.Arrays;

public class Cliente {
    String Dni;
    String Nombre;
    String Apellidos;
    Coche[] coches;

    public Cliente(String dni, String nombre, String apellidos, Coche[] coches) {
        Dni = dni;
        Nombre = nombre;
        Apellidos = apellidos;
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Cliente: \n" +
                "Dni: " + Dni +
                ", Nombre: " + Nombre +
                ", Apellidos: " + Apellidos +
                ", coches: \n" + Arrays.toString(coches);
    }
}
