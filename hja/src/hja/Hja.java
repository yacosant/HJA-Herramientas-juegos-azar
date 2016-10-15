package hja;

import java.util.ArrayList;

/**
 * 
 * @author Grupo 1
 *
 */
public class Hja {

	/**
	 * @param args
	 *            the command line arguments
	 */

	enum GameInfo { //Enumerado de los juegos que tenemos
		OMAHA("1", "1"),
		CincoCartas("2", "2"),
		DosCartas("3", "3"),
		NJugadores("4","4");

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
			throw new ParseException("Uknown game '" + gameVal + "'");
		}

		//Switch de los juegos que hay 
		switch ( selectedGame ) {
		case OMAHA:
			gameFactory = new OmahaFactory();//HABRA QUE CREARLAS O PONER AQUI DIRECTAMENTE LAS DIFERENCIAS
			break;
		case CincoCartas:
			gameFactory = new CincoCartasFactory();
			break;
		case DosCartas:
			gameFactory = new DosCartasFactory();
			break;
		case NJugadores:
			gameFactory = new NJugadoresFactory();
		}

	}

	public static void main(String[] args) {
		
		//Game g = gameFactory.u(); meditando como lo hare ..

		//createSwingView(g); cuando hagamos swing view necesitaremos pasarle el juego para mostrar uno u otro

		// leemos archivo
		MejorJugada ar = new MejorJugada();
		Logica log = new Logica();
		//Carta[][] manos  = new Carta[3][5];
                ArrayList<Carta[]> manos  = new ArrayList<Carta[]>();
		manos = ar.cargar("prueba.txt");
		int cont = 0;
		while (cont < manos.size()) {
			String respuesta = log.comprobar(manos.get(cont));
                        ar.guardar(respuesta, cont);
			System.out.println(respuesta);
			cont++;
		}
	}
}
