package com.recipementor.project.RecipeMentorProject.RecipeRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipementor.project.RecipeMentorProject.Entity.RecipeMentor;

public interface RecipeRepository extends JpaRepository<RecipeMentor,Integer>
{
	List<RecipeMentor> findByName(String name);
}
