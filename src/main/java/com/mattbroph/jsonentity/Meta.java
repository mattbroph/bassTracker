package com.mattbroph.jsonentity;

import java.util.List;

public class Meta{
	private String generated;
	private List<String> stations;

	public void setGenerated(String generated){
		this.generated = generated;
	}

	public String getGenerated(){
		return generated;
	}

	public void setStations(List<String> stations){
		this.stations = stations;
	}

	public List<String> getStations(){
		return stations;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"generated = '" + generated + '\'' + 
			",stations = '" + stations + '\'' + 
			"}";
		}
}