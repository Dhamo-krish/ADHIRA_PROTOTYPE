package com.example.hp.adhira_prototype.Credentials;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hp.adhira_prototype.Adapters.SignupAdapter;
import com.example.hp.adhira_prototype.Main3Activity;
import com.example.hp.adhira_prototype.R;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by HP on 2/20/2018.
 */

public class Signup extends AppCompatActivity {

    TextInputEditText e1,e2,e3,e4;
    Button b;
    DatabaseReference dref;
    String s1,s2,s3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        e1=(TextInputEditText)findViewById(R.id.editText1);
        e2=(TextInputEditText)findViewById(R.id.editText2);
        e3=(TextInputEditText)findViewById(R.id.editText3);
        e4=(TextInputEditText)findViewById(R.id.editText4);
        b=(Button)findViewById(R.id.click);
        dref= FirebaseDatabase.getInstance().getReference().child("USERS");
        Firebase.setAndroidContext(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();

                dref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(s1)) {
                            Toast.makeText(Signup.this, "USERNAME EXIST", Toast.LENGTH_SHORT).show();
                        }
                        else{
                                SignupAdapter sap = new SignupAdapter();
                                sap.setUname(s1);
                                sap.setUid(s2);
                                sap.setUpass(s3);
                                dref.child(s1).setValue(sap);
                                startActivity(new Intent(Signup.this, Login.class));
                        }

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }
        });
    }
}
