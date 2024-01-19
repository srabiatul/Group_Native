package com.example.recipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecipeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private static final String PREFS_NAME = "RecipePrefs";
    private static final String KEY_RECIPE_NAME = "recipeName";
    private static final String KEY_INGREDIENTS = "ingredients";
    private static final String KEY_PROCESS = "process";
    private static final String KEY_CATEGORY = "category";

    private EditText recipeNameEditText;
    private EditText ingredientsEditText;
    private EditText processEditText;
    private AutoCompleteTextView categoryAutoCompleteTextView;

    public static AddRecipeFragment newInstance(String param1, String param2) {
        AddRecipeFragment fragment = new AddRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AddRecipeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_recipe, container, false);


        recipeNameEditText = view.findViewById(R.id.editTextText7);
        ingredientsEditText = view.findViewById(R.id.editTextText8);
        processEditText = view.findViewById(R.id.editTextText9);
        categoryAutoCompleteTextView = view.findViewById(R.id.autoCompleteTextView);

        String[] categories = {"Family", "Snack", "Dessert", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, categories);
        categoryAutoCompleteTextView.setAdapter(adapter);

        categoryAutoCompleteTextView.setTextColor(getResources().getColor(android.R.color.black));

        Button resetButton = view.findViewById(R.id.rest_form);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetForm();
            }
        });

        Button saveButton = view.findViewById(R.id.save_recipe);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToSharedPreferences();
            }
        });

        return view;
    }


    private void resetForm() {
        recipeNameEditText.setText("");
        ingredientsEditText.setText("");
        processEditText.setText("");
        categoryAutoCompleteTextView.setText("");
    }

    private void saveDataToSharedPreferences() {
        String recipeName = recipeNameEditText.getText().toString().trim();
        String ingredients = ingredientsEditText.getText().toString().trim();
        String process = processEditText.getText().toString().trim();
        String category = categoryAutoCompleteTextView.getText().toString().trim();

        if (recipeName.isEmpty() || ingredients.isEmpty() || process.isEmpty() || category.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        if (!sharedPreferences.contains(KEY_RECIPE_NAME + recipeName)) {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_RECIPE_NAME + recipeName, recipeName);
            editor.putString(KEY_INGREDIENTS + recipeName, ingredients);
            editor.putString(KEY_PROCESS + recipeName, process);
            editor.putString(KEY_CATEGORY + recipeName, category);
            editor.apply();

            Toast.makeText(requireContext(), "Recipe added successfully", Toast.LENGTH_SHORT).show();
            resetForm();
        } else {
            Toast.makeText(requireContext(), "Recipe with the same name already exists", Toast.LENGTH_SHORT).show();
        }
    }
}
