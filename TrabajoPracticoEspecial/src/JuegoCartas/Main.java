package JuegoCartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {
	
	public static Mazo cargarMazo(String jsonFile) {
        //URL url = getClass().getResource(jsonFile);
		Mazo mazoNuevo= new Mazo();
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                Carta nuevaCarta= new Carta(nombreCarta);
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                for (String nombreAtributo:atributos.keySet()) {
                	int valorAtributo=atributos.getInt(nombreAtributo);
                	Atributo atributo= new Atributo(nombreAtributo, valorAtributo);
                	nuevaCarta.addAtributo(atributo);
                }
                mazoNuevo.addCarta(nuevaCarta);
            }

            reader.close();
            return mazoNuevo;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

	public static void main(String[] args) {
		String mazoPath = "C:\\Users\\cecil\\eclipse-workspace\\TrabajoPracticoEspecial\\src\\JuegoCartas\\superheroes.json";
		Jugador cecilia= new Jugador("Cecilia");
		Jugador mariana= new Jugador("Mariana");
		Mazo mazo= new Mazo();
		mazo= cargarMazo(mazoPath);
		//VisorMazo.mostrarMazo(mazoPath);
		Juego juego= new Juego(cecilia, mariana, mazo);
		juego.jugar();
		/*
		 * tira este error de vez en cuando
		 * Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 5, Size: 5
			at java.util.ArrayList.rangeCheck(Unknown Source)
			at java.util.ArrayList.get(Unknown Source)
			at JuegoCartas.Carta.elegirAtributoAleatorio(Carta.java:22)
			at JuegoCartas.Jugador.elegirAtributo(Jugador.java:20)
			at JuegoCartas.Juego.jugar(Juego.java:48)
			at JuegoCartas.Main.main(Main.java:56)

		 */
	}

}
