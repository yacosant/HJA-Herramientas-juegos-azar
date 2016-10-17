
import hja.Carta;
import hja.CartasModo2;
import hja.Logica;
import hja.MejorJugada;
import hja.MejorJugada2;

import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;






/**
 * 
 * @author Grupo 1

 *
 */
public class Hja {

	final private static GameInfo DEFAULT_GAME = GameInfo.CincoCartas;
       
	private static ArrayList<Carta[]> manos;
	private static String txtEntrada; //Atributos para guardar los txt de los parametros
	private static String txtSalida;
        private static MejorJugada ar;
        private static MejorJugada2 ar2;
        private static Logica log = new Logica();


	/**
	 * @param args
	 *            the command line arguments
	 */

	enum GameInfo { //Enumerado de los juegos que tenemos
		CincoCartas("1", "1"),
		DosCartas("2", "2"),
		NJugadores("3","3"),
		OMAHA("4", "4");


		private String id;
		private String desc;

		GameInfo(String id, String desc) {
			this.id = id;
			this.desc = desc;
		}

		public String getId() {
			return id;
		}

		public String getDesc() {
			return desc;
		}

		@Override
		public String toString() {
			return id;
		}

	}

	private static void parseArgs(String[] args) {

		Options cmdLineOptions = new Options();

		cmdLineOptions.addOption(constructGameOption()); // -g or --game
		cmdLineOptions.addOption(constructEntradaTxtOption()); // -ent or --entrada
		cmdLineOptions.addOption(constructSalidaTxtOption()); // -salida or --salida

		CommandLineParser parser = new DefaultParser();

		try{
			CommandLine line = parser.parse(cmdLineOptions, args);
			parseEntradaTxtOption(line); //Primero cargamos el archivo
			parseGameOption(line); //Jugamos
			parseSalidaTxtOption(line); //Guardamos resultados
		
		String[] remaining = line.getArgs();
		if (remaining.length > 0) {
			String error = "Illegal arguments:";
			for (String o : remaining)
				error += (" " + o);
			throw new ParseException(error);
		}

	} catch (ParseException e) {
		System.out.println("No existe ese comando o faltan comandos obligatorios");
	}
}
	//Construimos el comando para txt de entrada
	private static Option constructEntradaTxtOption() {
		return new Option("ent", "entrada", true,
				"Txt para cargar las cartas");
	}

	//parseamos comando para txt de entrada

	private static void parseEntradaTxtOption(CommandLine line) throws ParseException{
		 txtEntrada = line.getOptionValue("ent");

			System.out.println("Usted quiere cargar el archivo " + txtEntrada +".txt");
	}



	//Creamos comando para txt de salida
	private static Option constructSalidaTxtOption() {
		return new Option("sal", "salida", true,
				"Txt para salir");
	}

	//parseamos comando para txt de Salida

	private static void parseSalidaTxtOption(CommandLine line) throws ParseException{
		 txtSalida = line.getOptionValue("sal");
		System.out.println("Usted quiere guardar en el archivo " + txtSalida +".txt");
		
	}
	
	
	//Creamos el comando. Con -g metemos que juego queremos
	private static Option constructGameOption() { 
		String optionInfo = "The game to play ( ";
		for (GameInfo i : GameInfo.values()) {
			optionInfo += i.getId() + " [for " + i.getDesc() + "] ";
		}
		optionInfo += "). By defualt, " + DEFAULT_GAME.getId() + ".";
		Option opt = new Option("g", "game", true, optionInfo);
		opt.setArgName("game identifier");
		return opt;
	}


	//Parseamos el comando del juego que queremos jugar
	private static void parseGameOption(CommandLine line) throws ParseException {
		String gameVal = line.getOptionValue("g", DEFAULT_GAME.getId());
		GameInfo selectedGame = null;
                int cont = 0;
                
		for (GameInfo g : GameInfo.values()) {
			if (g.getId().equals(gameVal)) {
				selectedGame = g;
				break;
			}
		}

		if (selectedGame == null) {
			throw new ParseException("No existe ese juego");
		}

		//Switch de los juegos que hay 
		switch ( selectedGame ) {
		case CincoCartas:
			System.out.println("le has metido un 1");
                    ar = new MejorJugada();
                    manos = ar.cargar(txtEntrada);
                        while (cont < manos.size()) {
			String respuesta = log.comprobar(manos.get(cont));
                        ar.guardar(respuesta, cont);
			System.out.println(respuesta);
			cont++;
		}        
                 cont=0;
            
		break;
			
		case DosCartas:
			System.out.println("le has metido un 2");
                     
                     ar2 = new MejorJugada2();   
			break;
		case NJugadores:
			System.out.println("le has metido un 3");
			break;
		case OMAHA:
			System.out.println("le has metido un 4");
		}
                
	}

	public static void main(String[] args) {
		manos  = new ArrayList<Carta[]>();
            parseArgs(args);
                
                
		
		//COMENTO ESTO PARA VER SI PARSEA BIEN
		
//		// leemos archivo
//		MejorJugada ar = new MejorJugada();
//		Logica log = new Logica();
//		//Carta[][] manos  = new Carta[3][5];
                //ArrayList<Carta[]> manos  = new ArrayList<Carta[]>();
//		manos = ar.cargar("prueba.txt");
//		int cont = 0;
//		while (cont < manos.size()) {
//			String respuesta = log.comprobar(manos.get(cont));
//			System.out.println(respuesta);
//			cont++;
//		}
//	}
	}
}
