package com.xyinc.poi.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.xyinc.poi.PoiApplicationTests;
import com.xyinc.poi.model.Poi;

/**
 * Classe responsavel por testar as funcionalidades da api liberadas pelo PoiController
 * @author elvis
 */
public class PoiControllerTest extends PoiApplicationTests {
	
	@LocalServerPort
	private int port;
	
	private static String URL = "http://localhost:8080/api/v1/poi";
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	/**
	 * Metodo responsavel por validar a requisicao de todos os pontos de interesses cadastrados 
	 */
	@Test
	public void testGetFindAllPoi() {
	
		ResponseEntity<String> response = this.testRestTemplate.getForEntity(URL, String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
	}
	
	/**
	 * Metodo responsavel por validar a requisicao para cadastro de um novo ponto de referencia
	 */
	@Test
	public void testInsertPoi() {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("name", "Games");
		map.add("coordinateX", "10");
		map.add("coordinateY", "20");
		
		ResponseEntity<Poi> response = this.testRestTemplate.postForEntity(URL, map ,  Poi.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		assertNotNull(response.getBody().getId());
		
	}
	
	/**
	 * Metodo responsavel por validar a requisicao para cadastro de um novo ponto de referencia com campos obrigatorio nao enviados
	 */
	@Test
	public void testExceptionInsertPoi() {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("name", "Games");
		map.add("coordinateY", "20");
		
		ResponseEntity<Poi> response = this.testRestTemplate.postForEntity(URL, map ,  Poi.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.INTERNAL_SERVER_ERROR));
		
	}
	
	/**
	 * Metodo responsavel por validar a requisicao para filtrar os pontos de interesses
	 */
	@Test
	public void testFilterPoi() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL.concat("/filter"))
		        .queryParam("coordinateX", "20")
		        .queryParam("coordinateY", "12")
		        .queryParam("dmax", "");
		
		String url = builder.build().encode().toUri().toString();

		ResponseEntity<String> response = this.testRestTemplate.getForEntity(url, String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
				
	}
	
	
	
	
}
