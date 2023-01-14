package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface IdentityCardRepo extends JpaRepository<IdentityCard, Long>{
 Optional<IdentityCard> findByIdentitycardnumber(String id);
	

}
