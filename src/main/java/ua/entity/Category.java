package ua.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Category extends AbstractEntity{
	
	private String nameCategory;
	private String model;
	@OneToMany(mappedBy = "category")
	private List<Production>products = new ArrayList<Production>();
	
	public Category() {
	
	}
	
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<Production> getProducts() {
		return products;
	}
	public void setProducts(List<Production> products) {
		this.products = products;
	}

	public String getPresentation(){
		return getNameCategory()+", "+getModel();
	}
	
	
}
