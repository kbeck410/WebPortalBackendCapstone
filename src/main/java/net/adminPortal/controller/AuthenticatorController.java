package net.adminPortal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.adminPortal.entity.Authenticator;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AuthenticatorController {
	
	@GetMapping(path="/basicauth")
	public Authenticator authenticatorBean() {return new Authenticator("You are authenticated");}
}
