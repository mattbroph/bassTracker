package com.mattbroph.jsonentity;

/**
 * The type Data item.
 */
public class DataItem{
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
