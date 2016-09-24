package com.example.sani4.moneytracker.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sani4.moneytracker.R;
import com.example.sani4.moneytracker.models.CategoryModel;

import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryHolder>  {

    private List<CategoryModel> categoriesList;

    public CategoriesAdapter(List<CategoryModel>  expensesList){
        this.categoriesList = expensesList;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item,parent,false);
        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {

        CategoryModel category = categoriesList.get(position);
        holder.name.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    class  CategoryHolder extends RecyclerView.ViewHolder{

        TextView name;


        public CategoryHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.category_item_category_name);
        }
    }

}
