package com.example.boosterpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        TextView textP1Life=findViewById(R.id.p1life);
        TextView textP2Life=findViewById(R.id.p2life);
        Button p1plus=findViewById(R.id.p1plus);
        Button p1minus=findViewById(R.id.button_p1_minus);
        Button p2plus=findViewById(R.id.p2plus);
        Button p2minus=findViewById(R.id.p2minus);
        Button reset=findViewById(R.id.button_reset);

        final Button button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(LifeActivity.this, MainActivity.class);

                // currentContext.startActivity(activityChangeIntent);

                LifeActivity.this.startActivity(activityChangeIntent);
            }
        });
        p1plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                TextView textValue = findViewById(R.id.p1life);
                String stringValue = textValue.getText().toString();
                int originalValue = Integer.parseInt(stringValue);
                int newValue = MyWorker.plus(originalValue);
                textValue.setText(Integer.toString(newValue));
            }
        });

        p1minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                TextView textValue = findViewById(R.id.p1life);
                String stringValue = textValue.getText().toString();
                int originalValue = Integer.parseInt(stringValue);
                int newValue = MyWorker.minus(originalValue);
                textValue.setText(Integer.toString(newValue));
            }
        });



        p2plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                TextView textValue = findViewById(R.id.p2life);
                String stringValue = textValue.getText().toString();
                int originalValue = Integer.parseInt(stringValue);
                int newValue = MyWorker.plus(originalValue);
                textValue.setText(Integer.toString(newValue));
            }
        });
        p2minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                TextView textValue = findViewById(R.id.p2life);
                String stringValue = textValue.getText().toString();
                int originalValue = Integer.parseInt(stringValue);
                int newValue = MyWorker.minus(originalValue);
                textValue.setText(Integer.toString(newValue));
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                textP1Life.setText(Integer.toString(20));
                textP2Life.setText(Integer.toString(20));

            }
        });



    }
}