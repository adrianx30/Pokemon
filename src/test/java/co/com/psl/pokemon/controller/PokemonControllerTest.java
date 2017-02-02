package co.com.psl.pokemon.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerTest {

	@Autowired
	private MockMvc mockMvc;
		
	@Test
	public void paramPokemonShouldReturnPokemonFound() throws Exception {
		String expected = "[{\"id\":1,\"name\":\"Pikachu\",\"type\":[{\"id\":5,\"type\":\"poison\"},"
        		+ "{\"id\":6,\"type\":\"fire\"}],\"weakness\":[{\"id\":6,\"type\":\"fire\"},{\"id\":7,\"type\":\"ice\"},"
        		+ "{\"id\":8,\"type\":\"flying\"},{\"id\":9,\"type\":\"physic\"}],\"evolutionId\":3,\"image\":"
        		+ "\"http://www.dondevive.org/wp-content/uploads/2016/07/pikachu.jpg\"}]";
	    this.mockMvc.perform(get("/pokemon").param("name", "pika")).andDo(print()).andExpect(status().isOk())
	    .andExpect(content().json(expected));    
	}
	
	@Test
	public void getAllShouldReturnAllPokemon() throws Exception{
		
		String expected = "[{\"id\":1,\"name\":\"Pikachu\",\"type\":[{\"id\":5,\"type\":\"poison\"},{\"id\":6,\"type\":\"fire\"}],\"weakness\":[{\"id\":6,\"type\":\"fire\"},{\"id\":7,\"type\":\"ice\"},{\"id\":8,\"type\":\"flying\"},{\"id\":9,\"type\":\"physic\"}],\"evolutionId\":3,\"image\":\"http://www.dondevive.org/wp-content/uploads/2016/07/pikachu.jpg\"},{\"id\":2,\"name\":\"Bulbasaur\",\"type\":[{\"id\":5,\"type\":\"poison\"},{\"id\":6,\"type\":\"fire\"}],\"weakness\":[{\"id\":6,\"type\":\"fire\"},{\"id\":7,\"type\":\"ice\"},{\"id\":8,\"type\":\"flying\"},{\"id\":9,\"type\":\"physic\"}],\"evolutionId\":0,\"image\":\"http://www.dondevive.org/wp-content/uploads/2016/07/pikachu.jpg\"}]";	
		this.mockMvc.perform(get("/pokemon")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().json(expected));
	}
	
	@Test
	public void getPokemonByIdShouldReturnPokemon() throws Exception{
		
		this.mockMvc.perform(get("/pokemon/1")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1));
	}
	
	@Test
	public void getTypesShouldReturnAllTypes() throws Exception {
		
		String expected = "[{\"id\":1,\"type\":\"normal\"},{\"id\":2,\"type\":\"electric\"},{\"id\":3,\"type\":\"ground\"},{\"id\":4,\"type\":\"grass\"},{\"id\":5,\"type\":\"poison\"},{\"id\":6,\"type\":\"fire\"},{\"id\":7,\"type\":\"ice\"},{\"id\":8,\"type\":\"flying\"},{\"id\":9,\"type\":\"physic\"}]";
	    this.mockMvc.perform(get("/pokemon/types")).andDo(print()).andExpect(status().isOk())
	    .andExpect(content().json(expected));    
	}
	
	@Test
	public void getTypesByIdShouldReturnType() throws Exception{
		
		this.mockMvc.perform(get("/pokemon/types/4")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(4));
	}
	
	/*
	@Test
	public void getAllShouldReturnErrorIfNameNotFound() throws Exception{
		this.mockMvc.perform(get("/pokemon").param("name", "ThisIsNotAPokemonName")).andDo(print()).andExpect(status().isBadRequest())
		.andReturn();
	} */
	

}
