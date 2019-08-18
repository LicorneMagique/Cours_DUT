package fr.olivierpautrat.tp4;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> ar = new ArrayList<>();
    ContactAdapter ada;
    final static int code = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.LISTE);
        // ar.add(new Contact("Corentin", "Debrabant", Genre.Autre, "0742424242",
        // "corentin.debra@gmail.com", "1 bis Avenue Albert Einstein", 69100, ""));
        // ar.add(new Contact("z","a", Genre.Autre, "0", "a@a.c", "1 ar", 89440,
        // "estdrftg"));
        ada = new ContactAdapter(getApplicationContext(), ar);
        listView.setAdapter(ada);
        if (ar.size() == 0)
            ((TextView) findViewById(R.id.empty)).setVisibility(View.VISIBLE);
        else
            ((TextView) findViewById(R.id.empty)).setVisibility(View.INVISIBLE);
    }

    public void addSomeone(View view) {
        Intent moveIntent = new Intent(MainActivity.this, AddSomeoneActivity.class);
        startActivityForResult(moveIntent, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            Contact a = (Contact) (data.getSerializableExtra("contact"));
            ar.add(a);
            ada.notifyDataSetChanged();
        }

        if (ar.size() == 0)
            ((TextView) findViewById(R.id.empty)).setVisibility(View.VISIBLE);
        else
            ((TextView) findViewById(R.id.empty)).setVisibility(View.INVISIBLE);

        super.onActivityResult(requestCode, resultCode, data);
    }
}
