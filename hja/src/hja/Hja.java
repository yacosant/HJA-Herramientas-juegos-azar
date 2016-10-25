package hja;


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
			parseSalidaTxtOption(line); //Guardamos resultados
                        parseGameOption(line); //Jugamos
			
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

		System.out.println("Usted quiere cargar el archivo " + txtEntrada);
	}



	//Creamos comando para txt de salida
	private static Option constructSalidaTxtOption() {
		return new Option("sal", "salida", true,
				"Txt para salir");
	}

	//parseamos comando para txt de Salida

	private static void parseSalidaTxtOption(CommandLine line) throws ParseException{
		txtSalida = line.getOptionValue("sal");
		System.out.println("Usted quiere guardar en el archivo " + txtSalida);

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
		boolean proyecto= true;

		for (GameInfo g : GameInfo.values()) {
			if (g.getId().equals(gameVal)) {
				selectedGame = g;
				break;
			}
		}

		if (selectedGame == null) {
			throw new ParseException("No existe ese juego");
		}
                ar = new MejorJugada();
		//Switch de los juegos que hay 
		switch ( selectedGame ) {

		case CincoCartas: //Apartado 1
			System.out.println("le has metido un 1");
			
			manos = ar.cargar(txtEntrada);
			while (cont < manos.size()) {
				String respuesta = log.comprobar(true,manos.get(cont));
				ar.guardar(txtSalida, respuesta, cont);
				System.out.println(respuesta);
				cont++;
			}        
			cont=0;

			break;

		case DosCartas: //Apartado 2
			System.out.println("le has metido un 2");
			CartasModo2 c = new CartasModo2(new ArrayList<Carta[]>(),new ArrayList<Carta[]>());
			c= ar.cargarModo2(txtEntrada);
			if(c.getSize()==5) proyecto= false;
			manos= c.juntar(2);

			while (cont < manos.size()) {
				String respuesta = log.comprobar(proyecto,manos.get(cont));
				ar.guardar(txtSalida, respuesta, cont);
				System.out.println(respuesta);
				cont++;
			}        
			cont=0;

			break;

		case NJugadores: //Apartado 3
			System.out.println("le has metido un 3");
			CartasModo2 c3 = new CartasModo2(new ArrayList<Carta[]>(),new ArrayList<Carta[]>());
			c3= ar.cargarModo3(txtEntrada);
			manos = c3.juntar(3);
			String salida= log.comprobarModo3(manos);
                        ar.guardar(txtSalida, salida, 0);
			break;

		case OMAHA:
			System.out.println("le has metido un 4");
		}         
	}

	public static void main(String[] args) {
		manos  = new ArrayList<Carta[]>();
		parseArgs(args);
	}
}
