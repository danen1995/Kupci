package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.klase.Korisnik;
import com.example.demo.klase.Potrosac;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.repository.PotrosacRepository;

@RestController
public class Controller {
	
	  @Autowired
	  KorisnikRepository korisnikRepository;
	  @Autowired
	  PotrosacRepository potrosacRepository;
	  

	  @GetMapping("/logovanje")
	  public @ResponseBody Korisnik logovanje(@RequestParam(value="user") String user, @RequestParam(value = "pass") String pass) {
		  return korisnikRepository.logovanje(user, pass);
	  }
	  
	  @GetMapping("/vratiSvePotrosace")
	  public @ResponseBody List<Potrosac> vratiSvePotrosace() {
		  return potrosacRepository.vratiSvePotrosace();
	  }
	  

}