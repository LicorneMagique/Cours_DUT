package com.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new JsonGetter().execute("http://perso.univ-lyon1.fr/lionel.buathier/carburants/PrixCarburants_instantane.json");
    }
}
