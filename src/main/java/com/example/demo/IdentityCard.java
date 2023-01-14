package com.example.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "identity_card")
public class IdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String identitycardnumber;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String fatherName;
    private String motherName;
    private Date identityCreationDate;
    private String address;
    
    //Constructors

	public IdentityCard(Long id, String identityCardNumber, String firstName, String lastName, Date birthDate,
			String fatherName, String motherName, Date identityCreationDate, String address) {
		super();
		this.id = id;
		this.identitycardnumber = identityCardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.identityCreationDate = identityCreationDate;
		this.address = address;
	}
	public IdentityCard() {
		super();
	}
	
	//ToString

	@Override
	public String toString() {
		return "IdentityCard [id=" + id + ", identityCardNumber=" + identitycardnumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDate=" + birthDate + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", identityCreationDate=" + identityCreationDate + ", address=" + address + "]";
	}
	
	
    //getters and setters

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentityCardNumber() {
		return identitycardnumber;
	}
	public void setIdentityCardNumber(String identityCardNumber) {
		this.identitycardnumber = identityCardNumber;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Date getIdentityCreationDate() {
		return identityCreationDate;
	}
	public void setIdentityCreationDate(Date identityCreationDate) {
		this.identityCreationDate = identityCreationDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}



	
    
}
