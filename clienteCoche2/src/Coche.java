public class Coche {
    String matricula;
    String marca;
    String color;

    public Coche(String matricula, String marca, String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
    }

    @Override
    public String toString() {
        return "matricula: " + matricula + ", marca: " + marca +
                ", color: " + color + "\n";
    }
}