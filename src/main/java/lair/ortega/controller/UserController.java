package lair.ortega.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lair.ortega.db.model.UserModel;
import lair.ortega.service.IService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private IService<UserModel> userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserModel> list(HttpServletResponse response) {
		response.setStatus(200);
		return userService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserModel find(@PathVariable String id, HttpServletResponse response) {
		response.setStatus(200);
		return userService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public UserModel add(@RequestBody UserModel user, HttpServletResponse response) {
		response.setStatus(201);
		return userService.save(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public UserModel edit(@RequestBody UserModel user, HttpServletResponse response) {
		response.setStatus(202);
		return userService.update(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public UserModel delete(@PathVariable String id, HttpServletResponse response) {
		response.setStatus(204);
		userService.delete(id);
		return null;
	}
}
