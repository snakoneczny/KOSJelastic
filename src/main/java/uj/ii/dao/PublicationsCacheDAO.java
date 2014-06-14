package uj.ii.dao;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uj.ii.transferobjects.Publication;
import net.spy.memcached.MemcachedClient;

public class PublicationsCacheDAO implements PublicationsDAOInterface {
	
	private PublicationsDAO dao;
	private int port = 11211;
	private MemcachedClient client = null;
	private String address = "memcached-kosiiuj.jelastic.dogado.eu";

	
	public PublicationsCacheDAO( PublicationsDAO dao ) {
		this.dao = dao;
		try {
			client = new MemcachedClient(new InetSocketAddress(address,port));
			Logger logger = Logger.getLogger(this.getClass().getName()); 
			logger.info("Created new publications cache DAO");		
		} catch (Exception e) {
			Logger.getLogger(MemcachedClient.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public List<Publication> viewPublications( String owner ) {
		List<Publication> result = (List<Publication>) client.get(owner);
		if ( result == null ) {
			Logger.getLogger(this.getClass().getName()).info("No publications for user " + owner + ", caching entries from database." );
			result = dao.viewPublications(owner);
			client.set(owner, 3600, result);
		}
		else {
			Logger.getLogger(this.getClass().getName()).info("Publications for user " + owner + "loaded from cache." );
		}
		return result;
	}
	
	public List<Publication> viewAllPublications() {
		List<Publication> result = (List<Publication>) client.get("all");
		if ( result == null ) {
			Logger.getLogger(this.getClass().getName()).info("No list of all publications cached, loading from database." );
			result = dao.viewAllPublications();
			client.set("all", 3600, result);
		}
		else {
			Logger.getLogger(this.getClass().getName()).info("Loaded all publications from cache." );
		}
		return result;
	
	}
	
	public boolean addPublication(String name, String description, String owner) {
		boolean added = dao.addPublication(name, description, owner);
		if ( added == true ){
			client.delete("all");
			client.delete(owner);
			Logger.getLogger(this.getClass().getName()).info("Adding new publication, clearing corresponding cache." );
		}
		return added;
	}
	
	
	
	
	
	
	
}
