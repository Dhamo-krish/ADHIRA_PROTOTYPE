package com.example.hp.adhira_prototype;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.hp.adhira_prototype.Adapters.wallAdapter;
import com.example.hp.adhira_prototype.Camera.ScannerQr;
import com.example.hp.adhira_prototype.RecyclerView.wallItemAdapter;
import com.ramotion.circlemenu.CircleMenuView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    private wallItemAdapter wId;
    private ArrayList<wallAdapter> wallList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final CircleMenuView menu = (CircleMenuView) findViewById(R.id.circle_menu);
        for(int i=0;i<=20;i++)
        {
            wallList.add(new wallAdapter());
        }
        recyclerView=(RecyclerView)findViewById(R.id.recycler_wall);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        wId=new wallItemAdapter(R.layout.wall_card,wallList);
        recyclerView.setAdapter(wId);
        menu.setEventListener(new CircleMenuView.EventListener() {
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationStart");
            }

            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationEnd");
            }

            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationStart");
            }

            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationEnd");
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonClickAnimationStart| index: " + index);
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonClickAnimationEnd| index: " + index);
                Intent i=new Intent(Main3Activity.this,Main2Activity.class);
                i.putExtra("index",""+index);
                startActivity(i);
                if(index==3)
                {
                  startActivity(new Intent(Main3Activity.this, ScannerQr.class));
                }
            }
        });
    }
}
