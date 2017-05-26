package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Item;

@RestController
public class ItemControllerImpl implements ItemController {

	// GET ping
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@Override
	public Collection<Item> index(HttpServletRequest request, HttpServletResponse response, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item show(HttpServletRequest request, HttpServletResponse response, int userId, int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item create(HttpServletRequest request, HttpServletResponse response, int userId, String itemJson) {
		// TODO Auto-generated method stub
		return null;
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
