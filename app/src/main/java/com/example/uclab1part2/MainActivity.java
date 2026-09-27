package com.example.uclab1part2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int secretNumber;
    int numberOfGuesses = 0;

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
        Button playAgain = findViewById(R.id.playAgain);

        guessButton.setOnClickListener(v -> {

            String guessText = guess.getText().toString();

            if (guessText.isEmpty()) {
                result.setText("Enter a number");
                return;
            }

            int userGuess = Integer.parseInt(guessText);

            if (userGuess < 1 || userGuess > 30) {
                result.setText("Enter a number between 1 and 30");
                return;
            }

            numberOfGuesses++;

            guessCount.setText(
                    "Number of guesses: " + numberOfGuesses
            );

            if (userGuess < secretNumber) {
                result.setText("Higher!");
            }
            else if (userGuess > secretNumber) {
                result.setText("Lower!");
            }
            else {
                result.setText("Correct!");
                playAgain.setVisibility(View.VISIBLE);
                guessButton.setEnabled(false);
            }

            guess.setText("");
        });

        playAgain.setOnClickListener(v ->{

            secretNumber = random.nextInt(30) + 1;
            numberOfGuesses = 0;

            result.setText("");
            guessCount.setText("Number of guesses: 0");
            guess.setText("");

            guessButton.setEnabled(true);
            playAgain.setVisibility(View.GONE);
        });
    }
}