package com.example.hp.adhira_prototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class EnquiryEditSave extends AppCompatActivity
{
    EditText mn,clr,clrcode,mat,dop,cop,qp,aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry_edit_save);

        mn=(EditText)findViewById(R.id.maname);
        clr=(EditText)findViewById(R.id.color);
        clrcode=(EditText)findViewById(R.id.colorcode);
        mat=(EditText)findViewById(R.id.materialtype);
        dop=(EditText)findViewById(R.id.dateofp);
        cop=(EditText)findViewById(R.id.costofp);
        qp=(EditText)findViewById(R.id.qtypurchased);
        aq=(EditText)findViewById(R.id.availableqty);

    }
}
