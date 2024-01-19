package com.example.recipe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RecipeDetailsFragment extends Fragment {

    public RecipeDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_details, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String name = arguments.getString("name");
            String time = arguments.getString("time");
            String ingredients = arguments.getString("ingredients");
            String instructions = arguments.getString("instructions");

            TextView nameTextView = view.findViewById(R.id.recipeNameTextView);
            TextView timeTextView = view.findViewById(R.id.recipeTimeTextView);
            TextView ingredientsTextView = view.findViewById(R.id.recipeIngredientsTextView);
            TextView instructionsTextView = view.findViewById(R.id.recipeInstructionsTextView);

            nameTextView.setText(name);
            timeTextView.setText("Time: " + time);
            ingredientsTextView.setText("Ingredients: " + ingredients);
            instructionsTextView.setText("Instructions: " + instructions);
        }

        return view;
    }
}
