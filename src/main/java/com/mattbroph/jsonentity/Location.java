package com.mattbroph.jsonentity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Location {

	@JsonProperty("postalCodes")
	private List<PostalCodes> postalCodes;

	public List<PostalCodes> getPostalCodes() {
		return postalCodes;
	}

	public void setPostalCodes(List<PostalCodes> postalCodes) {
		this.postalCodes = postalCodes;
	}
}