package com.example.sani4.moneytracker.ui.adapters;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sani4.moneytracker.R;
import com.example.sani4.moneytracker.models.ExpenseModel;

import java.util.List;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ExpenseHolder> {

    private List<ExpenseModel>  expensesList;

    public ExpensesAdapter(List<ExpenseModel>  expensesList){
        this.expensesList = expensesList;
    }

    @Override
    public ExpenseHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_item,parent,false);
        return new ExpenseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpenseHolder holder, int position) {

        ExpenseModel expense = expensesList.get(position);
        holder.name.setText(expense.getName());
        holder.price.setText(expense.getPrice());
    }

    @Override
    public int getItemCount() {
        return expensesList.size();
    }

    class  ExpenseHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView price;


        public ExpenseHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.expense_item_expense_name);
            price =(TextView) itemView.findViewById(R.id.expense_item_expense_price);
        }
    }
}
