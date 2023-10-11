package com.recipementor.project.RecipeMentorProject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.recipementor.project.RecipeMentorProject.Exceptions.ResourceNotFoundException;
import com.recipementor.project.RecipeMentorProject.RecipeRepository.RecipeRepository;

import com.recipementor.project.RecipeMentorProject.Entity.RecipeMentor;
import com.recipementor.project.RecipeMentorProject.Exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/recipementor")
public class RecipeController {
	@Autowired
	private RecipeRepository recipeRepository;
////	@GetMapping("{id}")
////	public Optional<RecipeMentor> getRecipe(@PathVariable("id") Integer id)
////	{
////		if(this.recipeRepository.existsById(id))
////		{
////			return this.recipeRepository.findById(id);
////		}
//		else
//		{
//			throw new ResourceNotFoundException(id+"doesn't exist");
//		}
		//return this.recipeRepository.findById(id);	
	//}
	@GetMapping 
	public List<RecipeMentor> getAllRecipe()
	{
		return this.recipeRepository.findAll();
	}
	@PostMapping
	public ResponseEntity<String> postRecipe(@Valid @RequestBody RecipeMentor recipes)
	{
		if(recipes.isVeg(recipes))
		{
			this.recipeRepository.save(recipes);
		} 
		else
		{
			//System.out.println("Non veg dish can't be added to Veg type");
			return ResponseEntity.badRequest().body("Non-Veg dish cannot be added to Veg Type");
		}
			return ResponseEntity.ok("Recipe added");
	}
	@DeleteMapping("{id}")
	public void deleteRecipe(@PathVariable("id") Integer id)
	{
		if(this.recipeRepository.existsById(id))
		{
			this.recipeRepository.deleteById(id);
		}
		else
		{
			throw new ResourceNotFoundException(id+"doesn't exist");
		}
		
	}
	@PutMapping("{id}")
	public void updateRecipe(@PathVariable("id") Integer id,@RequestBody RecipeMentor recipes)
	{
		if(this.recipeRepository.existsById(id))
		{
			this.recipeRepository.save(recipes);
		}
		else
		{
			throw new ResourceNotFoundException(id+"doesn't exist");
		}
		
	}
	@GetMapping("/name")
	public ResponseEntity<List<RecipeMentor>> findByName(@RequestParam String name)
	{
		return new ResponseEntity<List<RecipeMentor>>(recipeRepository.findByName(name),HttpStatus.OK);
	}
	
	
}
