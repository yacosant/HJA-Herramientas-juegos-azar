package hja;

import java.util.ArrayList;

/**
 *
 * @author Grupo 1
 */
public class CartasModo2 {
    private ArrayList<Carta[]> cartasMano;
    private ArrayList<Carta[]> cartasMesa;
    
    public CartasModo2(ArrayList<Carta[]> mano, ArrayList<Carta[]> mesa){
        cartasMano=mano;
        cartasMesa=mesa;
    }

    public ArrayList<Carta[]> getCartasMano() {
        return cartasMano;
    }

    public ArrayList<Carta[]> getCartasMesa() {
        return cartasMesa;
    }
    
}
