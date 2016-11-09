package com.example.sani4.moneytracker.ui;


import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.sani4.moneytracker.R;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

@EActivity(R.layout.add_expense_activity)
public class AddExpenseActivity extends AppCompatActivity {

    @ViewById(R.id.add_expense_activity_summ)
    EditText expense;
    @ViewById(R.id.add_expense_activity_description)
    EditText description;
    @ViewById(R.id.add_expense_activity_date)
    EditText date;
    @ViewById(R.id.add_expense_activity_category)
    Spinner spinnerCategories;
    @ViewById(R.id.cancel)
    Button buttonCancel;
    @ViewById(R.id.add)
    Button buttonAdd;
    SimpleDateFormat SimpleDateFormat;
    String string;
    @AfterViews
    void load(){
        SimpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String currentDateandTime = SimpleDateFormat.format(new Date());
        date.setText(currentDateandTime);
    }
    @Click(R.id.cancel)
    void btnCancelIsClicked() {
        Toast.makeText(getApplicationContext(), R.string.add_expense_cancel, Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.add)
    void btnAddIsClicked() {

        if (((expense.getText().length() > 0) & (date.getText().length()) > 0) & (string.equals(R.string.select_categories))){
            buttonAdd.setEnabled(true);
            Toast.makeText(getBaseContext(), R.string.apply_is_true, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.add_expense_apply_not_write, Toast.LENGTH_SHORT).show();
        }
    }

    @AfterViews
    void spinnerClicked() {
        string = String.valueOf(spinnerCategories.getSelectedItem());
        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapter);
    }

}
