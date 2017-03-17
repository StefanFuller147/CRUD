package com.sd.characterData;

public class Operator {
	private String id;
	private String firstName;
	private String lastName;
	private String nationality;
	private String side;
	private String codeName;
	private String picture;

	

	public Operator(String id, String firstName, String lastName, String nationality, String side, String codeName, String picture) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.side = side;
		this.codeName = codeName;
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Operator() {
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}


	public String getCTU() {
		return nationality;
	}

	public void setCTU(String cTU) {
		nationality = cTU;
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nationality="
				+ nationality + ", side=" + side + ", codeName=" + codeName + ", picture=" + picture + "]";
	}

}
