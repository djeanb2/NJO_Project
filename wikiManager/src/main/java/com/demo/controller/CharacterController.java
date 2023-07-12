package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.model.Character;
import com.demo.service.CharacterService;

@Controller
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	
	/*
	 * For JSP  
	 */
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
	
	/* JSP END */
	
	
	

}
