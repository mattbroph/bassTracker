package com.mattbroph.jsonentity;

import java.util.List;

/**
 * The type Meteo stat.
 */
public class MeteoStat{
	private List<DataItem> data;
	private Meta meta;

	/**
	 * Set data.
	 *
	 * @param data the data
	 */
	public void setData(List<DataItem> data){
		this.data = data;
	}

	/**
	 * Get data list.
	 *
	 * @return the list
	 */
	public List<DataItem> getData(){
		return data;
	}

	/**
	 * Set meta.
	 *
	 * @param meta the meta
	 */
	public void setMeta(Meta meta){
		this.meta = meta;
	}

	/**
	 * Get meta meta.
	 *
	 * @return the meta
	 */
	public Meta getMeta(){
		return meta;
	}

	@Override
 	public String toString(){
		return 
			"MeteoStat{" + 
			"data = '" + data + '\'' + 
			",meta = '" + meta + '\'' + 
			"}";
		}
}