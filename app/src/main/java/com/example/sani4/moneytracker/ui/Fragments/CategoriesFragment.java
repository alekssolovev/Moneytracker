package com.example.sani4.moneytracker.ui.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sani4.moneytracker.R;
import com.example.sani4.moneytracker.models.CategoryModel;
import com.example.sani4.moneytracker.ui.adapters.CategoriesAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.sani4.moneytracker.R.id.fab;

public class CategoriesFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;
    private CoordinatorLayout rootLayout;
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categories_fragment, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_of_categories);
        categoriesAdapter = new CategoriesAdapter(getCategories());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(categoriesAdapter);


        getActivity().setTitle(R.string.category_item);

        rootLayout = (CoordinatorLayout) rootView.findViewById(R.id.category_fragment_root_layout);

        initRecycleView(rootView);
        initFab(rootView);
        return rootView;
    }

    private void initRecycleView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.list_of_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getCategories());
        recyclerView.setAdapter(categoriesAdapter);
    }

    private void initFab(View view) {
        fab = (FloatingActionButton) view.findViewById(R.id.fab_category);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootLayout, R.string.categories_snackbar_message, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private List<CategoryModel> getCategories() {
        List<CategoryModel> categories = new ArrayList<>();
        for (int t = 0; t <= 3; t++) {
            categories.add(new CategoryModel("Furniture "));
            categories.add(new CategoryModel("Electronics "));
            categories.add(new CategoryModel("Clothes "));
            categories.add(new CategoryModel("Foodstufs "));
            categories.add(new CategoryModel("Etc "));
        }
        return categories;
    }
}
