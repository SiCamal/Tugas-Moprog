package com.sicamal.tugas2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CustomListAdapter adapter;
    ArrayList<Model> modelList = new ArrayList<>();
    ArrayList<String> data = new ArrayList<>();
    Model[] modelItems;
    ListView listV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        listV = (ListView) findViewById(R.id.lvCustom);
        /*modelItems = new Model[5];
        modelItems[0] = new Model("pizza", 0);
        modelItems[1] = new Model("burger", 0);
        modelItems[2] = new Model("olives", 0);
        modelItems[3] = new Model("orange", 0);
        modelItems[4] = new Model("tomato", 0);*/
        Model model = new Model("pizza", 0);
        modelList.add(model);
        model = new Model("uyah", 0);
        modelList.add(model);

        adapter = new CustomListAdapter(this,R.layout.layoutlistview, modelList);
        listV.setAdapter(adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                Model model = (Model) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + model.getName(),
                        Toast.LENGTH_LONG).show();
            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    static final int ACT2_REQUEST = 99; //request code

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mInsert:
                Intent intent3 = new Intent(this, Main2Activity.class);
                startActivityForResult(intent3, ACT2_REQUEST);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.mDelete:
                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<Model> modelList = adapter.modelList;
                for(int i=0;i<modelList.size();i++){
                    Model model = modelList.get(i);
                    if(model.getValue() == 1){
                        responseText.append("\n" + model.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

                return true;
            case R.id.mUpdate:
                Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data1){
        super.onActivityResult(requestCode, resultCode, data1);
        listV = (ListView) findViewById(R.id.lvCustom);

        // /cek request code
        if(requestCode == ACT2_REQUEST){
            String terima = data1.getStringExtra("strings");

            Model model = new Model(terima, 0);
            modelList.add(model);

            adapter = new CustomListAdapter(this,R.layout.layoutlistview, modelList);
            adapter.notifyDataSetChanged();
        }
    }

}
