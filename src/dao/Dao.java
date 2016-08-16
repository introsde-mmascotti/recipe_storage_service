package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Recipe;

public class Dao {
	
	private static Dao dao = null;
	private Logger logger;
	private EntityManager em;
		
	private Dao(String logger_name, String persitence_unit) {
		logger = LogManager.getFormatterLogger(logger_name);
		
		Map<String, String> props = new HashMap<String, String>();
		
		String uri_str = System.getenv("DATABASE_URL");
		URI uri = null;
		try {
			uri = new URI(uri_str);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
				
		String username = uri.getUserInfo().split(":")[0];
		String password = uri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + uri.getHost() + ':' + uri.getPort() + uri.getPath();
		
		props.put("javax.persistence.jdbc.url", dbUrl);
		props.put("javax.persistence.jdbc.user", username);
		props.put("javax.persistence.jdbc.password", password);
		
		EntityManagerFactory f = Persistence.createEntityManagerFactory(persitence_unit, props);
		
		em = f.createEntityManager();
	}
	
	public static Dao getDao() {
		if (dao == null)
			dao = new Dao("RecipeStorageService", "recipestorage");
		return dao;
	}

	public Recipe saveRecipe(Recipe r, boolean update){
		EntityTransaction tx = em.getTransaction();
		
		r.setDb_name(removeAccents(r.getName()));
		
		tx.begin();
		if (update){
			r = em.merge(r);
			logger.info("Recipe updated: " + r.toString());			
		}
		else {
			em.persist(r);
			logger.info("New recipe saved: " + r.toString());
		}
		tx.commit();
		return r;
	}
		
	public void deleteRecipe(Recipe r){
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(r);
		em.remove(r);
		tx.commit();
		logger.info("Removed: " + r.toString());
	}
	
	public Recipe getById(Integer id){
		Recipe ret = em.find(Recipe.class, id);
		if (ret != null)
			logger.info("Retrieved recipe with id=" + id + ": " + ret.toString());
		else
			logger.info("No recipe with id=" + id);
		return ret;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipe> searchRecipe(String term, String author){
		String query = "Select r" +
						"from Recipe r " +
						"where (r.db_name like :noacc_term or lower(r.name) like :term) ";
		
		if (author != null)
			query += "and r.author = :author";
		
		Query q = em.createQuery(query);
		
		String noacc_term = removeAccents(term);
		q.setParameter("noacc_term", "%" + noacc_term + "%");
		q.setParameter("term", "%" + term.toLowerCase() + "%");
		
		if (author != null)
			q.setParameter("author", author);
		
		List<Recipe> ret = q.getResultList();
		
		logger.info("Searching for : " + term + " without accent: "  + noacc_term);
		logger.info("Found %d recipes", ret.size());
		logger.debug(ret);
		
		return ret;
	}
	
	private String removeAccents(String txt){
		txt = Normalizer.normalize(txt, Normalizer.Form.NFD);
		txt = txt.toLowerCase();
		txt = txt.replaceAll("\\p{InCombiningDiacriticalMarks}+","");
		return txt;
	}
}
