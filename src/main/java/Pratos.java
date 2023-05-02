public class Pratos {

    private String Pratos;

    public Pratos(String pratos) {
        Pratos = pratos;
    }

    public String getPratos() {
        return Pratos;
    }

    public void setPratos(String pratos) {
        Pratos = pratos;
    }

    @Override
    public String toString() {
        return  Pratos ;
    }
}
