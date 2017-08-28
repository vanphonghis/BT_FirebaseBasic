package com.example.vudinhai.bt_firebasebasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class LitsStudentActivity extends AppCompatActivity {

    DatabaseReference database;
    DatabaseReference myRef;
    Button bntThem,bntXoa,bntSua;
    Student std;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lits_student);
        // Write a message to the database
         database = FirebaseDatabase.getInstance().getReference();
         //myRef = database.getReference("ListStudent");
         myRef=database.child("ListStudent");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               // String key= dataSnapshot.getKey();
                Student value= dataSnapshot.getValue(Student.class);
               Toast.makeText(LitsStudentActivity.this,value.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                String key= dataSnapshot.getKey();
//                String value=(String) dataSnapshot.getValue();
//                Toast.makeText(LitsStudentActivity.this,key + ":" + value,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                String key= dataSnapshot.getKey();
//                String value=(String) dataSnapshot.getValue();
//                Toast.makeText(LitsStudentActivity.this,key + ":" + value,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        bntThem= (Button) findViewById(R.id.bntThem);
        bntXoa= (Button) findViewById(R.id.bntXoa);
        bntSua= (Button) findViewById(R.id.bntSua);

        bntThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                std = new Student("10","Tom");
                String key = myRef.push().getKey();
                Map<String,Object> childUpdate = new HashMap<>();
                childUpdate.put("/ListStudent/"+key,std);
                database.updateChildren(childUpdate);
//                String key = myRef.push().getKey();
//                Map<String,Object> childUpdate = new HashMap<>();
//                childUpdate.put("/ListStudent/"+key,"Hello");
//                database.updateChildren(childUpdate);
            }
        });
        bntXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key="";
                myRef.child(key).removeValue();
            }
        });
        bntSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key="";
                myRef.child(key).setValue("12345");
            }
        });



    }
}
