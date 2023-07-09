package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{

}
