package com.octest.servlets;

import java.io.IOException;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.octest.entity.Client;
import com.octest.entity.EntityException;
import com.octest.bdd.UserReposytory ;
import com.octest.dao.*;


;


@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UtilisateurDao utilisateurDao ;
    
    //public UserServlet() {
        //super();
        // TODO Auto-generated constructor stub
    //}
	   public void init() throws ServletException {
	        DaoFactory daoFactory = DaoFactory.getInstance();
	        this.utilisateurDao = daoFactory.getUtilisateurDao();
	    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // sans dao
		
		//UserReposytory tableNoms = new UserReposytory();
       // request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs() );
		
		
		//avec dao

        try {
			request.setAttribute("utilisateurs", utilisateurDao.lister());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        this.getServletContext().getRequestDispatcher("/WEB-INF/userForm.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// sans dao
		//Client user = new Client();
		//user.setNom(request.getParameter("nom"));
		//user.setPrenom(request.getParameter("prenom"));
		//user.setEmail(request.getParameter("email"));
		
       // UserReposytory  userRepo = new UserReposytory ();
       // userRepo.ajouterUtilisateur(user);
        
       // request.setAttribute("utilisateurs", userRepo.recupererUtilisateurs());
		
		
		
		// avec dao
		  Client utilisateur = new Client();
	        try {
				utilisateur.setNom(request.getParameter("nom"));
			} catch (EntityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        utilisateur.setPrenom(request.getParameter("prenom"));
	        utilisateur.setEmail(request.getParameter("email"));
	        
	        try {
				utilisateurDao.ajouter(utilisateur);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        try {
				request.setAttribute("utilisateurs", utilisateurDao.lister());
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/userForm.jsp").forward(request, response);
	}

}
