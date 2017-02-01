package co.com.psl.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
	
	private final AtomicLong counterType = new AtomicLong();
	private final AtomicLong counterPokemon = new AtomicLong();	
	private List<TypePokemon> typeList = new ArrayList<TypePokemon>(); 	
	private List<Pokemon> pokemonList = new ArrayList<Pokemon>();	
		
	@RequestMapping(value="/pokemon", method = RequestMethod.GET)
    public List<Pokemon> getAllPokemon() {	
		this.setUp();
		return pokemonList;
    }
	
	public void setUp(){
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"normal"));
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"electric"));
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"ground"));
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"grass"));
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"poison"));
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"fire"));
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"ice"));
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"flying"));
		typeList.add(new TypePokemon(counterType.incrementAndGet(),"physic"));
		
		List<TypePokemon> type = new ArrayList<TypePokemon>();		
		List<TypePokemon> weakness = new ArrayList<TypePokemon>();
		
		type.add(typeList.get(1));
		weakness.add(typeList.get(2));		
		pokemonList.add(new Pokemon(counterPokemon.incrementAndGet(), "Pikachu",
				type, weakness , 3, "http://www.dondevive.org/wp-content/uploads/2016/07/pikachu.jpg"));
		
		
		type.clear();
		weakness.clear();
		type.add(typeList.get(4));
		type.add(typeList.get(5));
		weakness.add(typeList.get(5));
		weakness.add(typeList.get(6));
		weakness.add(typeList.get(7));
		weakness.add(typeList.get(8));
		pokemonList.add(new Pokemon(counterPokemon.incrementAndGet(), "Bulbasaur",
				type, weakness , 0, "http://www.dondevive.org/wp-content/uploads/2016/07/pikachu.jpg"));
	}
}
