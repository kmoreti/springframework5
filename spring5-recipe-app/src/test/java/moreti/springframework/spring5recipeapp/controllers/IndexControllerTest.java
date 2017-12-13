package moreti.springframework.spring5recipeapp.controllers;

import moreti.springframework.spring5recipeapp.repository.RecipeRepository;
import moreti.springframework.spring5recipeapp.services.RecipeService;
import moreti.springframework.spring5recipeapp.services.RecipeServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.*;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getIndexPage() throws Exception {

        String indexPage = "index";
        IndexController indexController = new IndexController(recipeService);

        assertEquals(indexPage, indexController.getIndexPage(model));

        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }

}