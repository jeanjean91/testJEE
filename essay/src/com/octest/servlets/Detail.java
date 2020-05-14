package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.octest.entity.Article;

import com.octest.entity.EntityException;
import com.octest.dao.*;

/**
 * Servlet implementation class Detail
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  ArticleDAO articleDao ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public Detail() {
     //  super();
        // TODO Auto-generated constructor stub
   // }
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.articleDao = daoFactory.getArticleDAO();
    }
    //public void doGet(HttpServletRequest request, HttpServletResponse response)
    //	    throws IOException{
    	//String paramAuteur = request.getParameter( "id" );
    	//String message = "Transmission de variables : OK ! " + paramAuteur;
    	//request.setAttribute( "test", message );
    	//    }

	/**
	 * @param id 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 String id = null;
			String paramArticle = request.getParameter(id );
				request.setAttribute("produit", articleDao.Single(paramArticle));
				//sSystem.out.println(id);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	
		//String message = "Transmission de variables : OK !";
		//request.setAttribute( "test", message );
	       
	        this.getServletContext().getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
