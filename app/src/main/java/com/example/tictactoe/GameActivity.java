package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    String player1 ;
    String player2 ;
    TextView mCurrentPlayer;
    TextView mToPlay ;
    TextView mPlayer1 ;
    TextView mPlayer2 ;
    float scoreX = 0f , scoreO = 0f ;
    TextView mScoreX;
    TextView mScoreO;
    boolean gameActive = true;
    int reset = 0 ;

    //Player rep.
    //0 - X
    //1 - O
    int activePlayer = 0;

    //gameState rep.
    //0 - X
    //1 - O
    //2 - null
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                      {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                      {0, 4, 8}, {2, 4, 6}};

    public void setImage(View view) {
        ImageView img  =(ImageView)view;
        int tappedImg = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            if(reset==0)reset(view);
            else {
                reset(view);
                gameActive = true;
                reset=0;
            }
        }

        try {
            if(gameState[tappedImg]==2 && gameActive){
                gameState[tappedImg]=activePlayer;
                img.setTranslationY(-1000f);
                if(activePlayer==0){
                    img.setImageResource(R.drawable.ic_action_name_x);
                    img.setBackgroundColor(getResources().getColor(R.color.white));
                    activePlayer = 1;
                    mCurrentPlayer.setText(player2);

                }  else {
                    img.setImageResource(R.drawable.ic_action_name_o);
                    img.setBackgroundColor(getResources().getColor(R.color.white));
                    activePlayer = 0;
                    mCurrentPlayer.setText(player1);
                }
                img.animate().translationYBy(1000f).setDuration(300);

            }
            for(int[] winPosition:winPos){
               if(gameState[winPosition[0]] == gameState[winPosition[1]]  &&
                  gameState[winPosition[1]]==gameState[winPosition[2]] &&
                  gameState[winPosition[0]] != 2) {
                   if(gameState[winPosition[0]]==0){

                       mCurrentPlayer.setText(player1 + " has Won !!");
                       mToPlay.setVisibility(View.INVISIBLE);
                       scoreX++;
                   }else{

                       mCurrentPlayer.setText(player2 + " has Won !!");
                       mToPlay.setVisibility(View.INVISIBLE);
                       scoreO++;
                   }

                    gameActive = false;
                    break;
               }

               if(gameState[0]!=2&&gameState[1]!=2&&gameState[2]!=2&&gameState[3]!=2&&gameState[4]!=2
                           &&gameState[5]!=2&&gameState[6]!=2&&gameState[7]!=2&&gameState[8]!=2) {

                       mCurrentPlayer.setText("Draw");
                       mToPlay.setVisibility(View.INVISIBLE);
                       scoreO = scoreO + 0.5f;
                       scoreX = scoreX + 0.5f;
                       gameActive = false;
                       break;
                   }

            }
        }catch (Exception e){

        }
        }

        public void reset(View view){
//        gameActive = true;
            mCurrentPlayer.setText(player1);
            mToPlay.setVisibility(View.VISIBLE);

            reset = 1;
            activePlayer = 0 ;
        for(int i = 0 ; i<gameState.length;i++){
            gameState[i]=2;
        }
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

            ((ImageView)findViewById(R.id.imageView1)).setBackgroundColor(getResources().getColor(R.color.black));
            ((ImageView)findViewById(R.id.imageView2)).setBackgroundColor(getResources().getColor(R.color.black));
            ((ImageView)findViewById(R.id.imageView3)).setBackgroundColor(getResources().getColor(R.color.black));
            ((ImageView)findViewById(R.id.imageView4)).setBackgroundColor(getResources().getColor(R.color.black));
            ((ImageView)findViewById(R.id.imageView5)).setBackgroundColor(getResources().getColor(R.color.black));
            ((ImageView)findViewById(R.id.imageView6)).setBackgroundColor(getResources().getColor(R.color.black));
            ((ImageView)findViewById(R.id.imageView7)).setBackgroundColor(getResources().getColor(R.color.black));
            ((ImageView)findViewById(R.id.imageView8)).setBackgroundColor(getResources().getColor(R.color.black));
            ((ImageView)findViewById(R.id.imageView9)).setBackgroundColor(getResources().getColor(R.color.black));

            mScoreX.setText(""+scoreX);
            mScoreO.setText(""+scoreO);


        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mCurrentPlayer = findViewById(R.id.CurrentPlayerTextView);
        mPlayer1 = findViewById(R.id.player1);
        mPlayer2 = findViewById(R.id.player2);
        mScoreX = findViewById(R.id.ScoreX);
        mScoreO = findViewById(R.id.ScoreO);

        Intent intent = getIntent();
        player1 = intent.getStringExtra("player1");
        player2 = intent.getStringExtra("player2");


        mCurrentPlayer.setText(player1);
        mToPlay = findViewById(R.id.toPlayTextView);

        mPlayer1.setText(player1);
        mPlayer2.setText(player2);

        mScoreX.setText(""+scoreX);
        mScoreO.setText(""+scoreO);


    }


}