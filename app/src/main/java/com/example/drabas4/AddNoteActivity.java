package com.example.drabas4;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        nameEditText = findViewById(R.id.editTextName);
        contentEditText = findViewById(R.id.editTextContent);
    }

    public void saveNote(View view) {
        String name = nameEditText.getText().toString().trim();
        String content = contentEditText.getText().toString().trim();

        if (!name.isEmpty() && !content.isEmpty()) {
            MainActivity.addNoteToList(name + ": " + content);
            finish();
        } else {
            showToast("Įveskite pavadinimą ir turinį");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}