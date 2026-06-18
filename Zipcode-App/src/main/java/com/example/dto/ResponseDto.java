package com.example.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDto {

	private String country;
	
	@JsonProperty("country abbreviation")
	private String countryabbrevation;
	
	@JsonProperty("post code")
	private String postCode;
	
	@JsonProperty("places")
	private List<PlaceDto> places;
	
}
