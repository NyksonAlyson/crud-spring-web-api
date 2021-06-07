package com.nykdev.crud.model.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nykdev.crud.model.User;
import com.nykdev.crud.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<User>> listaUser(){
		List<User>listaUser = userRepository.findAll();
		return ResponseEntity.ok(listaUser);
	}

	@GetMapping(path = "cod{id}")
	public Optional<User> findById(@PathVariable Long id){
		return userRepository.findById(id);
	}
	
	@GetMapping(value = "buscarUserid")
	@ResponseBody
	public ResponseEntity<User>buscaruserid(@RequestParam(name="iduser")Long iduser){
				User usuarios= userRepository.findById(iduser).get();
				return new ResponseEntity<User>(usuarios, HttpStatus.OK);
	}
	
	/*
	 * @PostMapping(value = "salvar")
	 * 
	 * @ResponseBody public ResponseEntity<User> salvar(@RequestBody User user){
	 * User usuario = userRepository.save(user); return new
	 * ResponseEntity<User>(usuario, HttpStatus.CREATED); }
	 */
	
	@PostMapping(value = "salvar")
	public @ResponseBody User insert(@RequestBody @Valid User user){
		return userRepository.save(user);
		
	}
	
	@DeleteMapping(value = "delete")
	@ResponseBody
	public void ExcluirProduto(@RequestParam Long id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping
	public User alterarUser(@Valid User user) {
		userRepository.save(user);
		return user;	
	}
	
	@GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<User>>buscarPorNome(@RequestParam (name= "name")String name){
			
		List<User> usuario = userRepository.buscarPorNome(name);
		return new ResponseEntity<List<User>>(usuario,HttpStatus.OK);
	}
	
}
