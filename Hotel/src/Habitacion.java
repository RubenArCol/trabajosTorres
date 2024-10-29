public class Habitacion {
    boolean suite;
    int camas;
    double precio;
    boolean bookings;
    boolean ocupada;

    public Habitacion(boolean suite, int camas, double precio, boolean bookings, boolean ocupada) {
        this.suite = suite;
        this.camas = camas;
        this.precio = precio;
        this.bookings = bookings;
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("suite=").append(suite);
        sb.append(", camas=").append(camas);
        sb.append(", precio=").append(String.format("%.2f", precio));
        sb.append(", bookings=").append(bookings);
        sb.append(", ocupada=").append(ocupada);
        return sb.toString();
    }
}
