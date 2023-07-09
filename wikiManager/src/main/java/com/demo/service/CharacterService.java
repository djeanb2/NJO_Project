package com.demo.service;

import java.util.List;

import com.demo.model.Character;

public interface CharacterService {
	
	Character createCharacter(Character character);
	
	Character updateCharacter(Character character);
	
	List<Character> getAllCharacters();
	
	Character getCharacterById(long characterId);
	
	boolean deleteCharacter(long id);
	
	boolean saveOrUpdateCharacter(Character character);

}
