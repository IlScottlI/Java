package com.codingdojo.johnson.se.services;

import java.util.Date;

public class Entry {
    private String location;
    private int amount;
    private String sign;
    private Date timestamp;
    private String output;
    public Entry( String location, int amount, String sign) {
        this.location = location;
        this.amount = amount;
        this.sign = sign;
        this.timestamp = new Date();
        String str;
		if(this.getSign().equals("success")) {
			str = "earned ";
		} else {
			str = "lost ";
		}
        this.output = "You entered a " + this.getLocation() + " and " + str + this.getAmount() + " gold.  (" + this.timestamp + ") ";
    }

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String string() {
		String str;
		if(this.getSign().equals("success")) {
			str = "earned ";
		} else {
			str = "lost ";
		}
		return "You entered a " + this.getLocation() + " and " + str + this.getAmount() + " gold.  (" + this.timestamp + ") ";
	}
  

}
