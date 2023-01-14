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
@RequestMapping("/api/v1/bulletin")
public class BulletinTroisController {

	@Autowired
	BulletinTroisService bulletinTroisService;
	@Autowired
	IdentityCardService identityCardService;

	@PostMapping("/")
	public ResponseEntity<Object>  createBulletin(@RequestBody BulletinTrois bulletinTrois) {
		
		if (bulletinTrois.getIdentityCard()!=null&& identityCardService.getIdentityCardById(bulletinTrois.getIdentityCard().getId())==null) {
			return ResponseEntity.badRequest().body("Identity Card Not Found");
		}
		if (bulletinTroisService.validateData(bulletinTrois)) {
			return ResponseEntity.badRequest().body("All data are mandatory");
		}
		bulletinTroisService.createBulletin(bulletinTrois);
		return new ResponseEntity<>("Bulletin created successfully", HttpStatus.CREATED);
	}
	@GetMapping("/{id}")

	public ResponseEntity<Object> getBulletinById(@PathVariable("id") Long BulletinTrois) {
		BulletinTrois bTrois = bulletinTroisService.getBulletinById(BulletinTrois);
		if(bTrois==null) {
			return new ResponseEntity<>("bulletin with id : "+BulletinTrois+"does not exist", HttpStatus.BAD_REQUEST);
		}else {
			return ResponseEntity.ok(bTrois);
		}
	}


	@GetMapping("/")
	public ResponseEntity<Object> getBulletins() {
		return ResponseEntity.ok(bulletinTroisService.getBulletins());	
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBulletinById(@PathVariable("id") Long BulletinTrois) {
		if(bulletinTroisService.getBulletinById(BulletinTrois)==null) {
			return new ResponseEntity<>("bulletin with id : "+BulletinTrois+"does not exist", HttpStatus.BAD_REQUEST);

		}else {
			bulletinTroisService.deleteBulletin(BulletinTrois);
			return ResponseEntity.ok("Bulletin deleted successfully !");

		}
	}

	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> updateBulletin(@RequestBody BulletinTrois bulletinTrois,@PathVariable("id") Long BulletinTroisId) {
		if (bulletinTroisService.validateData(bulletinTrois)) {
			return ResponseEntity.badRequest().body("All data are mandatory");
		}
		if(bulletinTroisService.getBulletinById(BulletinTroisId)==null) {
			return new ResponseEntity<>("bulletin with id : "+BulletinTroisId+"does not exist", HttpStatus.BAD_REQUEST);

		}
		bulletinTroisService.createBulletin(bulletinTrois);
		return ResponseEntity.ok("Bulletin updated successfully !");
 
	}



}
