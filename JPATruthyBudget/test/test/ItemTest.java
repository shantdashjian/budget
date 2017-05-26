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

public class ItemTest {
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private Item item = null;

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
	public void test_item_mappings() {
		item = entityManager.find(Item.class, 1);    

	    assertThat(item,
	        allOf(
	        	hasProperty("id", is(1)),	           
	        	hasProperty("name", is("Raw Goat Milk")),	           
	        	hasProperty("value", is(70.0)),          
	        	hasProperty("notes", is("Healthy food"))      
	      )  
	     );
	}
	
	@Test
	public void test_item_temporal() {
		item = entityManager.find(Item.class, 1);    
		assertEquals("2017-05-25 03:14:07.0", item.getDate().toString());
	}
	
	@Test
	public void test_user_association() {
	     item = entityManager.find(Item.class, 1);
	     User user = item.getUser();
	     assertEquals(1, user.getId());
	     assertEquals("shaundashjian@gmail.com", user.getEmail());
	     assertEquals("password", user.getPassword());
	     
	  }
	
	@Test
	public void test_category_association() {
	     item = entityManager.find(Item.class, 1);
	     Category category = item.getCategory();
	     assertEquals(1, category.getId());
	     assertEquals("food", category.getName());
	     assertEquals("I need this to stay alive", category.getDescription());
	     
	  }
	
}
