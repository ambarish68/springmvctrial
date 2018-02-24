package com.arao.common.user;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.arao.common.address.*;

@Entity
@Table(name = "Address", catalog = "user")
public class UserAddress {
	
	private long AddressId;
	private AddressType AddressType;
	private User user;
	
	private String address;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AddressId", unique = true, nullable = false)
	public long getAddressId() {
		return AddressId;
	}

	public void setAddressId(long addressId) {
		AddressId = addressId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AddressTypeId", nullable = false)
	public AddressType getAddressType() {
		return AddressType;
	}

	public void setAddressType(AddressType addressType) {
		AddressType = addressType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "address", unique = false, nullable = false, length = 1000)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
