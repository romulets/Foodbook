package com.foodbook.storage;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum ServerPath {

	USER,
	RECIPE,
	DEFAULT;
	
	
	public String getIdentifier(){
		switch(this) {
		case USER:
			return "users";
		case RECIPE:
			return "recipes";
		case DEFAULT:
			return "defaults";
		default:
			return "etc";
		}
	}
	
	public Path getServerPath() {
		return Paths.get(String.format("images/%s/", getIdentifier()));
	}
	
	public Path getBrowserPath() {
		return Paths.get(String.format("/Foodbook/resources/images/%s/", getIdentifier()));
	}
	
}
