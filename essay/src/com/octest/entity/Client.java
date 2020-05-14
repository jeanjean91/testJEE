package com.octest.entity;

public class Client {
	
	
		 private int id;
		 private String nom;
		 private String prenom;
		 private String email;

		 
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		  public void setNom(String nom) throws EntityException {
		        if (nom.length() > 10) {
		            throw new EntityException("Le nom est trop grand ! (10 caractères maximum)");
		        }
		        else {
		            this.nom = nom; 
		        }
		    }
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		 

}
