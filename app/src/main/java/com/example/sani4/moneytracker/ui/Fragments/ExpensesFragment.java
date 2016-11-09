package com.example.sani4.moneytracker.ui.Fragments;

import android.content.Intent;
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
import com.example.sani4.moneytracker.models.ExpenseModel;
import com.example.sani4.moneytracker.ui.AddExpenseActivity_;
import com.example.sani4.moneytracker.ui.adapters.ExpensesAdapter;

import java.util.ArrayList;
import java.util.List;


public class ExpensesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ExpensesAdapter expensesAdapter;
    private CoordinatorLayout rootLayout;
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.expenses_fragment, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_of_expenses);
        expensesAdapter = new ExpensesAdapter(getExpenses());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(expensesAdapter);

        getActivity().setTitle(R.string.spend_item);

        rootLayout = (CoordinatorLayout) rootView.findViewById(R.id.expense_fragment_root_layout);

        initRecycleView(rootView);
        initFab(rootView);
        return rootView;
    }

    private void initRecycleView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.list_of_expenses);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ExpensesAdapter expensesAdapter = new ExpensesAdapter(getExpenses());
        recyclerView.setAdapter(expensesAdapter);
    }

    private void initFab(View view) {
        fab = (FloatingActionButton) view.findViewById(R.id.fab_expenses);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddExpenseActivity_.class);
                startActivity(intent);
            }
        });
    }

    private List<ExpenseModel> getExpenses() {
        List<ExpenseModel> expenses = new ArrayList<>();
        for (int t = 0; t <= 2; t++) {
            expenses.add(new ExpenseModel("Tools", "200"));
            expenses.add(new ExpenseModel("Fuel", "124"));
            expenses.add(new ExpenseModel("Mall", "589"));
            expenses.add(new ExpenseModel("Drugs", "1000"));
            expenses.add(new ExpenseModel("Bitcoins", "2000"));
            expenses.add(new ExpenseModel("Computer", "15000"));
            expenses.add(new ExpenseModel("Etc", "20"));
        }
        return expenses;
    }

 }
