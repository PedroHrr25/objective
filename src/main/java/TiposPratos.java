import java.util.HashSet;

public class TiposPratos {

private String pratos;

    public TiposPratos(String pratos) {
        this.pratos = pratos;
    }

    public String getPratos() {
        return pratos;
    }

    public void setPratos(String pratos) {
        this.pratos = pratos;
    }

    @Override
    public String toString() {
        return pratos ;

    }
}
