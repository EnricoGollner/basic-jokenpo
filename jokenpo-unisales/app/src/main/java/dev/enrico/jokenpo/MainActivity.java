package dev.enrico.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int playerOpt = 0;
    private int appOpt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView stoneImg = findViewById(R.id.stone);
        final ImageView paperImg = findViewById(R.id.paper);
        final ImageView scissorsImg = findViewById(R.id.scissors);

        final ImageView playerImgView = findViewById(R.id.playerImgView);
        final ImageView appImgView = findViewById(R.id.appImgView);

        final Button playBt = findViewById(R.id.playBt);

        final TextView textView = findViewById(R.id.resultTxt);

        final int[] images = {R.drawable.stone, R.drawable.paper, R.drawable.scissors};



        stoneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOption(0);
                playerImgView.setImageResource(images[playerOpt]);
            }
        });

        paperImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOption(1);
                playerImgView.setImageResource(images[playerOpt]);
            }
        });

        scissorsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOption(2);
                playerImgView.setImageResource(images[playerOpt]);
            }
        });

        playBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playerOpt == appOpt) {
                    textView.setText("Empate!");
                } else if ((playerOpt == 0 && appOpt == 2) ||
                        (playerOpt == 1 && appOpt == 0) ||
                        (playerOpt == 2 && appOpt == 1)) {
                    textView.setText("Você ganhow!");
                } else {
                    textView.setText("Você perdeu!");
                }
                appImgView.setImageResource(images[appOpt]);

            }
        });

    }

    public void chooseOption(int opt) {
        Random random = new Random();

        playerOpt = opt;
        appOpt = random.nextInt(3);
    }

}