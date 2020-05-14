package com.octest.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
private String resultat;
	
	public void verifierIdentiants(HttpServletRequest request) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		if (pass.equals(login + "123")) {
			resultat ="vous ete connecte!";
		}
		else {
			resultat ="identifiants incorrects!";}
	}

	public String getResultats() {
		return resultat;
	}

	public void setResultats(String resultat) {
		this.resultat = resultat;
	}

}
