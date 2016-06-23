package com.example.es.tictactoe;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void again(View view) {
        ImageView imageView0 = (ImageView)findViewById(R.id.imageView);
        ImageView imageView1 = (ImageView)findViewById(R.id.imageView2);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageView3);
        ImageView imageView3 = (ImageView)findViewById(R.id.imageView4);
        ImageView imageView4 = (ImageView)findViewById(R.id.imageView5);
        ImageView imageView5 = (ImageView)findViewById(R.id.imageView6);
        ImageView imageView6 = (ImageView)findViewById(R.id.imageView7);
        ImageView imageView7 = (ImageView)findViewById(R.id.imageView8);
        ImageView imageView8 = (ImageView)findViewById(R.id.imageView9);
        imageView0.setImageDrawable(null);
        imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);
        imageView7.setImageDrawable(null);
        imageView8.setImageDrawable(null);

        for (int i = 0; i<gameStatus.length; i++){
            gameStatus[i] = 2;
        }
        gamesolver=false;
        activeplayer=0;
        Button button = (Button) findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
    }

    int[] gameStatus={2,2,2,2,2,2,2,2,2};

    int[][] winningpositions= {{0,1,2},{3,4,5,},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gamesolver=false;

    int activeplayer=0;


    public void gameon(View view)
    {
        if (gamesolver==false) {
            ImageView square = (ImageView) view;
            int tag = Integer.parseInt(square.getTag().toString());//identify the square tapped
            if (gameStatus[tag] == 2) {
                gameStatus[tag] = activeplayer;
                if (activeplayer == 0) {
                    square.setImageResource(R.drawable.x);
                    activeplayer = 1;
                } else {
                    square.setImageResource(R.drawable.o);
                    activeplayer = 0;
                }
            }
            //Victory logic
            for (int[] i : winningpositions) {
                if (gameStatus[i[0]] == gameStatus[i[1]] && gameStatus[i[1]] == gameStatus[i[2]] && gameStatus[i[0]] != 2) {
                    gamesolver = true;
                    if (activeplayer == 0) {
                        Toast.makeText(MainActivity.this, "O has won", Toast.LENGTH_SHORT).show();
                        Button button = (Button) findViewById(R.id.button);
                        button.setVisibility(View.VISIBLE);

                    } else {
                        Toast.makeText(MainActivity.this, "X has won", Toast.LENGTH_SHORT).show();
                        Button button = (Button) findViewById(R.id.button);
                        button.setVisibility(View.VISIBLE);
                    }
                        break;
                    }
                else
                {
                    gamesolver=true;

                    for (int j:gameStatus)
                    {
                        if(j==2)
                            gamesolver=false;
                    }
                    for (int[] k : winningpositions) {
                        if (gameStatus[k[0]] == gameStatus[k[1]] && gameStatus[k[1]] == gameStatus[k[2]] && gameStatus[k[0]] != 2){
                            gamesolver=false;
                        }
                    }
                    if (gamesolver)
                    {
                        Toast.makeText(MainActivity.this,"Draw game",Toast.LENGTH_SHORT).show();
                        Button button = (Button) findViewById(R.id.button);
                        button.setVisibility(View.VISIBLE);
                        break;
                    }

                }
            }
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


}
