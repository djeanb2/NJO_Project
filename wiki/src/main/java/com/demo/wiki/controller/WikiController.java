package com.demo.wiki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.wiki.model.Wiki;
import com.demo.wiki.service.WikiService;

@RestController
public class WikiController {
	
	@Autowired
	private WikiService wikiService;
	
	@GetMapping("/api/wiki")
	public ResponseEntity<List<Wiki>> list(){
		 List<Wiki> list = wikiService.list();
		 return ResponseEntity.ok().body(list);
	}

}
