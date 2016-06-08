package com.katic.recenzijehotela;


/**
 *  Spremi informacije o hotelu.
 */

public class Hotel{
    private String naziv;
    private int rate;
    private String ulica;
    private String grad;
    private String opis;
    private int pic;
    private int pic2;
    private int pic3;
    private int pic4;

    public Hotel(String naziv, int rate, String ulica, String grad, String opis, int pic, int pic2, int pic3, int pic4) {
        this.naziv = naziv;
        this.rate = rate;
        this.ulica = ulica;
        this.grad = grad;
        this.opis = opis;
        this.pic = pic;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.pic4 = pic4;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getRate() {
        return rate;
    }

    public String getUlica() {
        return ulica;
    }

    public String getGrad() {
        return grad;
    }

    public String getOpis() {
        return opis;
    }

    public int getPic() {
        return pic;
    }

    public int getPic2() {
        return pic2;
    }

    public int getPic3() {
        return pic3;
    }

    public int getPic4() {
        return pic4;
    }
}
