package com.sprphnx.restws.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="CUSTOMERS")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUST_ID")
	private long custId;

	@Column(name="CUST_NAME")
	private String custName;

	@Column(name="INSERTED_BY")
	private String insertedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="INSERTED_DATE")
	private Date insertedDate;

	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	//bi-directional many-to-one association to CustomerContact
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<CustomerContact> customerContacts;

	public Customer() {
	}

	public long getCustId() {
		return this.custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getInsertedBy() {
		return this.insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public Date getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public List<CustomerContact> getCustomerContacts() {
		return this.customerContacts;
	}

	public void setCustomerContacts(List<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	public CustomerContact addCustomerContact(CustomerContact customerContact) {
		getCustomerContacts().add(customerContact);
		customerContact.setCustomer(this);

		return customerContact;
	}

	public CustomerContact removeCustomerContact(CustomerContact customerContact) {
		getCustomerContacts().remove(customerContact);
		customerContact.setCustomer(null);

		return customerContact;
	}

}