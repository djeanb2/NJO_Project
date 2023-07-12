package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Character;
import com.demo.service.CharacterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WikiController {
	
	@Autowired
	private CharacterService characterService;
	
	/*
	 * ***************************************
	 * FOR NORMAL BACKEND
	 * ***************************************
	 * */
	
	
	@GetMapping("/wiki")
	public ResponseEntity<List<Character>> getAllCharacters() {
		return ResponseEntity.ok().body(characterService.getAllCharacters());
	}
	
	@GetMapping("/wiki/{id}")
	public ResponseEntity<Character> getCharacterById(@PathVariable long id) {
		return ResponseEntity.ok().body(characterService.getCharacterById(id));
	}
	
	@PostMapping("/wiki")
	public ResponseEntity<Character> createCharacter(@RequestBody Character character){
		return ResponseEntity.ok().body(this.characterService.createCharacter(character));
	}
	
	@PutMapping("/wiki/{id}")
	public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character){
		character.setId(id);
		return ResponseEntity.ok().body(this.characterService.updateCharacter(character));
	}
	
	@DeleteMapping("/wiki/{id}")
	public HttpStatus deleteACharacter(@PathVariable Long id){
		this.characterService.deleteACharacter(id);
		return HttpStatus.OK;
	}
	
	

}
