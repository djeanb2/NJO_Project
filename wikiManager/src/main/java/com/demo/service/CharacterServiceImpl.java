package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Character;
import com.demo.repository.CharacterRepository;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService{

	@Autowired
	private CharacterRepository characterRepository;
	
	@Override
	public Character createCharacter(Character character) {
		return characterRepository.save(character);
	}
	
	@Override
	public Character updateCharacter(Character character) {
		Optional<Character> characterDb = this.characterRepository.findById(character.getId());
		
		if(characterDb.isPresent()) {
			Character characterUpdate = characterDb.get();
			characterUpdate.setId(character.getId());
			characterUpdate.setName(character.getName());
			characterUpdate.setAbility(character.getAbility());
			characterUpdate.setUniverse(character.getUniverse());
			characterRepository.save(characterUpdate);
			return characterUpdate;
		}
		else {
			throw new ResourceNotFoundException("Character was not found with ID: "+ character.getId());
		}
		
		
	}

	@Override
	public List<Character> getAllCharacters() {
		return this.characterRepository.findAll();
		/*List<Character> characterList = new ArrayList<>();
		this.characterRepository.findAll().forEach(character -> characterList.add(character));
		return characterList;*/
	}

	@Override
	public Character getCharacterById(long characterId) {
		
		Optional<Character> characterDb = this.characterRepository.findById(characterId);
				
		if(characterDb.isPresent()) {
			return characterDb.get();
		}
		else {
			throw new ResourceNotFoundException("Character was not found with ID: "+ characterId);
		}
	}
	
	@Override
	public boolean saveOrUpdateCharacter(Character character) {
		Character updateChar = characterRepository.save(character);
		
		if(characterRepository.findById(updateChar.getId())!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCharacter(long characterId) {

		this.characterRepository.deleteById(characterId);
		if(characterRepository.findById(characterId) != null) {
			return true;
		}

		return false;
		
	}
	
	@Override
	public void deleteACharacter(long characterId) {
		Optional<Character> characterDb = this.characterRepository.findById(characterId);
		
		if(characterDb.isPresent()) {
			this.characterRepository.delete(characterDb.get());
		}
		else {
			throw new ResourceNotFoundException("Character was not found with ID: "+ characterId);
		}
		
	}
	
	

}
