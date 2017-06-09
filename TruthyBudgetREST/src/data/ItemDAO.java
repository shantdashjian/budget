package data;

import java.util.List;

import entities.Item;

public interface ItemDAO {

	public List<Item> index(int userId);
	
	public Item show(int userId, int itemId);
	
	public Item create(int userId, String itemJson);
	
	public Item update(int userId, int itemId, String itemJson);
	
	public Boolean destroy(int userId, int itemId);
}
