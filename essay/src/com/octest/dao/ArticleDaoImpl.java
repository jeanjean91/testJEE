package com.octest.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.octest.entity.EntityException ;
import com.octest.entity.Article;
import com.octest.entity.Client;

public class ArticleDaoImpl implements ArticleDAO{

	private DaoFactory daoFactory;

	ArticleDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Article article) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO article(id,nom, image,description,prix) VALUES(?,?,?,?, ?);");
            preparedStatement.setInt(1, article.getId());
            preparedStatement.setString(2, article.getNom());
            preparedStatement.setString(3, article.getImage());
            preparedStatement.setString(4, article.getDescription());
            preparedStatement.setInt(5, article.getPrix());

            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }

    }

    @Override
    public List<Article> lister() throws DaoException {
        List<Article> articles = new ArrayList<Article>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id,nom, image,description,prix FROM article;");

            while (resultat.next()) {
            	int id = resultat.getInt("id");
                String nom = resultat.getString("nom");
                String image = resultat.getString("image");
                String description = resultat.getString("description");
                int prix = resultat.getInt("prix");

                Article article = new Article();
                article.setId(id);
                article.setNom(nom);
                article.setImage(image);
                article.setDescription(description);
                article.setPrix(prix);

                articles.add(article);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return articles;
    }
    
    
    
   

	@Override
	public List<Article> Single(Object id) throws DaoException {
		
		
		 List<Article> produit = new ArrayList<Article>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT id,nom, image,description,prix FROM article WHERE id = id;");

	            while (resultat.next()) {
	            	//int id1 = resultat.getInt("id");
	                String nom = resultat.getString("nom");
	                String image = resultat.getString("image");
	                String description = resultat.getString("description");
	                int prix = resultat.getInt("prix");

	                Article prod = new Article();
	               // article.setId(id1);
	                prod.setNom(nom);
	                prod.setImage(image);
	                prod.setDescription(description);
	                prod.setPrix(prix);

	                produit.add(prod);
	            }
	        } catch (SQLException e) {
	            throw new DaoException("Impossible de communiquer avec la base de données");
	        }
	        finally {
	            try {
	                if (connexion != null) {
	                    connexion.close();  
	                }
	            } catch (SQLException e) {
	                throw new DaoException("Impossible de communiquer avec la base de données");
	            }
	        }
	        return produit;
		
	}

}
