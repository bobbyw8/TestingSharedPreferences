package com.example.bobby.testingsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText height;
    EditText weight;

    TextView heightTextView;
    TextView weightTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.mHeight);
        weight = (EditText) findViewById(R.id.mWeight);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        weightTextView =(TextView) findViewById(R.id.weightTextView3);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void save(View view){

        SharedPreferences sharedPreferences =getSharedPreferences("MyData", Context.MODE_PRIVATE);
        //must use SharedPreferences.Editor to save values
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("height",height.getText().toString()); //stores height data with key "height"
        editor.putString("weight",weight.getText().toString()); //stores weight data with key "weight"

        editor.commit(); //commits the data

        Toast.makeText(this, "data was saved", Toast.LENGTH_LONG).show();


    }

    //loads the data from sharedpreferences when its called
    public static final String DEFAULT="N/A";


    public void load(View view){
        SharedPreferences sharedPreferences =getSharedPreferences("MyData",Context.MODE_PRIVATE);
       String height = sharedPreferences.getString("height", DEFAULT); //initialized default height data with key "height"
       String weight = sharedPreferences.getString("weight",DEFAULT); //initialized default weight data with key "weight"

        if (height.equals(DEFAULT)||weight.equals(DEFAULT))
        {

            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();

        }

        //for testing
        else{
            Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();
            heightTextView.setText(height);
            weightTextView.setText(weight);

        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
