package co.com.psl.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class PokemonSetUp {
	
	private final AtomicLong counterType = new AtomicLong();
	private final AtomicLong counterPokemon = new AtomicLong();	
	private List<TypePokemon> typeList = new ArrayList<TypePokemon>(); 
	private List<Pokemon> pokemonList = new ArrayList<Pokemon>();
	
	public Pokemon getPokemonById(long pokemonId) {	

		for (int i = 0; i < pokemonList.size(); i++) {
			if(pokemonList.get(i).getId() == pokemonId){
				return pokemonList.get(i);
			}
		}				
		return null;
	}
	
	public TypePokemon getTypeListById(long typeId) {
		for (int i = 0; i < typeList.size(); i++) {
			if(typeList.get(i).getId() == typeId){
				return typeList.get(i);
			}
		}				
		return null;
	}
	
	public List<TypePokemon> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<TypePokemon> typeList) {
		this.typeList = typeList;
	}

	public List<Pokemon> getPokemonList() {
		return pokemonList;
	}

	public void setPokemonList(List<Pokemon> pokemonList) {
		this.pokemonList = pokemonList;
	}

	
	
	@PostConstruct
	public void Init(){
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
