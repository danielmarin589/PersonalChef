package com.example.personalchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class GroceryActivity extends AppCompatActivity {


    ArrayList<String> list = new ArrayList<>();
    ListView groceryList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);
        groceryList = findViewById(R.id.grocery_list);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        groceryList.setAdapter(arrayAdapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        groceryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(GroceryActivity.this,view);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){

                            case R.id.item_update:
                                AlertDialog.Builder builder = new AlertDialog.Builder(GroceryActivity.this);
                                View v = LayoutInflater.from(GroceryActivity.this).inflate(R.layout.item_dialog,null,false);
                                builder.setTitle("Update Item");
                                EditText editText = v.findViewById(R.id.etItem);
                                editText.setText(list.get(position));

                                builder.setView(v);

                                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(!editText.getText().toString().isEmpty()){
                                            list.set(position,editText.getText().toString().trim());
                                            arrayAdapter.notifyDataSetChanged();
                                            Toast.makeText(GroceryActivity.this,"Item Updated!",Toast.LENGTH_SHORT).show();

                                        }else{
                                            editText.setError("update item here !");
                                        }
                                    }
                                });
                                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });

                                builder.show();
                                break;

                            case R.id.item_delete:
                                Toast.makeText(GroceryActivity.this,"Item Deleted",Toast.LENGTH_SHORT).show();
                                list.remove(position);
                                arrayAdapter.notifyDataSetChanged();

                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.add_item:
                //function to add
                _addItem();

                break;
        }
        return true;
    }

    private void _addItem(){
        AlertDialog.Builder builder = new AlertDialog.Builder(GroceryActivity.this);
        builder.setTitle("Add New Item");

        View v = LayoutInflater.from(GroceryActivity.this).inflate(R.layout.item_dialog,null,false);

        builder.setView(v);
        final EditText etItem = v.findViewById(R.id.etItem);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(!etItem.getText().toString().isEmpty()){
                    list.add(etItem.getText().toString().trim());
                    arrayAdapter.notifyDataSetChanged();
                }else {
                    etItem.setError("add item here !");
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }
}
