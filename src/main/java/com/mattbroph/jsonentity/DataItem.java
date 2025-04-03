package com.mattbroph.jsonentity;

import java.util.HashMap;
import java.util.Map;

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

	public String getCocoDescription() {
		return cocoDescription;
	}

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

	public void setWdir(Object wdir){
		this.wdir = wdir;
	}

	public Object getWdir(){
		return wdir;
	}

	public void setWpgt(Object wpgt){
		this.wpgt = wpgt;
	}

	public Object getWpgt(){
		return wpgt;
	}

	public void setTemp(Object temp){
		this.temp = temp;
	}

	public Object getTemp(){
		return temp;
	}

	public void setPres(Object pres){
		this.pres = pres;
	}

	public Object getPres(){
		return pres;
	}

	public void setSnow(Object snow){
		this.snow = snow;
	}

	public Object getSnow(){
		return snow;
	}

	public void setCoco(int coco){
		this.coco = coco;
		setCocoDescription();
	}

	public int getCoco(){
		return coco;
	}

	public void setWspd(Object wspd){
		this.wspd = wspd;
	}

	public Object getWspd(){
		return wspd;
	}

	public void setDwpt(Object dwpt){
		this.dwpt = dwpt;
	}

	public Object getDwpt(){
		return dwpt;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setRhum(Object rhum){
		this.rhum = rhum;
	}

	public Object getRhum(){
		return rhum;
	}

	public void setPrcp(Object prcp){
		this.prcp = prcp;
	}

	public Object getPrcp(){
		return prcp;
	}

	public void setTsun(Object tsun){
		this.tsun = tsun;
	}

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
