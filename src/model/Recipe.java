package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	private Integer id;
	
	@XmlElement
	private String name;
	
	@Column(name="db_name")
	private String db_name;
	
	@XmlElement
	private Double kcal = new Double(0);
	
	@XmlElement
	private Integer num_servings;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(schema="recipe_service")
	@XmlElement
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	@XmlElement
	private String preparation_instructions;
	
	@XmlElement
	private String author;	

	public Integer getId() { return id; }
	public String getName() { return name; }
	public String getDb_name() { return db_name; }
	public Double getKcal() { return kcal; }
	public Integer getNum_servings() { return num_servings; }
	public List<Ingredient> getIngredients() { return new ArrayList<Ingredient>(ingredients); }
	public String getPreparation_instructions() { return preparation_instructions; }
	public String getAuthor() { return author; }
	
	public void setId(Integer id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setDb_name(String db_name) { this.db_name = db_name; }
	public void setKcal(Double kcal) { this.kcal = kcal; }
	public void setNum_servings(Integer num_servings) { this.num_servings = num_servings; }
	public void setPreparation_instructions(String preparation_instructions) { this.preparation_instructions = preparation_instructions; }
	public void setAuthor(String author) { this.author = author; }
	
	public boolean addProduct(Ingredient p){
		boolean added = ingredients.add(p);
		if (added)
			kcal += p.getKcal();
		return added;
	}
	
	public boolean removeProduct(Ingredient p){
		boolean removed = ingredients.remove(p);
		if (removed)
			kcal -= p.getKcal();
		return removed;
	}
	
	@Override
	public String toString() {
		return this.getId() + ") " + this.name;
	}
}
