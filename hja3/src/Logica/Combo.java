package Logica;

/**
 *
 * @author Grupo 1
 *
 */
public class Combo {

    private Carta carta1;
    private Carta carta2;

    public Carta getCarta(int i) {
        Carta carta;

        if (i == 1) {
            carta = carta1;
        } else {
            carta = carta2;
        }

        return carta;
    }

    public Combo(Carta carta1, Carta carta2) {
        this.carta1 = carta1;
        this.carta2 = carta2;

    }

}
