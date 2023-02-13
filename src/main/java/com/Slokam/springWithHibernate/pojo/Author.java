package com.Slokam.springWithHibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Author {
	
	@Id
	@GeneratedValue
	private int aid;
	private String aname;
	private int anum;
	
	
	@Override
	public String toString() {
		return "aid=" + aid + ", aname=" + aname + ", anum=" + anum ;
	}
	
	

}
