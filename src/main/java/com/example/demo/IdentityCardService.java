package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class IdentityCardService {

	
	@Autowired
	IdentityCardRepo identityCardRepo;
	
	IdentityCard createIdentityCard(IdentityCard identityCard) {
		return identityCardRepo.save(identityCard);
	}
	
	IdentityCard getIdentityCardById(Long identityCard) {
		return identityCardRepo.findById(identityCard).orElse(null);
	}
	
	List<IdentityCard> getIdentityCards() {
		return identityCardRepo.findAll();
	}
	
	void deleteIdentityCard(Long identityCard) {
		identityCardRepo.deleteById(identityCard);
	}
	IdentityCard getIdentityCardByCardNumber(String identityCardNumber) {
		return identityCardRepo.findByIdentitycardnumber(identityCardNumber).orElse(null);
	}
	
	
    public boolean validateData(IdentityCard bulletinTrois) {
        if (bulletinTrois.getFirstName() == null || bulletinTrois.getLastName() == null
                || bulletinTrois.getIdentityCardNumber() == null
                || bulletinTrois.getFatherName() == null
                || bulletinTrois.getMotherName() == null
                || bulletinTrois.getBirthDate() == null
                || bulletinTrois.getIdentityCreationDate() == null
                || bulletinTrois.getAddress() == null


        		) {
            return true;	
        }
        return false;
    }

}
