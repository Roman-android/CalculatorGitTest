package ru.roman.calculatorgittest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.roman.calculatorgittest.R;

public class OutputListFragment extends Fragment {

    final String[] catNames = new String[]{"Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка"};

    public ArrayList<String> results;
    public ArrayAdapter adapter;
    public String test;
    private final String LOG_OUTPUT = "log_output_list";
    ListView listView;

    public OutputListFragment() {
        test = "7896";
    }

    /*public static OutputListFragment newInstance(Context context) {
        OutputListFragment outputListFragment = new OutputListFragment();
        Bundle args = new Bundle();
        args.putParcelable("context", context);
        outputListFragment.setArguments(args);
        return outputListFragment;
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, results);
        Log.d(LOG_OUTPUT, String.valueOf("result = "+getContext()));
        results = new ArrayList<>();
        results.add("456");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_output, container, false);
        listView = view.findViewById(R.id.dynamic_list);

        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Log.d("Log","result = "+results.get(0));
    }

    public void updateList(String item) {
        Log.d(LOG_OUTPUT, "result = " + item);

        /*results.add(item);
        if (adapter != null){
            adapter.notifyDataSetChanged();
        }else {
            Log.d("Log","adapter == null, "+item);
        }*/

    }

    ;
}
