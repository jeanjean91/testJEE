package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.octest.entity.Article;
import com.octest.entity.EntityException;
import com.octest.dao.*;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  ArticleDAO articleDao ;
       
    
    //public ArticleServlet() {
    //    super();
        // TODO Auto-generated constructor stub
   // }

	
	 public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.articleDao = daoFactory.getArticleDAO();
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        try {
			request.setAttribute("articles", articleDao.lister());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.getServletContext().getRequestDispatcher("/WEB-INF/boutique.jsp").forward(request, response);
        
        
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		  Article article = new Article();
		  		
	        article.setNom(request.getParameter("nom"));
	        article.setImage(request.getParameter("image"));
	        article.setDescription(request.getParameter("description"));
	        article.setDescription(request.getParameter("prix"));
	        
	        try {
	        	articleDao.ajouter(article);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        try {
				request.setAttribute("articles", articleDao.lister());
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
      this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutArticle.jsp").forward(request, response);
	}

	}


