package com.foodbook.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class SHAConvertorService implements HashConvertorService{

	private MessageDigest md;
	
	public SHAConvertorService() {
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public String convert(String toConvert) {
		MessageDigest md;
		byte[] digest;
		StringBuilder hexString;
		
		try {
			md = (MessageDigest) this.md.clone();
			md.update(toConvert.getBytes());
			digest = md.digest();
			
			 hexString = new StringBuilder();
             for (byte b : digest) {
               hexString.append(String.format("%02X", 0xFF & b));
             }
             
             return hexString.toString();			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
