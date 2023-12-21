package com.example.drabas4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter<String> adapter;
    private ListView listViewNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNotes = findViewById(R.id.listViewNotes);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listViewNotes.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_note:
                Intent addNoteIntent = new Intent(this, AddNoteActivity.class);
                startActivity(addNoteIntent);
                return true;
            case R.id.menu_delete_note:
                Intent deleteNoteIntent = new Intent(this, DeleteNoteActivity.class);
                startActivity(deleteNoteIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static void addNoteToList(String note) {
        notes.add(note);
        adapter.notifyDataSetChanged();
    }
}
