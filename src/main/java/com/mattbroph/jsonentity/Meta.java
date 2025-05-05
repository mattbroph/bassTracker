package com.mattbroph.jsonentity;

import java.util.List;

/**
 * The type Meta.
 */
public class Meta{
	private String generated;
	private List<String> stations;

	/**
	 * Set generated.
	 *
	 * @param generated the generated
	 */
	public void setGenerated(String generated){
		this.generated = generated;
	}

	/**
	 * Get generated string.
	 *
	 * @return the string
	 */
	public String getGenerated(){
		return generated;
	}

	/**
	 * Set stations.
	 *
	 * @param stations the stations
	 */
	public void setStations(List<String> stations){
		this.stations = stations;
	}

	/**
	 * Get stations list.
	 *
	 * @return the list
	 */
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