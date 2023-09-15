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

    ImageView stoneImg, paperImg, scissorsImg, playerImgView, appImgView;

     Button playBt;

    TextView textRes;

    final int[] images = {R.drawable.stone, R.drawable.paper, R.drawable.scissors};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stoneImg = findViewById(R.id.stone);
        paperImg = findViewById(R.id.paper);
        scissorsImg = findViewById(R.id.scissors);

        playerImgView = findViewById(R.id.playerImgView);
        appImgView = findViewById(R.id.appImgView);

        playBt = findViewById(R.id.playBt);

        textRes = findViewById(R.id.resultTxt);



        stoneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOption(0);
                reset();
            }
        });

        paperImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOption(1);
                reset();
            }
        });



        scissorsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOption(2);
                reset();
            }
        });

        playBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playerOpt == appOpt) {
                    textRes.setText("Empate!");
                } else if ((playerOpt == 0 && appOpt == 2) ||
                        (playerOpt == 1 && appOpt == 0) ||
                        (playerOpt == 2 && appOpt == 1)) {
                    textRes.setText("Você ganhou!");
                } else {
                    textRes.setText("Você perdeu!");
                }
                appImgView.setImageResource(images[appOpt]);

            }
        });

    }
    public void reset() {
        playerImgView.setImageResource(images[playerOpt]);
        appImgView.setImageResource(R.drawable.square);
        textRes.setText("Resultado");
    }

    public void chooseOption(int opt) {
        Random random = new Random();

        playerOpt = opt;
        appOpt = random.nextInt(3);
    }

}