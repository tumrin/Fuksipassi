package com.example.fuksipassi;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    protected static boolean salli = false;
    private NfcAdapter nfcAdapter;
    protected static Switch vipu;
    protected static HashMap nimet = new HashMap();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vipu = (Switch) findViewById(R.id.Lisaa);

        //Laitetaan halutut Ville-tagi ID:t ja nimet
        //Korvataan tietokannalla myöhemmin
        nimet.put("", "");
        //Jokainen Checkbox pisteille erikseen
        //Tehdään paremmin kun ehditään
        final CheckBox piste = (CheckBox) findViewById(R.id.Piste);
        final CheckBox piste1 = (CheckBox) findViewById(R.id.piste);
        final CheckBox piste2 = (CheckBox) findViewById(R.id.piste2);
        final CheckBox piste3 = (CheckBox) findViewById(R.id.piste3);
        final CheckBox piste4 = (CheckBox) findViewById(R.id.piste4);
        final CheckBox piste5 = (CheckBox) findViewById(R.id.piste5);
        final CheckBox piste6 = (CheckBox) findViewById(R.id.piste6);
        final CheckBox piste8 = (CheckBox) findViewById(R.id.piste8);
        final CheckBox piste9 = (CheckBox) findViewById(R.id.piste9);
        piste.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste);
            }
        });
        piste1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste1);
            }
        });
        piste2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste2);
            }
        });
        piste3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste3);
            }
        });
        piste4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste4);
            }
        });
        piste5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste5);
            }
        });
        piste6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste6);
            }
        });
        piste8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste8);
            }
        });
        piste9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (salli == false) {
                    Toast.makeText(getApplicationContext(), "Lisää-tila ei käytössä", Toast.LENGTH_SHORT).show();
                }
                Pisteet.annaPiste(piste9);
            }
        });
        vipu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && salli == false) {
                    vipu.toggle();
                    Toast.makeText(getApplicationContext(), "Lue Ville-tagi", Toast.LENGTH_LONG).show();
                } else if (salli == true && isChecked == false) {
                    salli = false;
                }
            }
        });
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        //Tarkistetaan, onko NFC käytössä/tuettu
        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            Toast.makeText(this, "NFC saatavilla", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "NFC ei saatavilla", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        setIntent(intent);
        NfcLuku.resolveIntent(intent);
        if (nimet.get(NfcLuku.getTunnus()) != null) {
            Toast.makeText(this, "Ville-tagi: " + nimet.get(NfcLuku.getTunnus()), Toast.LENGTH_LONG).show();
            salli = true;
        } else {
            Toast.makeText(this, "Ville-tagi hylätty", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    protected void onResume() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        IntentFilter[] intentFilter = new IntentFilter[]{};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter, null);

        super.onResume();
    }

    @Override
    protected void onPause() {

        nfcAdapter.disableForegroundDispatch(this);

        super.onPause();
    }

}

