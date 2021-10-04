package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mStartButton;
    EditText mPlayer1;
    EditText mPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer1 = findViewById(R.id.player1_EditText);
        mPlayer2 = findViewById(R.id.player2_EditText);




        mStartButton = findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mPlayer1.getText().toString().matches("")){
                    mPlayer1.setError("Name Required");
                    return;
                }
                if(mPlayer2.getText().toString().matches("")){
                    mPlayer2.setError("Name Required");
                    return;
                }
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                intent.putExtra("player1",mPlayer1.getText().toString());
                intent.putExtra("player2",mPlayer2.getText().toString());
                startActivity(intent);
            }
        });

    }
}