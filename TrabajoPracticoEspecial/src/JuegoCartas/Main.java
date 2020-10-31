package JuegoCartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import JuegoCartas.Pocima.PocimaIncrementar;
import JuegoCartas.Pocima.PocimaReductora;
import JuegoCartas.Pocima.Pocima;
import JuegoCartas.Pocima.PocimaValorEstatico;
import JuegoCartas.Pocima.PocimaSelectiva;


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
		String mazoPath = "C:\\Users\\cecil\\eclipse-workspace2\\TrabajoPracticoEspecial\\src\\JuegoCartas\\superheroes.json";
		Jugador cecilia= new Jugador("Cecilia");
		Jugador carlos= new Jugador("Carlos");
		Mazo mazo= new Mazo();
		mazo= cargarMazo(mazoPath);
		Pocima fortalecedora1= new PocimaIncrementar("Fortalecedora", 20);
		Pocima kriptonita= new PocimaReductora("Kriptonita",25);
		Pocima valeCuatro= new PocimaValorEstatico("Quiero vale cuatro",4);
		Pocima fuerza= new PocimaSelectiva("Selectiva fuerza",35, "fuerza");
		Juego juego= new Juego(cecilia, carlos, mazo);
		juego.addPocima(valeCuatro);
		juego.addPocima(fortalecedora1);
		juego.addPocima(fuerza);
		juego.addPocima(kriptonita);
		juego.jugar();
		System.out.println(juego.getJugador1().getCarta().getPocima());

	}

}
