package com.arao.common.address;

import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AddressType", catalog = "Address")
public class AddressType implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AddressTypeId", unique = true, nullable = false)
	private long AddressTypeId;
	
	@Column(name = "name", unique = false, nullable = false, length = 100)
	private String Name;

	public long getAddressTypeId() {
		return AddressTypeId;
	}

	public void setAddressTypeId(long addressTypeId) {
		AddressTypeId = addressTypeId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
