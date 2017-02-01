package co.com.psl.pokemon;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

	@Autowired
	PokemonSetUp data;
	
	@RequestMapping(value="/pokemon", method = RequestMethod.GET)
	public List<Pokemon> getAllPokemon() {	
		return data.getPokemonList();
	}

	@RequestMapping(value="/pokemon/{pokemonId}", method = RequestMethod.GET)
	public Pokemon getPokemonById(@PathVariable("pokemonId") long pokemonId) {	
		return data.getPokemonById(pokemonId);
	}
	
	
}
