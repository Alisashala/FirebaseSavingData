package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void InsertData (View view) {
       Map<String, Object> notes = new HashMap<>();
       notes.put("Title", "Math");
       notes.put("Text", "b^2-4*a*c");
       notes.put("Tag", "School");
       notes.put("favorite", false);

       db.collection("Notes")
       .add(notes)
       .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
           @Override
           public void onSuccess(DocumentReference documentReference) {
               System.out.println("added");
           }
       })
               .addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       System.out.println("error");
                       System.out.println(e);
                   }
               });
   }

   public void SetData (View view) {
       Map<String, Object> notes = new HashMap<>();
       notes.put("Title", "set");
       notes.put("Text", "set");
       notes.put("Tag", "idk");
       notes.put("Favorite", true);
       notes.put("mood", "Happy");

       Notes setNotes = new Notes("Eventyr", "Analyse", "Dansk", false);

       db.collection("Notes")
               .document("ada")
               .set(notes)
               .addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void aVoid) {
                       //Log.d(TAG, "DocumentSnapshot successfully written!");
                   }
               })
               .addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       //Log.w(TAG, "Error writing document", e);
                   }
               });
   }

   public void createNote (View view) {
       EditText titleView = findViewById(R.id.noteTitle);
       String title = titleView.getText().toString();

       Map<String, Object> notes = new HashMap<>();
       notes.put("title", title);

       db.collection("Notes")
               .add(notes)
               .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                   @Override
                   public void onSuccess(DocumentReference documentReference) {
                       System.out.println("added");
                   }
               })
               .addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       System.out.println("error");
                       System.out.println(e);
                   }
               });
   }

   }
