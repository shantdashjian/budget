package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Item;
import entities.User;

@Transactional
public class ItemDAOImpl implements ItemDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Item> index(int userId) {
		String query = "SELECT item FROM Item item where item.user.id = :id";
		return em.createQuery( query, Item.class).setParameter("id", userId).getResultList();
	}

	@Override
	public Item show(int userId, int itemId) {
		return em.find(Item.class, itemId);
	}

	@Override
	public Item create(int userId, String itemJson) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Item mappedItem = mapper.readValue(itemJson, Item.class);
			User user = em.find(User.class, userId);
			
			mappedItem.setUser(user);
			
			em.persist(mappedItem);
			em.flush();
			return mappedItem;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Item update(int userId, int itemId, String itemJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroy(int userId, int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
