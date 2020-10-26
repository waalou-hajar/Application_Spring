package org.sid.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3 ,max = 15)
	private String name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;
	private Boolean malade;
	@DecimalMin("4")
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(Long id, @Size(min = 3, max = 15) String name, Date dateNaissance, Boolean malade, int score) {
		super();
		this.id = id;
		this.name = name;
		this.dateNaissance = dateNaissance;
		this.malade = malade;
		this.score = score;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Boolean getMalade() {
		return malade;
	}
	public void setMalade(Boolean malade) {
		this.malade = malade;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", dateNaissance=" + dateNaissance + ", malade=" + malade
				+ ", score=" + score + "]";
	}
	
	

}
