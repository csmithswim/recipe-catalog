package csmithswim.recipecatalogservice.businessLayer.controllers;
import csmithswim.recipecatalogservice.businessLayer.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import csmithswim.recipecatalogservice.repositories.RecipeRepository;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("/{id}")
    public @ResponseBody Recipe getRecipe(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe newRecipe) {
        return new ResponseEntity<>(repository.save(newRecipe), HttpStatus.CREATED);
    }
}
