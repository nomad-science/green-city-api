package io.greencity.greencityapi.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PlantControllerIT {

	@Autowired
	private MockMvc mockMvc;

	private static final String API_ROOT = "/v1/plants";

	@Test
	public void plantApiShouldReturnOkayStatus() throws Exception {
		this.mockMvc.perform(get(API_ROOT)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void plantApiShouldReturnNotFoundStatusCodeForValidEntry() throws Exception {
		this.mockMvc.perform(get(API_ROOT + "/taraxacum officinale")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void plantApiShouldReturnNotFoundStatusCodeForInvalidEntry() throws Exception {
		this.mockMvc.perform(get(API_ROOT + "/obviously fake")).andDo(print()).andExpect(status().isNotFound());
	}
}
