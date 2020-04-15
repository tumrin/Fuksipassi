package com.example.fuksipassi;

import android.widget.CheckBox;
import android.widget.Toast;

public class Pisteet extends  MainActivity{
    public static void annaPiste(CheckBox piste) {
        if (vipu.isChecked() && salli == true) {
            piste.setText(nimet.get(NfcLuku.getTunnus()).toString());
            //ok
        } else {
            ((CheckBox) piste).toggle();
        }
    }
}
