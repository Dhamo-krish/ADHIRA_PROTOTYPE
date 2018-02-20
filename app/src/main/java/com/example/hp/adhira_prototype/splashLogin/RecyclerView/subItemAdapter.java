package com.example.hp.adhira_prototype.splashLogin.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.adhira_prototype.R;
import com.example.hp.adhira_prototype.splashLogin.Adapters.maintypeAdapter;
import com.example.hp.adhira_prototype.splashLogin.Fragments.maintypeItemAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 11/19/2017.
 */

public class subItemAdapter extends RecyclerView.Adapter<subItemAdapter.ViewHolder>{
    private int listItemLayout;
    private ArrayList<maintypeAdapter> list1;
    private static MyClickListener myClickListener1;
    public subItemAdapter(int layout, ArrayList<maintypeAdapter> list)
    {
        this.list1=list;
        this.listItemLayout=layout;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        final ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        TextView item=holder.t1;
        item.setText(list1.get(position).getType());
    }

    @Override
    public int getItemCount()
    {
        return list1==null?0:list1.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView t1;
        public ViewHolder(View itemView) {
            super(itemView);
            View t=itemView;
            t1=(TextView)itemView.findViewById(R.id.Classification);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    myClickListener1.onItemClick1(getAdapterPosition(), view);

                }
            });
        }

        @Override
        public void onClick(View view)
        {

        }
    }
    public void setOnItemClickListener1(MyClickListener myClickListener) {
        this.myClickListener1 = myClickListener;
    }
    public interface MyClickListener {
        public void onItemClick1(int position, View v);
    }
}
