package com.ponpes.dahlanikhsan.backend.model;

import java.util.Date;

import com.ponpes.dahlanikhsan.backend.domain.example.Person.Role;

public class MatPel {

	private long id;
	private String kode1;
	private String kode2;
	private String description;
	private String notes;
	private Date created;
	private Date lastModified;
	private String modifiedBy;
	
	
	private boolean randomBoolean;
	
	public enum Role {
		DESIGNER, DEVELOPER, MANAGER, TRADER, PAYMENT_HANDLER, ACCOUNTANT
	}
	public Role role;
	

	public String getInitials() {
		return (kode1.substring(0, 1) + description.substring(0, 1))
				.toUpperCase();
	}

	public boolean getRandomBoolean() {
		return randomBoolean;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKode1() {
		return kode1;
	}

	public void setKode1(String kode1) {
		this.kode1 = kode1;
	}

	public String getKode2() {
		return kode2;
	}

	public void setKode2(String kode2) {
		this.kode2 = kode2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public boolean isRandomBoolean() {
		return randomBoolean;
	}

	public void setRandomBoolean(boolean randomBoolean) {
		this.randomBoolean = randomBoolean;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}