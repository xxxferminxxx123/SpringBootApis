package com.like.a.dog.resttemplatems.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.like.a.dog.resttemplatems.dto.UserDTO;
import com.like.a.dog.resttemplatems.service.UserService;

import com.like.a.dog.resttemplatems.service.UserService;



@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
	
		
	private final UserService userService = new UserService();
	
	
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>getAll(){	
		return new ResponseEntity<>(userService.getUsers(),	HttpStatus.OK);
	}
	


	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody UserDTO dto){
		userService.saveUser(dto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void UpdateUser(@PathVariable("id")Integer id,@RequestBody UserDTO user) {
		userService.updateUser(id, user);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id")Integer id) {
		userService.deleteUser(id);
	}
	
	
}
