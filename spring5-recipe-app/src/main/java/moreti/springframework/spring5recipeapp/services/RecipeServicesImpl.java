package moreti.springframework.spring5recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import moreti.springframework.spring5recipeapp.domain.Recipe;
import moreti.springframework.spring5recipeapp.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServicesImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServicesImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
