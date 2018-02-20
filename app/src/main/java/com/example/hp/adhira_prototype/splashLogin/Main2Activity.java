package com.example.hp.adhira_prototype.splashLogin;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hp.adhira_prototype.R;
import com.example.hp.adhira_prototype.splashLogin.Fragments.maintype;


public class Main2Activity extends AppCompatActivity {

    int index;
    public FragmentManager fragmentManager=getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page);
        String st=getIntent().getExtras().getString("index").toString();
        index=Integer.parseInt(st);
        if(index==0)
        {
            //i Toast.makeText(this, "Photos", Toast.LENGTH_SHORT).show();
            fragmentManager.beginTransaction().replace(R.id.frame_container,new maintype()).commit();

        }

    }
}
