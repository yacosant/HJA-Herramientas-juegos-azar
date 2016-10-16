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
    
    public ArrayList<Carta> juntar(int pos){
       ArrayList<Carta> c = new ArrayList<Carta>();
       
       for (int i=0; i<cartasMano.size(); i++){
           c.add(cartasMano.get(pos)[i]);
       }
        for (int i=0; i<cartasMesa.size(); i++){
           c.add(cartasMesa.get(pos)[i]);
       }
       
       return c;
    }
}
