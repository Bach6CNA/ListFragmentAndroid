package com.richpolissystems.android.saintseya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imgPoster = (ImageView) findViewById(R.id.img_poster);

        int poster = getIntent().getIntExtra("poster",R.drawable.cz_torneo_galactico);

        imgPoster.setImageResource(poster);

    }


}
