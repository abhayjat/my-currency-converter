package com.example.my_corrency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    Spinner sp1,sp2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed=(EditText) findViewById(R.id.txtamount);
        sp1=(Spinner) findViewById(R.id.fromspinner);
        sp2=(Spinner) findViewById(R.id.tospinner);
        btn=(Button) findViewById(R.id.convert);

        String[] from={"USD"};
        ArrayAdapter adfrom=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(adfrom);

        String[] to={"Indian Rupee","Bitcoin","Pakistani Rupee","Chinese Yuan","USD"};
        ArrayAdapter adto=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(adto);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double tot;

                Double amount=Double.parseDouble(ed.getText().toString());

                String s=Double.toString(amount);

                if (amount==null){
                    Toast toast=Toast.makeText(getApplicationContext(),"Enter Amount",Toast.LENGTH_SHORT);
                    toast.show();
                }

                if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString()=="Indian Rupee"){
                    tot = amount * 74.89;
                    Toast toast=Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG);
                    toast.show();
                }else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString()=="Bitcoin"){
                    tot = amount * 0.000085;
                    Toast toast=Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG);
                    toast.show();
                }else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString()=="Pakistani Rupee"){
                    tot = amount * 168.08;
                    Toast toast=Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG);
                    toast.show();
                }else if(sp1.getSelectedItem().toString() == "USD" && sp2.getSelectedItem().toString()=="Chinese Yuan"){
                    tot = amount * 6.95;
                    Toast toast=Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    Toast toast=Toast.makeText(getApplicationContext(),"Not Convert",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}