package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController()
@RequestMapping("/api/v1/identity")

public class IdentityCardController {
	@Autowired
	IdentityCardService identityCardService;

	@PostMapping("/")
	public ResponseEntity<Object>  createIdentityCard(@RequestBody IdentityCard identityCard) {
		if (identityCardService.validateData(identityCard)) {
			return ResponseEntity.badRequest().body("All data are mandatory");
		}
		if (identityCardService.getIdentityCardByCardNumber(identityCard.getIdentityCardNumber())!=null) {
			return ResponseEntity.badRequest().body("Identity Card Number Already Exists");
		}
		identityCardService.createIdentityCard(identityCard);
		return new ResponseEntity<>("IdentityCard created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getIdentityCardID(@PathVariable("id") Long identityCardId) {
		IdentityCard identityCard = identityCardService.getIdentityCardById(identityCardId);
		if(identityCard==null) {
			return new ResponseEntity<>("Identity Card with id : "+identityCardId+"does not exist", HttpStatus.BAD_REQUEST);
		}else {
			return ResponseEntity.ok(identityCard);
		}
	}


	@GetMapping("/")
	public ResponseEntity<Object> getIdentityCards() {
		return ResponseEntity.ok(identityCardService.getIdentityCards());	
	}
	@DeleteMapping("/{id}")

	public ResponseEntity<Object> deleteBulletinById(@PathVariable("id") Long identityCardId) {
		if(identityCardService.getIdentityCardById(identityCardId)==null) {
			return new ResponseEntity<>("IdentityCard with id : "+identityCardId+"does not exist", HttpStatus.BAD_REQUEST);

		}else {
			identityCardService.deleteIdentityCard(identityCardId);
			return ResponseEntity.ok("IdentityCard deleted successfully !");

		}
	}

	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> updateIdentityCard(@RequestBody IdentityCard identityCard,@PathVariable("id") Long identityCardId) {
		if (identityCardService.validateData(identityCard)) {
			return ResponseEntity.badRequest().body("All data are mandatory");
		}
		if(identityCardService.getIdentityCardById(identityCardId)==null) {
			return new ResponseEntity<>("IdentityCard with id : "+identityCardId+"does not exist", HttpStatus.BAD_REQUEST);

		}
		identityCardService.createIdentityCard(identityCard);
		return ResponseEntity.ok("IdentityCard updated successfully !");
 
	}
}
