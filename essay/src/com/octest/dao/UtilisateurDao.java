package com.octest.dao;
import java.util.List;
import com.octest.entity.Client;

public interface UtilisateurDao {
	void ajouter( Client client ) throws DaoException;
    List<Client> lister() throws DaoException;
}
