package com.arao.common.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.beans.PropertyChangeSupport;

import javax.persistence.Table;


import javax.persistence.Id;


@Entity
@Table(name = "Details", catalog = "user")
public class User implements java.io.Serializable{

    private PropertyChangeSupport changes = new PropertyChangeSupport(this); 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int Id;
	private String Name;
	private String Password;
	private String EmailId;
	private boolean IsMale;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	@Column(name = "name", unique = false, nullable = false, length = 256)
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	@Column(name = "password", unique = false, nullable = false, length = 256)
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	@Column(name = "emailid", unique = true, nullable = false, length = 256)
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		this.EmailId = emailId;
	}
	@Column(name = "gender", unique = false, nullable = false, length = 20)
	public boolean isIsMale() {
		return IsMale;
	}
	public void setIsMale(boolean isMale) {
		this.IsMale = isMale;
	}

}
