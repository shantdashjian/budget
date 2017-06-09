package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.ItemDAO;
import entities.Item;

@RestController
public class ItemControllerImpl implements ItemController {

	@Autowired
	private ItemDAO itemDAO;
	// GET ping
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// GET /user/{userId}/item
	@Override
	@RequestMapping(path = "/user/{userId}/item", method = RequestMethod.GET)
	public Collection<Item> index(HttpServletRequest request, HttpServletResponse response, @PathVariable int userId) {
		return itemDAO.index(userId);
	}

	// GET /user/{userId}/item/{itemId}
	@Override
	@RequestMapping(path = "/user/{userId}/item/{itemId}", method = RequestMethod.GET)
	public Item show(HttpServletRequest request, HttpServletResponse response, @PathVariable int userId, @PathVariable int itemId) {
		return itemDAO.show(userId, itemId);
	}

	// POST /user/{userId}/item
	@Override
	@RequestMapping(path = "/user/{userId}/item", method = RequestMethod.POST)
	public Item create(HttpServletRequest request, HttpServletResponse response, @PathVariable int userId, @RequestBody String itemJson) {
		return itemDAO.create(userId, itemJson);
	}

	@Override
	public Item update(HttpServletRequest request, HttpServletResponse response, int userId, int itemId,
			String itemJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroy(HttpServletRequest request, HttpServletResponse response, int userId, int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
