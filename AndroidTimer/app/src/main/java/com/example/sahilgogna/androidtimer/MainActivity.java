package com.example.sahilgogna.androidtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextCityName;
    int imageIds[] = {R.drawable.bangkok, R.drawable.barcelona, R.drawable.chicago, R.drawable.london, R.drawable.moscow, R.drawable.newyork,
            R.drawable.paris, R.drawable.tokyo};

    ImageView imageViewCity;
    ImageButton startButton, checkButton;
    int index;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){
        editTextCityName = findViewById(R.id.cityEdit);
        imageViewCity = findViewById(R.id.imageView);
        startButton = findViewById(R.id.btnStart);
        checkButton = findViewById(R.id.btnStop);
        result = findViewById(R.id.textView);
        startButton.setOnClickListener(this);
        checkButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnStart:
                StartTimer();
                break;

            case R.id.btnStop:
                checkResult();
                break;
        }

    }

    private void StartTimer(){
        CountDownTimer countDownTimer = new CountDownTimer(3000,500) {
            @Override
            public void onTick(long millisUntilFinished) {
                result.setText(null);
                editTextCityName.setText(null);
                Random random = new Random();
                index = random.nextInt(imageIds.length);
                imageViewCity.setImageResource(imageIds[index]);
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    private void checkResult(){
        int imageResourceId = getResources().getIdentifier("drawable/"+editTextCityName.getText().toString().toLowerCase(), null, getPackageName());

        if(imageResourceId==imageIds[index])
            result.setText("Bravo");
        else
            result.setText("Wrong");
    }

}
