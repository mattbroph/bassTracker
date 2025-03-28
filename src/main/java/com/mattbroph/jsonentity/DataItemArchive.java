package com.mattbroph.jsonentity;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Data item.
 */
public class DataItemArchive {
	private String date;
	private Object wdir;
	private Object wpgt;
	private Object pres;
	private Object tmax;
	private Object snow;
	private Object wspd;
	private Object tavg;
	private Object tmin;
	private Object prcp;
	private int tsun;
	// Adding Coco
	private int coco;
	private String cocoDescription;
	private static final Map<Integer, String> WEATHER_CONDITIONS = new HashMap<Integer, String>();

	// Load the weather conditions map in the constructor
	public DataItemArchive() {
		WEATHER_CONDITIONS.put(1, "Clear");
		WEATHER_CONDITIONS.put(2, "Fair");
		WEATHER_CONDITIONS.put(3, "Cloudy");
		WEATHER_CONDITIONS.put(4, "Overcast");
		WEATHER_CONDITIONS.put(5, "Fog");
		WEATHER_CONDITIONS.put(6, "Freezing Fog");
		WEATHER_CONDITIONS.put(7, "Light Rain");
		WEATHER_CONDITIONS.put(8, "Rain");
		WEATHER_CONDITIONS.put(9, "Heavy Rain");
		WEATHER_CONDITIONS.put(10, "Freezing Rain");
		WEATHER_CONDITIONS.put(11, "Heavy Freezing Rain");
		WEATHER_CONDITIONS.put(12, "Sleet");
		WEATHER_CONDITIONS.put(13, "Heavy Sleet");
		WEATHER_CONDITIONS.put(14, "Light Snowfall");
		WEATHER_CONDITIONS.put(15, "Snowfall");
		WEATHER_CONDITIONS.put(16, "Heavy Snowfall");
		WEATHER_CONDITIONS.put(17, "Rain Shower");
		WEATHER_CONDITIONS.put(18, "Heavy Rain Shower");
		WEATHER_CONDITIONS.put(19, "Sleet Shower");
		WEATHER_CONDITIONS.put(20, "Heavy Sleet Shower");
		WEATHER_CONDITIONS.put(21, "Snow Shower");
		WEATHER_CONDITIONS.put(22, "Heavy Snow Shower");
		WEATHER_CONDITIONS.put(23, "Lightning");
		WEATHER_CONDITIONS.put(24, "Hail");
		WEATHER_CONDITIONS.put(25, "Thunderstorm");
		WEATHER_CONDITIONS.put(26, "Heavy Thunderstorm");
		WEATHER_CONDITIONS.put(27, "Storm");
	}


	public int getCoco() {
		return coco;
	}

	public void setCoco(int coco) {
		this.coco = coco;
	}

	public String getCocoDescription() {
		return cocoDescription;
	}

	public void setCocoDescription(String cocoDescription) {

		for (Map.Entry<Integer, String> entry : WEATHER_CONDITIONS.entrySet()) {

			if (entry.getKey() == this.coco) {
				this.cocoDescription = entry.getValue();
				return;
			}
		}
		// If no match is found (should be impossible unless more #s are added) set to unknown
		this.cocoDescription = "Unknown";
	}

	/**
	 * Set date.
	 *
	 * @param date the date
	 */
	public void setDate(String date){
		this.date = date;
	}

	/**
	 * Get date string.
	 *
	 * @return the string
	 */
	public String getDate(){
		return date;
	}

	/**
	 * Set wdir.
	 *
	 * @param wdir the wdir
	 */
	public void setWdir(Object wdir){
		this.wdir = wdir;
	}

	/**
	 * Get wdir object.
	 *
	 * @return the object
	 */
	public Object getWdir(){
		return wdir;
	}

	/**
	 * Set wpgt.
	 *
	 * @param wpgt the wpgt
	 */
	public void setWpgt(Object wpgt){
		this.wpgt = wpgt;
	}

	/**
	 * Get wpgt object.
	 *
	 * @return the object
	 */
	public Object getWpgt(){
		return wpgt;
	}

	/**
	 * Set pres.
	 *
	 * @param pres the pres
	 */
	public void setPres(Object pres){
		this.pres = pres;
	}

	/**
	 * Get pres object.
	 *
	 * @return the object
	 */
	public Object getPres(){
		return pres;
	}

	/**
	 * Set tmax.
	 *
	 * @param tmax the tmax
	 */
	public void setTmax(Object tmax){
		this.tmax = tmax;
	}

	/**
	 * Get tmax object.
	 *
	 * @return the object
	 */
	public Object getTmax(){
		return tmax;
	}

	/**
	 * Set snow.
	 *
	 * @param snow the snow
	 */
	public void setSnow(Object snow){
		this.snow = snow;
	}

	/**
	 * Get snow object.
	 *
	 * @return the object
	 */
	public Object getSnow(){
		return snow;
	}

	/**
	 * Set wspd.
	 *
	 * @param wspd the wspd
	 */
	public void setWspd(Object wspd){
		this.wspd = wspd;
	}

	/**
	 * Get wspd object.
	 *
	 * @return the object
	 */
	public Object getWspd(){
		return wspd;
	}

	/**
	 * Set tavg.
	 *
	 * @param tavg the tavg
	 */
	public void setTavg(Object tavg){
		this.tavg = tavg;
	}

	/**
	 * Get tavg object.
	 *
	 * @return the object
	 */
	public Object getTavg(){
		return tavg;
	}

	/**
	 * Set tmin.
	 *
	 * @param tmin the tmin
	 */
	public void setTmin(Object tmin){
		this.tmin = tmin;
	}

	/**
	 * Get tmin object.
	 *
	 * @return the object
	 */
	public Object getTmin(){
		return tmin;
	}

	/**
	 * Set prcp.
	 *
	 * @param prcp the prcp
	 */
	public void setPrcp(Object prcp){
		this.prcp = prcp;
	}

	/**
	 * Get prcp object.
	 *
	 * @return the object
	 */
	public Object getPrcp(){
		return prcp;
	}

	/**
	 * Set tsun.
	 *
	 * @param tsun the tsun
	 */
	public void setTsun(int tsun){
		this.tsun = tsun;
	}

	/**
	 * Get tsun int.
	 *
	 * @return the int
	 */
	public int getTsun(){
		return tsun;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"date = '" + date + '\'' + 
			",wdir = '" + wdir + '\'' + 
			",wpgt = '" + wpgt + '\'' + 
			",pres = '" + pres + '\'' + 
			",tmax = '" + tmax + '\'' + 
			",snow = '" + snow + '\'' + 
			",wspd = '" + wspd + '\'' + 
			",tavg = '" + tavg + '\'' + 
			",tmin = '" + tmin + '\'' + 
			",prcp = '" + prcp + '\'' + 
			",tsun = '" + tsun + '\'' + 
			"}";
		}
}
