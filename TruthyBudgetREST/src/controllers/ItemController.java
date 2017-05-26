package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Item;

public interface ItemController {
//    GET /user/{userId}/item
    public Collection<Item> index(HttpServletRequest request, HttpServletResponse response, int userId);
    
//    GET /user/{userId}/item/{itemId}
    public Item show(HttpServletRequest request, HttpServletResponse response, int userId, int itemId);
    
//    POST /user/{userId}/item
    public Item create(HttpServletRequest request, HttpServletResponse response, int userId, String itemJson);
    
//    PUT /user/{userId}/item/{itemId}
    public Item update(HttpServletRequest request, HttpServletResponse response, int userId, int itemId, String itemJson);
    
//    DELETE /user/{userId}/item/{itemId}
    public Boolean destroy(HttpServletRequest request, HttpServletResponse response, int userId, int itemId);
}