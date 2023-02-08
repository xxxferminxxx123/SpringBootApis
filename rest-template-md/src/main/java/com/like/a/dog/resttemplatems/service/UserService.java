package com.like.a.dog.resttemplatems.service;


import java.util.Arrays;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.like.a.dog.resttemplatems.dto.UserDTO;
import com.like.a.dog.resttemplatems.configuration.RestTemplateConfig;


import org.springframework.web.client.RestTemplate;

import java.util.List;



@Service
@RequiredArgsConstructor

public class UserService {
	
    @Value("${sping.external.service.base-url}")
    private String basePath;

  
	  private  RestTemplate restTemplate;

    
    public List<UserDTO> getUsers(){
        UserDTO[] response = restTemplate.getForObject(basePath+"/users", UserDTO[].class);
        return Arrays.asList(response);
    }
	public void saveUser(UserDTO user) {
        restTemplate.postForObject(basePath+"/users", user, UserDTO.class);
	}
	
	public void updateUser(Integer id,UserDTO user) {
        restTemplate.put(basePath+"/users/"+id, user);

	}
	public void deleteUser(Integer id) {
        restTemplate.delete(basePath+"/users/"+id);

	}
 
}
