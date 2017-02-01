package co.com.psl.pokemon;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

	@Autowired
	PokemonSetUp data;
	
	@RequestMapping(value="/pokemon", method = RequestMethod.GET)
	public @ResponseBody List<Pokemon> getAllPokemon() {	
		return data.getPokemonList();
	}

	@RequestMapping(value="/pokemon/{pokemonId}", method = RequestMethod.GET)
	public @ResponseBody Pokemon getPokemonById(@PathVariable("pokemonId") long pokemonId) {	
		return data.getPokemonById(pokemonId);
	}
	
	@RequestMapping(value="/pokemon/types", method = RequestMethod.GET)
	public @ResponseBody List<TypePokemon> getAllTypesList() {	
		return data.getTypeList();
	}
	
	@RequestMapping(value="/pokemon/types/{typeId}", method = RequestMethod.GET)
	public @ResponseBody TypePokemon getTypesListById(@PathVariable("typeId") long typeId) {	
		return data.getTypeListById(typeId);
	}
}
