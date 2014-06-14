package uj.ii.dao;

import java.util.List;

import uj.ii.transferobjects.Publication;

public interface PublicationsDAOInterface {
	List<Publication> viewPublications(String owner);
	List<Publication> viewAllPublications();
	boolean addPublication(String name, String description, String owner);
	
}
