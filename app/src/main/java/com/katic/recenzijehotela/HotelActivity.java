package com.katic.recenzijehotela;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class HotelActivity extends AppCompatActivity{

    private String naziv;
    private int rate;
    private String ulica;
    private String grad;
    private String opis;
    private int pic, pic2, pic3, pic4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hotel);

        naziv = getIntent().getStringExtra(MainActivity.NAZIV);
        rate = getIntent().getIntExtra(MainActivity.RATE,0);
        ulica = getIntent().getStringExtra(MainActivity.ULICA);
        grad = getIntent().getStringExtra(MainActivity.GRAD);
        opis = getIntent().getStringExtra(MainActivity.OPIS);
        pic = getIntent().getIntExtra(MainActivity.PIC,0);
        pic2 = getIntent().getIntExtra(MainActivity.PIC2,0);
        pic3 = getIntent().getIntExtra(MainActivity.PIC3,0);
        pic4 = getIntent().getIntExtra(MainActivity.PIC4,0);

        TextView textNaziv = (TextView) findViewById(R.id.naziv);
        TextView textUlica = (TextView) findViewById(R.id.ulica);
        TextView textGrad = (TextView) findViewById(R.id.grad);
        TextView textOpis = (TextView) findViewById(R.id.opis);
        ImageView imagePic = (ImageView) findViewById(R.id.pic);
        ImageView imagePic2 = (ImageView) findViewById(R.id.pic2);
        ImageView imagePic3 = (ImageView) findViewById(R.id.pic3);
        ImageView imagePic4 = (ImageView) findViewById(R.id.pic4);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(naziv);
        actionBar.setDisplayHomeAsUpEnabled(true);

        textNaziv.setText(naziv);
        ratingBar.setRating(rate);
        textUlica.setText(ulica);
        textGrad.setText(grad);
        textOpis.setText(opis);
        imagePic.setImageResource(pic);
        imagePic2.setImageResource(pic2);
        imagePic3.setImageResource(pic3);
        imagePic4.setImageResource(pic4);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }

}
