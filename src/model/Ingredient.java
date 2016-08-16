package model;

import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	Integer id;
	
	@XmlElement
	String name;
	
	@XmlElement
	String brand;
	
	@XmlElement
	Double kcal;
	
	@XmlElement
	Double serving_size_quantity;
	
	@XmlElement
	String serving_size_unit;
	
	@XmlElement
	Integer serving_weight;

	public Integer getId() { return id;	}
	public String getName() { return name;}
	public String getBrand() { return brand; }
	public Double getKcal() { return kcal; }
	public Double getServing_size_quantity() { return serving_size_quantity; }
	public String getServing_size_unit() { return serving_size_unit; }
	public Integer getServing_weight() { return serving_weight; }
	public void setName(String name) { this.name = name; }
	
	public void setBrand(String brand) { this.brand = brand; }
	public void setKcal(Double kcal) { this.kcal = kcal; }
	public void setServing_size_quantity(Double serving_size_quantity) { this.serving_size_quantity = serving_size_quantity; }
	public void setServing_size_unit(String serving_size_unit) {  this.serving_size_unit = serving_size_unit; }
	public void setServing_weight(Integer serving_weight) { this.serving_weight = serving_weight; }
	
	 @Override
	public String toString() {
		 StringBuilder ret = new StringBuilder();
		 DecimalFormat df = new DecimalFormat("0.###");
		 
		 ret.append(String.format("%s (%s)\n", name, brand));
		 
		 if (serving_weight != null)
			 ret.append(String.format("%s %s (%dg) = %.2f kcal\n", df.format(serving_size_quantity), serving_size_unit,serving_weight ,kcal));
		 else
			 ret.append(String.format("%s %s = %.2f kcal\n", df.format(serving_size_quantity), serving_size_unit,kcal));
		 return ret.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
