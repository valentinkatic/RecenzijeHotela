package com.katic.recenzijehotela;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Hotel> listaHotela = new ArrayList<Hotel>();
    public final static String NAZIV = "com.katic.recenzijehotela.NAZIV";
    public final static String RATE = "com.katic.recenzijehotela.RATE";
    public final static String ULICA = "com.katic.recenzijehotela.ULICA";
    public final static String GRAD = "com.katic.recenzijehotela.GRAD";
    public final static String OPIS = "com.katic.recenzijehotela.OPIS";
    public final static String PIC = "com.katic.recenzijehotela.PIC";
    public final static String PIC2 = "com.katic.recenzijehotela.PIC2";
    public final static String PIC3 = "com.katic.recenzijehotela.PIC3";
    public final static String PIC4 = "com.katic.recenzijehotela.PIC4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateHotelList();
        populateListView();

    }

    private void populateHotelList() {
        listaHotela.add(new Hotel("Hotel Osijek", 4, "Šamačka 4", "31000 Osijek", "U centru Osijeka, u srcu pješačke zone grada smješten je hotel Osijek, na najdužoj i najljepšoj riječnoj šetnici u Hrvatskoj.\n" +
                "Svojom ponudom hotel će unijeti dašak luksuza u svako Vaše putovanje, bilo da ste izbirljiv poslovni gost ili Vas je do Osijeka dovelo istraživanje turističke ponude ovih krajeva.", R.drawable.osijek, R.drawable.osijek2, R.drawable.osijek3, R.drawable.osijek4));
        listaHotela.add(new Hotel("Hotel Waldinger", 4, "Županijska ulica 8", "31000 Osijek", "Hotel Waldinger prvi je hotel sa četiri zvjezdice u Osijeku, a sastavni mu je dio i Depadansa Waldinger s tri zvjezdice. Smješten je u Županijskoj ulici, na najljepšoj lokaciji u samom središtu grada. Stogodišnja secesijska zgrada Hotela Waldinger zaštićena je kao kulturni i ambijentalni spomenik koju je projektirao i reljefnom ornametikom oplemenio arhitekt i kipar Antun Slaviček, umjetnik osječke secesije.", R.drawable.waldinger, R.drawable.waldinger2, R.drawable.waldinger3, R.drawable.waldinger4));
        listaHotela.add(new Hotel("Hotel Zoo", 4, "Sjevernodravska obala BB", "31000 Osijek", "Hotel ZOO je jedini hotel sa 4 zvjezdice ekskluzivno smješten tik uz lijevu obalu rijeke Drave, u neposrednoj blizini čarobno mirne okoline zelenila, vode i dugih šetnica.Idealna pozicija čini ovaj hotel mjestom gdje svaki gost može pronaći nešto za sebe, bilo to u smislu aktivnog odmora ili željenog mira i opuštanja nakon napornog tjedna.", R.drawable.zoo, R.drawable.zoo2, R.drawable.zoo3, R.drawable.zoo4));
        listaHotela.add(new Hotel("Vienna Apartments", 4, "Ulica Stjepana Radića 26a", "31000 Osijek", "Apartmani Vienna nude smještajne jedinice u mirnom okružju u središtu Osijeka. Opremljeni su klima-uređajem i besplatnim bežičnim pristupom internetu. U okviru objekta nalazi se prostrano dvorište s ribnjakom i fontanom.", R.drawable.vienna, R.drawable.vienna2, R.drawable.vienna3, R.drawable.vienna4));
        listaHotela.add(new Hotel("Hotel Vila Ariston", 3, "Zrinjevac, Kačićeva 6", "31000 Osijek", "Hotel Vila Ariston smješten je u središtu grada, na Zrinjevcu u Kačićevoj ulici, u neposrednoj blizini glavnog željezničkog i autobusnog kolodvora. Hotel Vila Ariston prikladan je za smještaj poslovnih ljudi, kao i za održavanje poslovnih sastanaka. Iako je nominalno kategoriziran s tri zvjezdice, realno svojim interijerom nadmašuje kategoriju s četiri zvjezdice. Hotel Vila Ariston je i hotel 4 dijamanta.", R.drawable.vilaariston, R.drawable.vilaariston2, R.drawable.vilaariston3, R.drawable.vilaariston4));
        listaHotela.add(new Hotel("Hotel Drava", 3, "I.Gundulića 25a", "31000 Osijek", "Hotel Drava smješten je na jedinstvenom položaju u središtu grada. Samo nekoliko minuta od autobusnog i željezničkog kolodvora, u neposrednoj blizini glavnih turističkih atrakcija i gradskih znamenitosti.", R.drawable.drava, R.drawable.drava2, R.drawable.drava3, R.drawable.drava4));
        listaHotela.add(new Hotel("Hotel Silver", 3, "Martina Divalta 84", "31000 Osijek", "Hotel Silver je obiteljski, luksuzno uređeni hotel smješten u neposrednoj blizini Gradskog vrta, sportske dvorane, zatvorenih bazena, shoping centra, te samo 2.000 metara udaljen od središta grada.", R.drawable.silver, R.drawable.silver2, R.drawable.silver3, R.drawable.silver4));
        listaHotela.add(new Hotel("Hotel Central", 2, "Trg A. Starčevića 6", "31000 Osijek", "Najstariji osječki hotel, svečano je otvoren 30. studenog davne 1889. godine kada je nosio ime \"Zum goldenem Kreutz\" (kod Zlatnoga križa). Hotel Central simbol je tradicije ovog lijepog grada, i danas, 120 godina nakon što je otvorio svoja vrata, zauzima posebno mjesto u kulturnom i poslovnom životu grada.", R.drawable.central, R.drawable.central2, R.drawable.central3, R.drawable.central4));
    }


    private void populateListView() {
        ArrayAdapter<Hotel> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.hoteliListView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(onListClick);
    }

    private class MyListAdapter extends ArrayAdapter<Hotel>  {
        public MyListAdapter() {
            super(MainActivity.this, R.layout.item_view, listaHotela);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //provjera jel imamo View s kojim ćemo raditi
            View itemView = convertView;
            if (itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            //Hotel s kojim trenutno radimo
            Hotel currentHotel = listaHotela.get(position);

            //Popuni view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.slikaHotela);
            imageView.setImageResource(currentHotel.getPic());

            TextView nazivText = (TextView) itemView.findViewById(R.id.naziv);
            nazivText.setText(currentHotel.getNaziv());

            TextView gradText = (TextView) itemView.findViewById(R.id.grad);
            gradText.setText(currentHotel.getGrad());

            TextView ulicaText = (TextView) itemView.findViewById(R.id.ulica);
            ulicaText.setText(currentHotel.getUlica());

            //return super.getView(position, convertView, parent);

            return itemView;
        }
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, HotelActivity.class);

            intent.putExtra(NAZIV, listaHotela.get(position).getNaziv());
            intent.putExtra(RATE, listaHotela.get(position).getRate());
            intent.putExtra(ULICA, listaHotela.get(position).getUlica());
            intent.putExtra(GRAD, listaHotela.get(position).getGrad());
            intent.putExtra(OPIS, listaHotela.get(position).getOpis());
            intent.putExtra(PIC, listaHotela.get(position).getPic());
            intent.putExtra(PIC2, listaHotela.get(position).getPic2());
            intent.putExtra(PIC3, listaHotela.get(position).getPic3());
            intent.putExtra(PIC4, listaHotela.get(position).getPic4());

            startActivity(intent);
        }
    };

}

