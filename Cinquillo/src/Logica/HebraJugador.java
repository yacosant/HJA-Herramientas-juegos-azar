package Logica;

import javax.swing.SwingUtilities;

/**
 * Clase que permite crear una hebra en para poder
 * realizar varias operaciones en paralelo ; permite
 * que los jugadores realizar movimientos sin detener 
 * la aplicaci�n.
 */
public class HebraJugador extends Thread{
	private Logica log;
	/**
	 * Método Constructor de la clase HebraJugador.
	 */
	public HebraJugador(Logica control){
		this.log=control;
	}
	/**
	 * M�todo que permite que comienze la ejecuci�n 
	 * de la hebra
	 */
	public void run(){
	
		try {
		
			Thread.sleep(1000);	// pone a dormir
			SwingUtilities.invokeLater (new Runnable(){ /*Clase interna para realizar
                                            		el movimiento*/
	    
			public void run() {
				//log.movAleatorio();
                                System.out.println("HOLA JEJE");//debug
				}
			
			});
			
		} catch ( InterruptedException ex) {
		}   
		
		
	}


}
