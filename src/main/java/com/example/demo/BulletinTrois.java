package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bulletin_trois")
public class BulletinTrois {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "identity_card_id")
    private IdentityCard identityCard;
    private String firstName;
    private String lastName;
    private String information;
    private Date dateCreation;


    //Constructors
	public BulletinTrois(Long id, IdentityCard identityCard, String firstName, String lastName, String information,
			Date dateCreation) {
		super();
		this.id = id;
		this.identityCard = identityCard;
		this.firstName = firstName;
		this.lastName = lastName;
		this.information = information;
		this.dateCreation = dateCreation;
	}


	public BulletinTrois() {
		super();
	}
    //getters and setters


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public IdentityCard getIdentityCard() {
		return identityCard;
	}


	public void setIdentityCard(IdentityCard identityCard) {
		this.identityCard = identityCard;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getInformation() {
		return information;
	}


	public void setInformation(String information) {
		this.information = information;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}



	//ToString
	
	@Override
	public String toString() {
		return "BulletinTrois [id=" + id + ", identityCard=" + identityCard + ", firstName=" + firstName + ", lastName="
				+ lastName + ", information=" + information + ", dateCreation=" + dateCreation + "]";
	}
	
	
}
