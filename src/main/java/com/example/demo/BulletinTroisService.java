package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class BulletinTroisService {
	
	@Autowired
	BulletinTroisRepo bulletinTroisRepo;
	
	BulletinTrois createBulletin(BulletinTrois bulletinTrois) {
		return bulletinTroisRepo.save(bulletinTrois);
	}
	
	BulletinTrois getBulletinById(Long bulletinTroisId) {
		return bulletinTroisRepo.findById(bulletinTroisId).orElse(null);
	}
	
	List<BulletinTrois> getBulletins() {
		return bulletinTroisRepo.findAll();
	}
	
	void deleteBulletin(Long bulletinTroisId) {
		bulletinTroisRepo.deleteById(bulletinTroisId);
	}
	
	
    public boolean validateData(BulletinTrois bulletinTrois) {
        if (bulletinTrois.getFirstName() == null || bulletinTrois.getLastName() == null
                || bulletinTrois.getInformation() == null || bulletinTrois.getDateCreation() == null) {
            return true;
        }
        return false;
    }

	

	

}
