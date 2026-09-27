package com.example.uclab1part2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        secretNumber = random.nextInt(30) + 1;

        EditText guess = findViewById(R.id.guess);
        Button guessButton = findViewById(R.id.guessButton);
        TextView result = findViewById(R.id.result);
        TextView guessCount = findViewById(R.id.guessCount);
        TextView playAgain = findViewById(R.id.playAgain);



    }
}