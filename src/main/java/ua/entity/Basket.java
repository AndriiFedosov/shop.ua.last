package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Basket extends AbstractEntity{
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Production production;
	@ManyToOne(fetch=FetchType.LAZY)
	private Person person;
	
	private String dataship;
	private boolean is_deleted;


	
	public Basket() {
	
	}

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDataship() {
		return dataship;
	}

	public void setDataship(String dataship) {
		this.dataship = dataship;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}


}
