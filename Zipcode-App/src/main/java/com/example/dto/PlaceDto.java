package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceDto {

	@JsonProperty("place name")
	private String placeName;
	private String longitude;
	private String latitude;
	private String state;
	
	@JsonProperty("state abbreviation")
	private String ststeAbbreviation;
	
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStsteAbbreviation() {
		return ststeAbbreviation;
	}
	public void setStsteAbbreviation(String ststeAbbreviation) {
		this.ststeAbbreviation = ststeAbbreviation;
	}
	
	
}
