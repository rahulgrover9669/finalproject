package com.example.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.jokerreceivingtextview);
        Intent intent = getIntent();
         if (intent.hasExtra("joker")) {

             textView.setText(intent.getStringExtra("joker"));      // ...
         }


     //  ]\\\ Toast.makeText(this,intent.getStringExtra("joker"),Toast.LENGTH_LONG).show();

    }
}
