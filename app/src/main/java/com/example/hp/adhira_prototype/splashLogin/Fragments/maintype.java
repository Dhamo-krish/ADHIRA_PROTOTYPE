package com.example.hp.adhira_prototype.splashLogin.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hp.adhira_prototype.R;
import com.example.hp.adhira_prototype.splashLogin.Adapters.maintypeAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 11/16/2017.
 */

public class maintype extends Fragment {
         RecyclerView recyclerView;
         ImageView ig1,ig2;
    //private StaggeredGridLayoutManager gaggeredGridLayoutManager;
        ArrayList<maintypeAdapter> pa=new ArrayList<>();
        maintypeItemAdapter pTD;
    public maintype()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.photos,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_photos);
        //gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ig1=(ImageView)view.findViewById(R.id.imageButton);
        //ig2=(ImageView)view.findViewById(R.id.imageView2);
        ig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getActivity().finish();
            }
        });

        int i=10;

            pa.add(new maintypeAdapter("Tops"));
            pa.add(new maintypeAdapter("Designer Materials"));
        pa.add(new maintypeAdapter("Pants"));
        pa.add(new maintypeAdapter("Laces"));
        pTD=new maintypeItemAdapter(R.layout.photos_card,pa);
        recyclerView.setAdapter(pTD);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        pTD.setOnItemClickListener1(new maintypeItemAdapter.MyClickListener() {
            @Override
            public void onItemClick1(int position, View v)
            {
                getFragmentManager().beginTransaction().replace(R.id.frame_container,new subType()).commit();
            }
        });
    }
}
