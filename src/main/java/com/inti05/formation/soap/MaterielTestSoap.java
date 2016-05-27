package com.inti05.formation.soap;

import javax.xml.ws.Endpoint;


public class MaterielTestSoap {

	public static void main(String[] args) {
		
		String url ="http://localhost:8091/";
		Endpoint.publish(url, new MaterielSoap());
		System.out.println(url);

	}

}
