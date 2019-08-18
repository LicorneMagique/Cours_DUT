package fr.olivierpautrat.tp4;

import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddSomeoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_someone);

        ((RadioGroup) this.findViewById(R.id.gender))
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        findViewById(R.id.gender).setBackgroundColor(Color.TRANSPARENT);
                    }
                });
    }

    public void Add(View view) {
        boolean incomplete = false;
        if (((TextView) findViewById(R.id.name)).getText().toString().equals("")) {
            incomplete = true;
            ((TextView) findViewById(R.id.name)).setHintTextColor(getResources().getColor(R.color.colorError, null));
        }
        if (((TextView) findViewById(R.id.fname)).getText().toString().equals("")) {
            incomplete = true;
            ((TextView) findViewById(R.id.fname)).setHintTextColor(getResources().getColor(R.color.colorError, null));
        }
        if (((RadioGroup) findViewById(R.id.gender)).getCheckedRadioButtonId() == -1) {
            incomplete = true;
            findViewById(R.id.gender).setBackgroundColor(getResources().getColor(R.color.colorError, null));
        }
        if (((TextView) findViewById(R.id.phone)).getText().toString().equals("")) {
            incomplete = true;
            ((TextView) findViewById(R.id.phone)).setHintTextColor(getResources().getColor(R.color.colorError, null));
        }
        if (((TextView) findViewById(R.id.email)).getText().toString().equals("")) {
            incomplete = true;
            ((TextView) findViewById(R.id.email)).setHintTextColor(getResources().getColor(R.color.colorError, null));
        }
        if (((TextView) findViewById(R.id.address)).getText().toString().equals("")) {
            incomplete = true;
            ((TextView) findViewById(R.id.address)).setHintTextColor(getResources().getColor(R.color.colorError, null));
        }
        if (((TextView) findViewById(R.id.ZIPCode)).getText().toString().equals("")) {
            incomplete = true;
            ((TextView) findViewById(R.id.ZIPCode)).setHintTextColor(getResources().getColor(R.color.colorError, null));
        }

        if (incomplete)
            return;

        Intent i = new Intent();
        i.putExtra("contact",
                new Contact(((TextView) findViewById(R.id.name)).getText().toString(),
                        ((TextView) findViewById(R.id.fname)).getText().toString(), Genre.Autre,
                        ((TextView) findViewById(R.id.phone)).getText().toString(),
                        ((TextView) findViewById(R.id.email)).getText().toString(),
                        ((TextView) findViewById(R.id.address)).getText().toString(),
                        Integer.parseInt(((TextView) findViewById(R.id.ZIPCode)).getText().toString()), ""));
        this.setResult(RESULT_OK, i);

        this.finish();
    }
}
