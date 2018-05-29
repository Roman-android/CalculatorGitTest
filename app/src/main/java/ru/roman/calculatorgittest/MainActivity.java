package ru.roman.calculatorgittest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.roman.calculatorgittest.fragments.OutputListFragment;
import ru.roman.calculatorgittest.utils.Calculation;

public class MainActivity extends AppCompatActivity {

    Calculation calculation;
    OutputListFragment outputListFragment;

    EditText input_number_1, input_number_2;
    Button show_result;
    TextView text_result;

    ListView listView;
    ArrayList <String> results;
    public ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calculation = new Calculation();
        //outputListFragment = new OutputListFragment();

        results = new ArrayList<>();
        listView = findViewById(R.id.dynamic_list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results);
        results.add("456");
        listView.setAdapter(adapter);

        input_number_1 = findViewById(R.id.num_1);
        input_number_2 = findViewById(R.id.num_2);
        show_result = findViewById(R.id.btn_result);
        text_result = findViewById(R.id.text_result);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    public void onClick(View view) {

        String num_first = input_number_1.getText().toString();
        String num_second = input_number_2.getText().toString();

        String sum_of_num = calculation.workCalculation(num_first,num_second);
        Toast.makeText(this, sum_of_num, Toast.LENGTH_SHORT).show();
        text_result.setText(sum_of_num);
        //outputListFragment.updateList(sum_of_num);
        results.add(sum_of_num);
        adapter.notifyDataSetChanged();
    }
}
