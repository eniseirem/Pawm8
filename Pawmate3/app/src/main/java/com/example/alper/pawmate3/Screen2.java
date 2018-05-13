package com.example.alper.pawmate3;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;

public class Screen2 extends AppCompatActivity {

    public Button findHomeButton;
    ArrayList<String> userEmailsFromFb;
    ArrayList<String> userSpeciesFromFb;
    ArrayList<String> userSexFromFb;
    ArrayList<String> userImageFromFb;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    ListView listView;

    PostClass adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        userEmailsFromFb = new ArrayList<>();
        userImageFromFb = new ArrayList<>();
        userSexFromFb = new ArrayList<>();
        userSpeciesFromFb = new ArrayList<>();


        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();

        listView = findViewById(R.id.listView);

        adapter = new PostClass(userEmailsFromFb, userEmailsFromFb,userImageFromFb,userSpeciesFromFb,this);

        listView.setAdapter(adapter);

        getDataFromFirebase();

        findHomeButton = findViewById(R.id.findHomeB);

        findHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fhb = new Intent(Screen2.this,FindHome.class);
                startActivity(fhb);
            }
        });
    }

    protected void getDataFromFirebase(){

        DatabaseReference newReference = firebaseDatabase.getReference("Posts");
        newReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    HashMap<String,String> hashMap = (HashMap<String, String>) ds.getValue();
                    userEmailsFromFb.add(hashMap.get("useremail"));
                    userSexFromFb.add(hashMap.get("sex"));
                    userSpeciesFromFb.add(hashMap.get("species"));
                    userImageFromFb.add(hashMap.get("downloadUrl"));
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
