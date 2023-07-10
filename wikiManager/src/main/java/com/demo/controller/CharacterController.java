package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.model.Character;
import com.demo.service.CharacterService;

@Controller
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	
	@GetMapping({"/", "/viewCharacterList"})
	public String viewAllCharacters(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("characterList", characterService.getAllCharacters());
		model.addAttribute("message", message);
		return "ViewCharacterList";
	}
	
	@GetMapping("/addCharacter")
	public String addCharacter(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("character", new Character());
		model.addAttribute("message", message);
		return "AddCharacter";
	}
	
	@PostMapping("/saveCharacter")
	public String saveCharacter(Character character, RedirectAttributes redirectAttributes) {
		if(characterService.saveOrUpdateCharacter(character)) {
			redirectAttributes.addFlashAttribute("message", "Character Saved Successfully");
			return "redirect:/viewCharacterList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Save Failure");
		return "redirect:/addCharacter";
	}
	
	@GetMapping("/editCharacter/{id}")
	public String editCharacter(@PathVariable Long id, Model model) {
		model.addAttribute("character", characterService.getCharacterById(id));
		return "EditCharacter";
	}
	
	@PostMapping("/editSaveCharacter")
	public String editSaveCharacter(Character character, RedirectAttributes redirectAttributes) {
		if(characterService.saveOrUpdateCharacter(character)) {
			redirectAttributes.addFlashAttribute("message", "Character Saved Successfully");
			return "redirect:/viewCharacterList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Save Failure");
		return "redirect:/editCharacter/" + character.getId();
	}
	
	@GetMapping("/deleteCharacter/{id}")
	public String deleteCharacter(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if(characterService.deleteCharacter(id)) {
			redirectAttributes.addFlashAttribute("message", "Character Deleted Successfully");
			//return "redirect:/wiki";
		}
		else {
			redirectAttributes.addFlashAttribute("message", "Delete Failure");
		}
		
		return "redirect:/viewCharacterList";
	}
	
	
	/*@GetMapping("/wiki")
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
	public HttpStatus deleteCharacter(@PathVariable Long id){
		this.characterService.deleteCharacter(id);
		return HttpStatus.OK;
	}*/
	
	

}
