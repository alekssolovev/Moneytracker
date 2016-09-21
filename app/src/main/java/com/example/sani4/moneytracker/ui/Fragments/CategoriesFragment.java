package com.example.sani4.moneytracker.ui.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class CategoriesFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categories_fragment, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_of_categories);
        categoriesAdapter = new CategoriesAdapter(getCategories());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(categoriesAdapter);


        return rootView;

    }

    private List<CategoryModel> getCategories() {
        List<CategoryModel> categories = new ArrayList<>();
        for (int t = 0; t <= 3; t++) {
            categories.add(new CategoryModel("Мебель "));
            categories.add(new CategoryModel("Электроника "));
            categories.add(new CategoryModel("Одежда "));
            categories.add(new CategoryModel("Продовольствие "));
            categories.add(new CategoryModel("Прочее "));
        }
        return categories;
    }
}
