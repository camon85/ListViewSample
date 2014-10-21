package com.example.listviewsample.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private ListView inputListView;
    private EditText input;
    private Button btnEnter;
    private List<String> itemList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputListView = (ListView) findViewById(R.id.inputList);
        input = (EditText) findViewById(R.id.input);
        btnEnter = (Button) findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(this);

        itemList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
        inputListView.setAdapter(adapter);
        input.requestFocus();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_init_list) {
            initList();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String inputStr = input.getText().toString();
        if (inputStr.length() > 0) {
            input.setText("");
            itemList.add(inputStr);
            adapter.notifyDataSetChanged();
        }
    }

    private void initList() {
        itemList.clear();
        adapter.notifyDataSetChanged();
    }

}
