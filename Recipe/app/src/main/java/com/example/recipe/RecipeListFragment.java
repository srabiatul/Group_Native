package com.example.recipe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipeListFragment extends Fragment {

    public class Recipe {
        private String name;
        private String time;
        private String ingredients;
        private String instructions;


        public Recipe(String name, String time, String ingredients, String instructions) {
            this.name = name;
            this.time = time;
            this.ingredients = ingredients;
            this.instructions = instructions;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }

        public String getIngredients() {
            return ingredients;
        }

        public String getInstructions() {
            return instructions;
        }
    }

    private ArrayList<Recipe> getFamilyRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Spaghetti Bolognese", "45 mins",
                "\n-1 pound (450g) spaghetti\n" +
                "- 1 pound (450g) ground beef\n" +
                "- 1 can (14 oz/400g) tomato sauce\n" +
                "- 1 onion, finely chopped\n" +
                "- 2 cloves garlic, minced\n" +
                "- 1 tablespoon olive oil\n" +
                "- 1 teaspoon dried oregano\n" +
                "- 1 teaspoon dried basil\n" +
                "- Salt and pepper to taste\n" +
                "- Grated Parmesan cheese (optional)",
                "\n1. Cook spaghetti according to package instructions. Drain and set aside.\n" +
                "2. In a large skillet, heat olive oil over medium heat. Add chopped onions and minced garlic. Sauté until onions are translucent.\n" +
                "3. Add ground beef to the skillet and cook until browned, breaking it apart with a spatula.\n" +
                "4. Stir in tomato sauce, oregano, basil, salt, and pepper. Simmer for 15-20 minutes, allowing the flavors to meld.\n" +
                "5.Serve the Bolognese sauce over the cooked spaghetti. Optionally, garnish with grated Parmesan cheese."));
        recipes.add(new Recipe("Vegetarian Stir Fry", "30 mins",
                "\n- Assorted vegetables (e.g., broccoli, bell peppers, carrots, snap peas), sliced\n" +
                "- 1/4 cup soy sauce\n" +
                "- 2 tablespoons vegetable oil\n" +
                "- 1 teaspoon sesame oil (optional)\n" +
                "- 2 cloves garlic, minced\n" +
                "- 1 teaspoon ginger, grated\n" +
                "- Cooked rice or noodles for servinge",
                "\n1. Heat vegetable oil in a wok or large skillet over medium-high heat.\n" +
                "2. Add minced garlic and grated ginger, sauté for 1-2 minutes until fragrant.\n" +
                "3. Add sliced vegetables to the wok and stir-fry for 5-7 minutes until they are tender-crisp.\n" +
                "4. Pour soy sauce (and optional sesame oil) over the vegetables, tossing to combine evenly. Cook for an additional 2-3 minutes.\n" +
                "6. Serve the vegetable stir fry over cooked rice or noodles."));
        recipes.add(new Recipe("Chicken Alfredo Pasta", "40 mins",
                "\n- 1 pound (450g) fettuccine pasta\n" +
                "- 1 pound (450g) boneless, skinless chicken breasts, cut into bite-sized pieces\n" +
                "- 2 cups (480ml) Alfredo sauce (store-bought or homemade)\n" +
                "- 1/2 cup (120ml) heavy cream\n" +
                "- 1/2 cup (50g) grated Parmesan cheese\n" +
                "- Salt and pepper to taste\n" +
                "- Fresh parsley, chopped, for garnish",
                "\n1. Cook fettuccine pasta according to package instructions. Drain and set aside.\n" +
                "2. Season chicken pieces with salt and pepper. In a large skillet, cook the chicken until browned and cooked through.\n" +
                "3. Reduce heat to low and add Alfredo sauce, heavy cream, and grated Parmesan cheese to the skillet. Stir until the sauce is creamy and well combined.\n" +
                "4. Add the cooked fettuccine pasta to the skillet, tossing to coat the pasta evenly with the Alfredo sauce.\n" +
                "5.Serve the Chicken Alfredo Pasta hot, garnished with chopped fresh parsley."));
        return recipes;
    }
    private ArrayList<Recipe> getDessertRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Chocolate Cake", "60 mins",
                "\n- 2 cups (240g) all-purpose flour\n" +
                "- 2 cups (400g) granulated sugar\n" +
                "- 3/4 cup (75g) unsweetened cocoa powder\n" +
                "- 2 teaspoons baking powder\n" +
                "- 1 1/2 teaspoons baking soda\n" +
                "- 1 teaspoon salt\n" +
                "- 1 cup (240ml) milk\n" +
                "- 1/2 cup (120ml) vegetable oil\n" +
                "- 2 large eggs\n" +
                "- 2 teaspoons vanilla extract\n" +
                "- 1 cup (240ml) boiling water",
                "\n1. Preheat the oven to 350°F (175°C). Grease and flour two 9-inch round cake pans.\n" +
                "2. In a large bowl, sift together flour, sugar, cocoa powder, baking powder, baking soda, and salt.\n" +
                "3. Add milk, vegetable oil, eggs, and vanilla extract to the dry ingredients. Mix until well combined.\n" +
                "4. Stir in boiling water until the batter is smooth. The batter will be thin.\n" +
                "5. Pour the batter evenly into the prepared cake pans. Bake for 30-35 minutes or until a toothpick inserted into the center comes out clean.\n" +
                "6. Allow the cakes to cool in the pans for 10 minutes, then transfer them to a wire rack to cool completely.\n" +
                "7. Once cooled, you can frost and decorate the cakes as desired."));
        recipes.add(new Recipe("Fruit Salad", "15 mins",
                "\n- Assorted fruits (e.g., strawberries, kiwi, pineapple, grapes), chopped\n" +
                "- 2 tablespoons honey",
                "\n1. Wash and chop the assorted fruits into bite-sized pieces.\n" +
                "2. In a large bowl, combine the chopped fruits.\n" +
                "3. Drizzle honey over the fruits and gently toss until the fruits are evenly coated.\n" +
                "4. Refrigerate for at least 30 minutes before serving to allow the flavors to meld."));
        recipes.add(new Recipe("Ice Cream", "120 mins",
                "\n- 2 cups (480ml) whole milk\n" +
                "- 1 cup (200g) granulated sugar\n" +
                "- 2 cups (480ml) heavy cream\n" +
                "- 1 tablespoon vanilla extract", "\n1. In a mixing bowl, whisk together whole milk and granulated sugar until the sugar is dissolved.\n" +
                "2. Stir in heavy cream and vanilla extract until well combined.\n" +
                "3. Pour the mixture into an ice cream maker and churn according to the manufacturer's instructions.\n" +
                "4. Once the ice cream reaches a soft-serve consistency, transfer it to a lidded container and freeze for at least 2 hours or until firm.\n" +
                "5.Scoop and serve the homemade ice cream as desired."));
        return recipes;
    }

    private ArrayList<Recipe> getSnackRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Popcorn", "10 mins",
                "\n- 1/2 cup (100g) popcorn kernels\n" +
                "- 2 tablespoons butter, melted\n" +
                "- Salt to taste",
                "\n1. Place a large, heavy-bottomed pot on the stove over medium heat.\n" +
                "2. Add the popcorn kernels to the pot, cover with a lid, and wait for the popcorn to start popping. Shake the pot occasionally to ensure even popping.\n" +
                "3. Once the popping slows down, remove the pot from the heat.\n" +
                "4. Drizzle melted butter over the popped popcorn and toss to coat evenly.\n" +
                "5. Sprinkle salt to taste and toss again.\n" +
                "6. Serve immediately and enjoy your homemade popcorn!"));
        recipes.add(new Recipe("Guacamole", "20 mins",
                "\n- 3 ripe avocados\n" +
                "- 1 medium tomato, diced\n" +
                "- 1/2 onion, finely chopped\n" +
                "- 1 clove garlic, minced\n" +
                "- 1 lime, juiced\n" +
                "- Salt and pepper to taste",
                "\n1. Cut the avocados in half, remove the pits, and scoop the flesh into a bowl.\n" +
                "2. Mash the avocado with a fork or potato masher until it reaches your desired consistency.\n" +
                "3. Add diced tomato, chopped onion, minced garlic, and lime juice to the mashed avocado.\n" +
                "4. Season with salt and pepper to taste.\n" +
                "5. Mix all the ingredients until well combined.\n" +
                "6. Cover the guacamole with plastic wrap, pressing it directly onto the surface to prevent browning.\n" +
                "7. Refrigerate for at least 15 minutes before serving."));
        recipes.add(new Recipe("Cheese and Crackers", "5 mins",
                "\n- Assorted cheeses (cheddar, Swiss, etc.), sliced or cubed\n" +
                "- Crackers of your choice",
                "\n1. Arrange the cheese slices or cubes on a serving plate.\n" +
                "2. Place the crackers next to the cheese on the plate.\n" +
                "3. Serve the cheese and crackers as a delightful and quick snack."));
        return recipes;
    }

    private ArrayList<Recipe> getOthersRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Pasta Carbonara", "30 mins",
                "\n- 1 pound (450g) pasta (such as spaghetti or fettuccine)\n" +
                "- 2 large eggs\n" +
                "- 1 cup (100g) grated Parmesan cheese\n" +
                "- 1/2 pound (225g) bacon, diced\n" +
                "- Salt and black pepper to taste\n" +
                "- Chopped parsley for garnish (optional)",
                "\n1. Cook the pasta according to the package instructions. Drain and set aside.\n" +
                "2. In a bowl, whisk together eggs and grated Parmesan cheese. Set aside.\n" +
                "3. In a large skillet over medium heat, cook the diced bacon until crispy.\n" +
                "4. Add the cooked pasta to the skillet with the bacon. Toss to combine.\n" +
                "5. Remove the skillet from heat and quickly stir in the egg and Parmesan mixture. The heat from the pasta will cook the eggs and create a creamy sauce.\n" +
                "6. Season with salt and black pepper to taste. Garnish with chopped parsley if desired.\n" +
                "7. Serve immediately."));
        recipes.add(new Recipe("Vegetable Stir Fry", "25 mins",
                "\n- Assorted vegetables (e.g., broccoli, bell peppers, carrots, snap peas), sliced\n" +
                "- 2 tablespoons soy sauce\n" +
                "- 1 tablespoon vegetable oil\n" +
                "- 1 teaspoon grated ginger\n" +
                "- 2 cloves garlic, minced\n" +
                "- Cooked rice for serving",
                "\n1. Heat vegetable oil in a wok or large skillet over medium-high heat.\n" +
                "2. Add minced garlic and grated ginger, sauté for 1-2 minutes until fragrant.\n" +
                "3. Add sliced vegetables to the wok and stir-fry for 5-7 minutes until they are tender-crisp.\n" +
                "4. Pour soy sauce over the vegetables, tossing to combine evenly. Cook for an additional 2-3 minutes.\n" +
                "5. Serve the vegetable stir fry over cooked rice"));
        recipes.add(new Recipe("Steak with Mushrooms", "40 mins",
                "\n- 2 steaks of your choice (e.g., sirloin or ribeye)\n" +
                "- Salt and black pepper to taste\n" +
                "- 2 tablespoons vegetable oil\n" +
                "- 8 oz (225g) mushrooms, sliced\n" +
                "- 2 cloves garlic, minced\n" +
                "- 1 tablespoon butter\n" +
                "- Chopped fresh parsley for garnish",
                "\n1. Season the steaks with salt and black pepper on both sides.\n" +
                "2. In a large skillet, heat vegetable oil over medium-high heat.\n" +
                "3. Cook the steaks to your desired doneness, approximately 4-5 minutes per side for medium-rare.\n" +
                "4. Remove the steaks from the skillet and let them rest.\n" +
                "5. In the same skillet, add sliced mushrooms and minced garlic. Cook until the mushrooms are golden brown.\n" +
                "6. Add butter to the skillet and stir until melted.\n" +
                "6. Serve the steaks topped with the sautéed mushrooms. Garnish with chopped fresh parsley."));
        return recipes;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);

        ListView listView = view.findViewById(R.id.recipeListView);

        String category = getArguments().getString("category", "");
        String query = getArguments().getString("query", "");

        ArrayList<Recipe> recipes;
        switch (category) {
            case "family":
                recipes = getFamilyRecipes();
                break;
            case "snack":
                recipes = getSnackRecipes();
                break;
            case "dessert":
                recipes = getDessertRecipes();
                break;
            case "others":
                recipes = getOthersRecipes();
                break;
            case "search":
                recipes = performSearch(query);
                break;
            default:
                recipes = new ArrayList<>();
                break;
        }
        String[] recipeArray = new String[recipes.size()];
        for (int i = 0; i < recipes.size(); i++) {
            recipeArray[i] = recipes.get(i).getName() + " - Time: " + recipes.get(i).getTime();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, recipeArray);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Recipe selectedRecipe = recipes.get(position);
                showFullRecipeDetails(selectedRecipe);
            }
        });

        return view;
    }

    private ArrayList<Recipe> performSearch(String query) {
        ArrayList<Recipe> searchResults = new ArrayList<>();
        for (Recipe recipe : getAllRecipes()) {
            if (recipe.getName().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(recipe);
            }
        }
        return searchResults;
    }

    private ArrayList<Recipe> getAllRecipes() {
        ArrayList<Recipe> allRecipes = new ArrayList<>();
        allRecipes.addAll(getFamilyRecipes());
        allRecipes.addAll(getSnackRecipes());
        allRecipes.addAll(getDessertRecipes());
        allRecipes.addAll(getOthersRecipes());
        return allRecipes;
    }

    private void showFullRecipeDetails(Recipe recipe) {
        RecipeDetailsFragment detailsFragment = new RecipeDetailsFragment();

        Bundle args = new Bundle();
        args.putString("name", recipe.getName());
        args.putString("time", recipe.getTime());
        args.putString("ingredients", recipe.getIngredients());
        args.putString("instructions", recipe.getInstructions());
        detailsFragment.setArguments(args);

        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
