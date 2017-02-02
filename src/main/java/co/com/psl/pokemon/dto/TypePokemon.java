package co.com.psl.pokemon.dto;

public class TypePokemon {
	
	private final long id;
    private final String type;
    
	public TypePokemon(long id, String type) {
		this.id = id;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	   

}
