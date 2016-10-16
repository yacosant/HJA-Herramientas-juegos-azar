
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

		CommandLineParser parser = new DefaultParser();

		try{
			CommandLine line = parser.parse(cmdLineOptions, args);
			parseGameOption(line);
		
		String[] remaining = line.getArgs();
		if (remaining.length > 0) {
			String error = "Illegal arguments:";
			for (String o : remaining)
				error += (" " + o);
			throw new ParseException(error);
		}

	} catch (ParseException e) {
		System.out.println("No existe ese comando");
	}
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
			break;
		case DosCartas:
			System.out.println("le has metido un 2");
			break;
		case NJugadores:
			System.out.println("le has metido un 3");
			break;
		case OMAHA:
			System.out.println("le has metido un 4");
		}

	}

	public static void main(String[] args) {
		parseArgs(args);

		//COMENTO ESTO PARA VER SI PARSEA BIEN
		
//		// leemos archivo
//		MejorJugada ar = new MejorJugada();
//		Logica log = new Logica();
//		//Carta[][] manos  = new Carta[3][5];
//                ArrayList<Carta[]> manos  = new ArrayList<Carta[]>();
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
