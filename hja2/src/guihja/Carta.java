package guihja;
//
/**
 *
 * @author Grupo 1
 *
 */
public class Carta {

    private char color;
    private int valor;

    public Carta(int val, char col) {
        valor = val;
        color = col;
    }

    public char getColor() {
        return color;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int v) {
        valor = v;
    }

}
