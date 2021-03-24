package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openCarouselActivity();
    }




    public void openCarouselActivity(){
        Intent intent = new Intent(this, CarouselActivity.class);
        startActivity(intent);
    }
}