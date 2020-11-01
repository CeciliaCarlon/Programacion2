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
import JuegoCartas.Estrategia.Estrategia;
import JuegoCartas.Estrategia.EstrategiaAmbicioso;
import JuegoCartas.Estrategia.EstrategiaObstinado;
import JuegoCartas.Pocima.Pocima;
import JuegoCartas.Pocima.PocimaCocktail;
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
		String mazoPath = "C:\\Users\\cecil\\eclipse-workspace\\TrabajoPracticoEspecial\\src\\JuegoCartas\\superheroes.json";
		Jugador cecilia= new Jugador("Cecilia");
		Jugador victoria= new Jugador("Victoria");
		Mazo mazo= new Mazo();
		
		mazo= cargarMazo(mazoPath);
		Pocima incrementar1= new PocimaIncrementar("Fortalecedora", 20);
		Pocima reductora1= new PocimaReductora("Kriptonita",25);
		Pocima valorEstatico1= new PocimaValorEstatico("Quiero vale cuatro",4);
		Pocima selectiva1= new PocimaSelectiva("Selectiva fuerza",35, "fuerza");
		Pocima incrementar2= new PocimaIncrementar("Fortalecedora Plus", 50);
		Pocima reductora2= new PocimaReductora("Reductor de Plomo", 55);
		Pocima valorEstatico2= new PocimaValorEstatico("Numero Magico", 23);
		Pocima selectiva2= new PocimaSelectiva("Selectiva peso", 43, "peso");
		Pocima cocktail= new PocimaCocktail("Cocktail",selectiva1, incrementar1);
		Estrategia ambicioso= new EstrategiaAmbicioso();
		Estrategia obstinado= new EstrategiaObstinado("fuerza");
		
		Juego juego= new Juego(50,cecilia, victoria, mazo);
		juego.addPocima(valorEstatico1);
		juego.addPocima(valorEstatico2);
		juego.addPocima(incrementar1);
		juego.addPocima(incrementar2);
		juego.addPocima(selectiva1);
		juego.addPocima(selectiva2);
		juego.addPocima(reductora1);
		juego.addPocima(reductora2);
		juego.addPocima(cocktail);
		cecilia.setEstrategia(ambicioso);
		victoria.setEstrategia(obstinado);
		
		juego.jugar();

	}

}
