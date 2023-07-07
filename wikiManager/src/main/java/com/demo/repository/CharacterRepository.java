package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.model.Character;

public interface CharacterRepository extends JpaRepository<Character, Long>{

}
