package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.entity.Client;

public class essay {
	
	
	 @SuppressWarnings({ "null", "unused" })
	public List<Client> recupererUtilisateurs() {
	        List<Client> utilisateurs = new ArrayList<Client>();
	        ResultSet resultat = null;

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:mysql://localhost:8889/essayJEE\", \"root\", \"root";
        if ( connectionUrl != null) {
            System.out.println("Connected to the database!");
        }else { System.out.println("connexion failed!");}
        
        
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM client";
            stmt.executeQuery(SQL);
            
            
            

            // Iterate through the data in the result set and display it.
            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                
                Client utilisateur = new Client();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);
                
                utilisateurs.add(utilisateur);
            }
            
             
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        return utilisateurs;
	 }
	 
	 }


