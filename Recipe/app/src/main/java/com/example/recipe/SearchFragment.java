package com.example.recipe;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    private EditText searchEditText;
    private Button searchButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchEditText = view.findViewById(R.id.searchEditText);
        searchButton = view.findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchEditText.getText().toString();
                performSearch(query);
            }
        });

        return view;
    }

    private void performSearch(String query) {
        RecipeListFragment searchResultFragment = new RecipeListFragment();

        Bundle args = new Bundle();
        args.putString("category", "search");
        args.putString("query", query);
        searchResultFragment.setArguments(args);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, searchResultFragment)
                .addToBackStack(null)
                .commit();
    }
}
