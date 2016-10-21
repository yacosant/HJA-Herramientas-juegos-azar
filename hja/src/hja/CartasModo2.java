package hja;

import java.util.ArrayList;

/**
 *
 * @author Grupo 1
 */
public class CartasModo2 {
    private ArrayList<Carta[]> cartasMano;
    private ArrayList<Carta[]> cartasMesa;
    private int size;
    
    public CartasModo2(ArrayList<Carta[]> mano, ArrayList<Carta[]> mesa){
        cartasMano=mano;
        cartasMesa=mesa;
        size= cartasMesa.size();
    }

    public ArrayList<Carta[]> getCartasMano() {
        return cartasMano;
    }

    public ArrayList<Carta[]> getCartasMesa() {
        return cartasMesa;
    }
    
        
    public ArrayList<Carta[]> juntar(){
        ArrayList<Carta[]> cartas = new ArrayList<Carta[]>();
        for(int pos=0; pos<size; pos++){

        Carta[] c = new Carta[size+2];
         for (int i=0; i<2; i++){
             c[i]=(cartasMano.get(pos)[i]);
         }
          for (int i=0; i<cartasMesa.size(); i++){
             c[i+2]=(cartasMesa.get(pos)[i]);
         }
          cartas.add(c);
        }
        return cartas;
    }
    
    
    public int getSize() {
        return size;
    }
    
}
