package com.example.fullcountryapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private AlertDialog.Builder builder;

    private SearchView searchView;

    private String[] countryname;
    private int[] flag = {R.drawable.bangladesh, R.drawable.china, R.drawable.unitedstates, R.drawable.unitedstates, R.drawable.unitedstates, R.drawable.unitedstates};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_id);

        listView = findViewById(R.id.listViwe_id);

        countryname = getResources().getStringArray(R.array.country_name);
        CustomAdapter customAdepter = new CustomAdapter(this, countryname, flag);

        listView.setAdapter(customAdepter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String val = countryname[position];
                Toast.makeText(MainActivity.this, val, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuSetting_id) {

            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.menuShare_id) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/app");

            String subject = "This is first app";
            String head =" Download this app - com.example.fullcountryapplication";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,head);

            startActivity(Intent.createChooser(intent,"Share with"));


            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.menuFeedback_id) {

            Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.menuAbout_id) {

            Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }

}