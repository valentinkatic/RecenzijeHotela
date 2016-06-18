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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hotel);

        //Dodjeljivanje varijabli primljenim vrijednostima iz prethodnog Activity-a
        String naziv = getIntent().getStringExtra(MainActivity.NAZIV);
        int rate = getIntent().getIntExtra(MainActivity.RATE,0);
        String ulica = getIntent().getStringExtra(MainActivity.ULICA);
        String grad = getIntent().getStringExtra(MainActivity.GRAD);
        String opis = getIntent().getStringExtra(MainActivity.OPIS);
        int pic = getIntent().getIntExtra(MainActivity.PIC,0);
        int pic2 = getIntent().getIntExtra(MainActivity.PIC2,0);
        int pic3 = getIntent().getIntExtra(MainActivity.PIC3,0);
        int pic4 = getIntent().getIntExtra(MainActivity.PIC4,0);

        //Dodjeljivanje varijabli objektima s layout-a
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

        //Postavljanje vrijednosti objektima
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
