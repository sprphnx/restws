package com.sprphnx.restws.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;


/**
 * The persistent class for the CUSTOMER_CONTACTS database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_CONTACTS")
@NamedQuery(name="CustomerContact.findAll", query="SELECT c FROM CustomerContact c")
public class CustomerContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUST_CONT_ID")
	private long custContId;

	@Column(name="CUST_CONT_ADDRESS")
	private String custContAddress;

	@Column(name="CUST_CONT_EMAIL")
	private String custContEmail;

	@Column(name="CUST_CONT_MOB_NUM")
	private String custContMobNum;

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

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUST_ID")
	@JsonBackReference
	private Customer customer;

	public CustomerContact() {
	}

	public long getCustContId() {
		return this.custContId;
	}

	public void setCustContId(long custContId) {
		this.custContId = custContId;
	}

	public String getCustContAddress() {
		return this.custContAddress;
	}

	public void setCustContAddress(String custContAddress) {
		this.custContAddress = custContAddress;
	}

	public String getCustContEmail() {
		return this.custContEmail;
	}

	public void setCustContEmail(String custContEmail) {
		this.custContEmail = custContEmail;
	}

	public String getCustContMobNum() {
		return this.custContMobNum;
	}

	public void setCustContMobNum(String custContMobNum) {
		this.custContMobNum = custContMobNum;
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

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}