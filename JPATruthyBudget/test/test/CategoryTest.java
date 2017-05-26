package test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Category;
import entities.Item;
import entities.User;

public class CategoryTest {
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private Category category = null;

	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("TruthyBudget");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}
	
//	@Test
//	public void test() {
//	  boolean pass = true;
//	  assertEquals(pass, true);
//	}
	
	@Test
	public void test_category_mappings() {
		category = entityManager.find(Category.class, 1);    

	    assertThat(category,
	        allOf(
	        	hasProperty("id", is(1)),	           
	        	hasProperty("name", is("food")),	           
	        	hasProperty("description", is("I need this to stay alive"))
	      )  
	     );
	}
	
}
