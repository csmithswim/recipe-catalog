package csmithswim.recipecatalogservice.repositories;

import csmithswim.recipecatalogservice.businessLayer.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {


}
