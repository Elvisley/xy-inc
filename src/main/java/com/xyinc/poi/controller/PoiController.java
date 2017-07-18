package com.xyinc.poi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xyinc.poi.model.Poi;
import com.xyinc.poi.service.PoiService;

@RestController
@RequestMapping("api/v1/poi")
public class PoiController {

	@Autowired
	private PoiService poiService;
	
	/**
	 * Metodo para retornar a lista de pontos de referencia
	 * @return List<Poi>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Poi> index(){
		return this.poiService.findAll();
	}
	
	/**
	 * Metodo para salvar o ponto de referencia
	 * @param poi
	 * @return Poi
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Poi post(Poi poi) {
		return this.poiService.save(poi);
	}
	
	/**
	 * Metodo para retornar os pontos de referencia mais proximos de acordo com os paramentros passados
	 * @param coordinateX
	 * @param coordinateY
	 * @param dmax
	 * @return List<Poi>
	 */
	@RequestMapping(value = "/filter" , method = RequestMethod.GET)
	public List<Poi> filter(
			@RequestParam(value = "coordinateX", required = true) Integer coordinateX,
			@RequestParam(value = "coordinateY", required = true) Integer coordinateY,
			@RequestParam(value = "dmax", required = false, defaultValue = "0") Integer dmax){
		return this.poiService.filter(coordinateX, coordinateY, dmax);
	}
}
