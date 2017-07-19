package com.xyinc.poi.service;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyinc.poi.PoiApplicationTests;
import com.xyinc.poi.model.Poi;

public class PoiServiceTest extends PoiApplicationTests {
	
	@Autowired
	private PoiService poiService;
	
	public void testFindAllPois() {
		
		List<Poi> pois = this.poiService.findAll();
		
		assertTrue(pois.size() >= 0);
		
	}
	
	@Test
	public void testInsertPoi() {
		
		Poi poi = new Poi("Games", 28,1);
		
		Poi save = this.poiService.save(poi);
		
		assertNotNull(save.getId());
		
		this.poiService.delete(save.getId());
		
	}
	
	@Test
	public void testFilterPoi() {
		
		List<Poi> poisFilter = this.poiService.filter(20, 10, 10);
		
		assertEquals(poisFilter.get(0).getName(),"Lanchonete");
		assertEquals(poisFilter.get(1).getName(),"Joalheria");
		assertEquals(poisFilter.get(2).getName(),"Pub");
		assertEquals(poisFilter.get(3).getName(),"Supermercado");
		
		assertTrue(poisFilter.size() >= 4);
		
	}
}
