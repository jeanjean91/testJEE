package com.octest.dao;

import java.util.List;

import com.octest.entity.Article;


public interface ArticleDAO {
	void ajouter( Article article ) throws DaoException;
    List<Article> lister() throws DaoException;
	List<Article> Single(Object id) throws DaoException;

}
