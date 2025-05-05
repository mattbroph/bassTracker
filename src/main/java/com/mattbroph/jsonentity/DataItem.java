package com.mattbroph.jsonentity;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Data item from the Meteostat weather api
 * @author mbrophy
 */
public class DataItem{
	private Object wdir;
	private Object wpgt;
	private Object temp;
	private Object pres;
	private Object snow;
	private int coco;
	private Object wspd;
	private Object dwpt;
	private String time;
	private Object rhum;
	private Object prcp;
	private Object tsun;
	private String cocoDescription;
	private static final Map<Integer, String> WEATHER_CONDITIONS = new HashMap<Integer, String>();

	/**
	 * Instantiates a new Data item.
	 */
// Load the weather conditions map in the constructor
	public DataItem() {
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

	/**
	 * Gets coco description.
	 *
	 * @return the coco description
	 */
	public String getCocoDescription() {
		return cocoDescription;
	}

	/**
	 * Sets coco description.
	 */
	public void setCocoDescription() {

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
	 * Set temp.
	 *
	 * @param temp the temp
	 */
	public void setTemp(Object temp){
		this.temp = temp;
	}

	/**
	 * Get temp object.
	 *
	 * @return the object
	 */
	public Object getTemp(){
		return temp;
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
	 * Set coco.
	 *
	 * @param coco the coco
	 */
	public void setCoco(int coco){
		this.coco = coco;
		setCocoDescription();
	}

	/**
	 * Get coco int.
	 *
	 * @return the int
	 */
	public int getCoco(){
		return coco;
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
	 * Set dwpt.
	 *
	 * @param dwpt the dwpt
	 */
	public void setDwpt(Object dwpt){
		this.dwpt = dwpt;
	}

	/**
	 * Get dwpt object.
	 *
	 * @return the object
	 */
	public Object getDwpt(){
		return dwpt;
	}

	/**
	 * Set time.
	 *
	 * @param time the time
	 */
	public void setTime(String time){
		this.time = time;
	}

	/**
	 * Get time string.
	 *
	 * @return the string
	 */
	public String getTime(){
		return time;
	}

	/**
	 * Set rhum.
	 *
	 * @param rhum the rhum
	 */
	public void setRhum(Object rhum){
		this.rhum = rhum;
	}

	/**
	 * Get rhum object.
	 *
	 * @return the object
	 */
	public Object getRhum(){
		return rhum;
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
	public void setTsun(Object tsun){
		this.tsun = tsun;
	}

	/**
	 * Get tsun object.
	 *
	 * @return the object
	 */
	public Object getTsun(){
		return tsun;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"wdir = '" + wdir + '\'' + 
			",wpgt = '" + wpgt + '\'' + 
			",temp = '" + temp + '\'' + 
			",pres = '" + pres + '\'' + 
			",snow = '" + snow + '\'' + 
			",coco = '" + coco + '\'' + 
			",wspd = '" + wspd + '\'' + 
			",dwpt = '" + dwpt + '\'' + 
			",time = '" + time + '\'' + 
			",rhum = '" + rhum + '\'' + 
			",prcp = '" + prcp + '\'' + 
			",tsun = '" + tsun + '\'' + 
			"}";
		}
}
