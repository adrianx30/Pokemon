package co.com.psl.pokemon.dto;

import java.util.List;

public class Pokemon {

	private final long id;
    private final String name;
    private final List<TypePokemon> type;
    private final List<TypePokemon> weakness;
    private final long evolutionId;
    private final String image;
    
	public Pokemon(long id, String name, List<TypePokemon> type, List<TypePokemon> weakness, long evolutionId, String image) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.weakness = weakness;
		this.evolutionId = evolutionId;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<TypePokemon> getType() {
		return type;
	}

	public List<TypePokemon> getWeakness() {
		return weakness;
	}

	public long getEvolutionId() {
		return evolutionId;
	}

	public String getImage() {
		return image;
	}
    
    
}
