package com.example.hp.adhira_prototype;

import android.content.Intent;
import android.os.Handler;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button login;
    Handler handler=new Handler();
    ImageView i1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.linearlay1);
        i1=(ImageView)findViewById(R.id.imageView);
        //l1=(LinearLayout)findViewById(R.id.linearlay1);
        final LinearLayout l2=(LinearLayout)findViewById(R.id.lineralay2);
        login=(Button)findViewById(R.id.login);
        i1.setOnClickListener(new View.OnClickListener()
        {
            boolean visible;
            @Override
            public void onClick(View view)
            {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                l2.setVisibility(visible ? View.VISIBLE : View.GONE);

            }
        });

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });


    }
}
