package com.arao.common.payment;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Method", catalog = "Payment")
public class PaymentMethod {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PaymentMethodId", unique = true, nullable = false)
	public int getPaymentMethodId() {
		return PaymentMethodId;
	}
	public void setPaymentMethodId(int paymentMethodId) {
		PaymentMethodId = paymentMethodId;
	}
	private int PaymentMethodId;
	private String Name;
	private String Description;
	
	
	@Column(name = "Name", unique = true, nullable = false)
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Column(name = "Description", unique = true, nullable = false)
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

}
