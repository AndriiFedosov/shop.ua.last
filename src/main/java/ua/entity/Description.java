package ua.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Description extends AbstractEntity{
	
	private String size;
	private String color;
	private String material;
	@OneToMany(mappedBy = "description")
	private List<Production>products = new ArrayList<Production>();
	
	public Description() {
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public List<Production> getProducts() {
		return products;
	}

	public void setProducts(List<Production> products) {
		this.products = products;
	}

	public String getPresentation(){
		return getColor()+", "+getMaterial()+", "+getSize()+" мм ";
	}
	
}
