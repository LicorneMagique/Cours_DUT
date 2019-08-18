package com.projet;

import java.util.ArrayList;

public class Station {
    public String adresse;
    public ArrayList<Carburant> carburants;

    public Station(String adresse) {
        this.adresse = adresse;
        carburants = new ArrayList<Carburant>();
    }

    public void addCarburant(String nom, double prix)
    {
        carburants.add(new Carburant(nom, prix));
    }

}
