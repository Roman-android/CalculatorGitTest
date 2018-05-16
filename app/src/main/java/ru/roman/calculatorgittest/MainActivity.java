package ru.roman.calculatorgittest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.roman.calculatorgittest.fragments.OutputListFragment;
import ru.roman.calculatorgittest.utils.Calculation;

public class MainActivity extends AppCompatActivity {

    Calculation calculation;
    OutputListFragment outputListFragment;

    EditText input_number_1, input_number_2;
    Button show_result;
    TextView text_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calculation = new Calculation();
        outputListFragment = new OutputListFragment();

        input_number_1 = findViewById(R.id.num_1);
        input_number_2 = findViewById(R.id.num_2);
        show_result = findViewById(R.id.btn_result);
        text_result = findViewById(R.id.text_result);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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

        Toast.makeText(this, num_first, Toast.LENGTH_SHORT).show();
        String summ_of_num = calculation.workCalculation(num_first,num_second);

        text_result.setText(summ_of_num);

        outputListFragment.results.add(summ_of_num);
        outputListFragment.adapter.notifyDataSetChanged();

    }
}
