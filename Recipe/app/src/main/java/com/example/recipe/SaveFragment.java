package com.example.recipe;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Map;

public class SaveFragment extends Fragment {

    private static final String PREFS_NAME = "RecipePrefs";
    private static final String KEY_RECIPE_NAME = "recipeName";
    private static final String KEY_INGREDIENTS = "ingredients";
    private static final String KEY_PROCESS = "process";
    private static final String KEY_CATEGORY = "category";

    private LinearLayout savedRecipesLayout;
    private long lastClickTime = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save, container, false);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddRecipeFragment();
            }
        });

        savedRecipesLayout = view.findViewById(R.id.savedRecipesLayout);
        retrieveAndDisplaySavedRecipes();

        return view;
    }

    private void retrieveAndDisplaySavedRecipes() {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPreferences.getAll();

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String recipeName = entry.getKey().replace(KEY_RECIPE_NAME, "");
            String ingredients = sharedPreferences.getString(KEY_INGREDIENTS + recipeName, "");
            String process = sharedPreferences.getString(KEY_PROCESS + recipeName, "");
            String category = sharedPreferences.getString(KEY_CATEGORY + recipeName, "");

            if (!recipeName.isEmpty() && !ingredients.isEmpty() && !process.isEmpty() && !category.isEmpty()) {
                TextView recipeTextView = new TextView(requireContext());
                recipeTextView.setTextColor(getResources().getColor(android.R.color.black));

                String recipeText = "Recipe Name: " + recipeName + "\nIngredients: " + ingredients +
                        "\nProcess: " + process + "\nCategory: " + category + "\n\n";
                recipeTextView.setText(recipeText);

                recipeTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        long currentTime = System.currentTimeMillis();
                        if (currentTime - lastClickTime < 500) {
                            showDeleteConfirmationDialog(recipeName, recipeTextView);
                        }
                        lastClickTime = currentTime;
                    }
                });

                savedRecipesLayout.addView(recipeTextView);
            }
        }
    }

    private void showDeleteConfirmationDialog(String recipeName, TextView recipeTextView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Confirm Deletion");
        builder.setMessage("Are you sure you want to delete the recipe: " + recipeName + "?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeRecipeFromSharedPreferences(recipeName);
                savedRecipesLayout.removeView(recipeTextView);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void removeRecipeFromSharedPreferences(String recipeName) {
        SharedPreferences.Editor editor = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.remove(KEY_RECIPE_NAME + recipeName);
        editor.remove(KEY_INGREDIENTS + recipeName);
        editor.remove(KEY_PROCESS + recipeName);
        editor.remove(KEY_CATEGORY + recipeName);
        editor.apply();
    }

    private void openAddRecipeFragment() {
        AddRecipeFragment addRecipeFragment = new AddRecipeFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, addRecipeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
