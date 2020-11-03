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
import JuegoCartas.Estrategia.EstrategiaTimbero;
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
		//MAZO
		Mazo mazo1= new Mazo();
		Mazo mazo2= new Mazo();
		String mazoPath1 = "C:\\Users\\cecil\\eclipse-workspace\\TrabajoPracticoEspecial\\src\\JuegoCartas\\superheroes.json";
		String mazoPath2 = "C:\\Users\\cecil\\eclipse-workspace\\TrabajoPracticoEspecial\\src\\JuegoCartas\\autos.json";
		mazo1= cargarMazo(mazoPath1);
		mazo2= cargarMazo(mazoPath2);

		//POCIMAS
		Pocima incrementar1= new PocimaIncrementar("Fortalecedora", 20);
		Pocima incrementar2= new PocimaIncrementar("Fortalecedora Plus", 50);
		Pocima reductora1= new PocimaReductora("Kriptonita",25);
		Pocima reductora2= new PocimaReductora("Reductor de Plomo", 55);
		Pocima valorEstatico1= new PocimaValorEstatico("Quiero vale cuatro",4);
		Pocima valorEstatico2= new PocimaValorEstatico("Numero Magico", 23);
		Pocima selectiva1= new PocimaSelectiva("Selectiva fuerza",35, "fuerza");
		Pocima selectiva2= new PocimaSelectiva("Selectiva peso", 43, "peso");
		Pocima cocktail1= new PocimaCocktail("Cocktail",selectiva1, incrementar1);
		Pocima cocktail2= new PocimaCocktail("Cocktail", reductora2, valorEstatico1);
		Pocima incrementar3= new PocimaIncrementar("Fortalecedora MAX", 90);
		Pocima incrementar4= new PocimaIncrementar("Fortalecedora MIN", 5);
		Pocima reductora3= new PocimaReductora("Reducir",5);
		Pocima reductora4= new PocimaReductora("Sin oxigeno", 80);
		Pocima valorEstatico3= new PocimaValorEstatico("Quiero vale ocho",8);
		Pocima valorEstatico4= new PocimaValorEstatico("Numero Mistico", 66);
		Pocima selectiva3= new PocimaSelectiva("Selectiva peleas ganadas",15, "peleas ganadas");
		Pocima selectiva4= new PocimaSelectiva("Selectiva velocidad", 70, "velocidad");
		Pocima cocktail3= new PocimaCocktail("Cocktail",selectiva4, incrementar3);
		Pocima cocktail4= new PocimaCocktail("Cocktail", reductora3, valorEstatico1);
	
		//ESTRATEGIAS
		Estrategia ambicioso= new EstrategiaAmbicioso();
		Estrategia obstinado= new EstrategiaObstinado("altura");
		Estrategia timbero= new EstrategiaTimbero();
		
		//JUGADORES
		Jugador cecilia= new Jugador("Cecilia");
		Jugador victoria= new Jugador("Victoria");
		//cecilia.setEstrategia(obstinado);
		//victoria.setEstrategia(ambicioso);
		
		//SETEAR VALORES DEL JUEGO
		Juego juego= new Juego(75,cecilia, victoria, mazo1);
		juego.addPocima(valorEstatico1);
		juego.addPocima(valorEstatico2);
		juego.addPocima(incrementar1);
		juego.addPocima(incrementar2);
		juego.addPocima(selectiva1);
		juego.addPocima(selectiva2);
		juego.addPocima(reductora1);
		juego.addPocima(reductora2);
		juego.addPocima(cocktail1);
		juego.addPocima(cocktail2);
		juego.addPocima(valorEstatico3);
		juego.addPocima(valorEstatico4);
		juego.addPocima(incrementar3);
		juego.addPocima(incrementar4);
		juego.addPocima(selectiva3);
		juego.addPocima(selectiva4);
		juego.addPocima(reductora3);
		juego.addPocima(reductora4);
		juego.addPocima(cocktail3);
		juego.addPocima(cocktail4);
		
		//EJECUTAR JUEGO
		juego.jugar();

	}

}
