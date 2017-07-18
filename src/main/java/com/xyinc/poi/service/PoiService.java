package com.xyinc.poi.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyinc.poi.model.Poi;
import com.xyinc.poi.repository.PoiRepository;

@Service
public class PoiService {
	
	@Autowired
	private PoiRepository poiRepository;
	
	/**
	 * Metodo responsavel por buscar todos os pontos de referencia cadastrados
	 * @return List<Poi>
	 */
	public List<Poi> findAll() {
		return this.poiRepository.findAll();
	}
	
	/**
	 * Metodo responsavel por salvar um ponto de referencia
	 * @param poi
	 * @return Poi
	 */
	public Poi save(Poi poi) {
		return this.poiRepository.save(poi);
	}
	
	/**
	 * Metodo responsavel por buscar todos os pontos de referencia que estejam a uma 
	 * distancia menor ou igual a dmax a partir de uma coordenada X e Y
	 * @param coordinateX
	 * @param coordinateY
	 * @param dmax
	 * @return List<Poi>
	 */
	public List<Poi> filter(Integer coordinateX, Integer coordinateY , Integer dmax){
	
		List<Poi> pois = this.poiRepository.findAll();
		
		List<Poi> listFilter = new ArrayList<Poi>();
		for(Poi ele: pois) {
			
			Double x = Math.pow( coordinateX - ele.getCoordinateX() , 2);
			Double y = Math.pow( coordinateY - ele.getCoordinateY(), 2);
			
			Double result = Math.sqrt((x + y));
			
			if(result <= dmax ) {
				listFilter.add(ele);
			}
		}
		
		return listFilter;
				
	}
}
