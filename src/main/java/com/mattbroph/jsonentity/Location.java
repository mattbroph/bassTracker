package com.mattbroph.jsonentity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The location object returned from the GeoNames location api
 *
 * @author mbrophy
 */
public class Location {

	@JsonProperty("postalCodes")
	private List<PostalCodes> postalCodes;

	/**
	 * Gets postal codes.
	 *
	 * @return the postal codes
	 */
	public List<PostalCodes> getPostalCodes() {
		return postalCodes;
	}

	/**
	 * Sets postal codes.
	 *
	 * @param postalCodes the postal codes
	 */
	public void setPostalCodes(List<PostalCodes> postalCodes) {
		this.postalCodes = postalCodes;
	}
}