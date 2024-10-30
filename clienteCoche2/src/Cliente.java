import java.util.Arrays;

public class Cliente {
    String Dni;
    String Nombre;
    String Apellidos;
    String[] matriculas;

    public Cliente(String dni, String nombre, String apellidos, String[] matriculas) {
        Dni = dni;
        Nombre = nombre;
        Apellidos = apellidos;
        this.matriculas = matriculas;
    }

    @Override
    public String toString() {
        return "Cliente: \n" +
                "Dni: " + Dni +
                ", Nombre: " + Nombre +
                ", Apellidos: " + Apellidos +
                ", matriculas: " + Arrays.toString(matriculas) + "\n";
    }
}
