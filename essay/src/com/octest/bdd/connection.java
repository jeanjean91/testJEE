package com.octest.bdd;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import com.octest.entity.Client;




public class connection {
	
	private Connection connexion;
	
	 public List<Client> recupererUsers() {
	        List<Client> utilisateurs = new ArrayList<Client>();
	        Statement statement = createStatement();
	        ResultSet resultat = null;
	        
	        connect();

	        
	        
	        try {
	        	
	     
	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT  * FROM ;");

	            // Récupération des données
	            while (resultat.next()) {
	            	
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                String email = resultat.getString("email");
	                
	                Client utilisateur = new Client();
	                utilisateur.setNom(nom);
	                utilisateur.setPrenom(prenom);
	                utilisateur.setEmail(email);
	                
	            }
	        } catch (SQLException e) {
	        } finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
	        }
	        
	        return utilisateurs;
	    }
	    
	 private Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	private void connect(){

        // https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
        // auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver class via Class.forName

        // register JDBC driver, optional since java 1.6
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        // auto close connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:8888/testJEE", "root", "password")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	 public void ajouterUtilisateur(Client utilisateur) {
		 connect();
	        
	       try {
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO user(id,nom, prenom,email,password,actif) VALUES(?, ?);");
	            
	            preparedStatement.setString(1, utilisateur.getNom());
	           preparedStatement.setString(2, utilisateur.getPrenom());
	            preparedStatement.setString(3, utilisateur.getEmail());
	           
	            
	            
	           preparedStatement.executeUpdate();
	       } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
