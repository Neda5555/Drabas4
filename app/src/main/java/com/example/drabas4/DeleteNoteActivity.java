package com.example.drabas4;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {

    private Spinner noteSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        noteSpinner = findViewById(R.id.spinnerNotes);

        ArrayList<String> notes = MainActivity.notes;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, notes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noteSpinner.setAdapter(adapter);
    }

    public void deleteNote(View view) {
        String selectedNote = noteSpinner.getSelectedItem().toString();
        MainActivity.notes.remove(selectedNote);
        MainActivity.adapter.notifyDataSetChanged();
        finish();
    }
}