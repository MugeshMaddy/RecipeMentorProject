package com.recipementor.project.RecipeMentorProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="recipementor")
public class RecipeMentor {
	@Id
	private int id;
	@NotBlank(message="recipe name cannot be blank")
	private String name;
	private String category;
	private String type;
	private String cooktime;
	private String instructions;
	private String ingredients;
	public RecipeMentor()
	{
		
	}
	public RecipeMentor(int id, String name, String category,
			String type, String cooktime, String instructions, String ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.type = type;
		this.cooktime = cooktime;
		this.instructions = instructions;
		this.ingredients = ingredients;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCooktime() {
		return cooktime;
	}
	public void setCooktime(String cooktime) {
		this.cooktime = cooktime;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public boolean isVeg(RecipeMentor recipe)
	{
		if(recipe.type.equals("Veg") && recipe.name.toLowerCase().contains("chicken"))
		{
			return false;
		}
		else if(recipe.type.equals("Veg") && recipe.name.toLowerCase().contains("fish"))
		{
			return false;
		}
		else if(recipe.type.equals("Veg") && recipe.name.toLowerCase().contains("mutton"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	
}
