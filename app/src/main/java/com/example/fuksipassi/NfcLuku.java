package com.example.fuksipassi;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Parcelable;

public class NfcLuku {
    private static String tunnus;

    protected static void resolveIntent(Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            dumpTagData(tag).getBytes();
        }
    }

    //Hankitaan tunnus tagista
    private static String dumpTagData(Tag tag) {
        byte[] id = tag.getId();
        tunnus = String.valueOf(toDec(id));
        return tunnus;
    }

    //Palauttaa tunnuksen desimaalimuodossa
    public static String getTunnus() {
        return tunnus;
    }

    //Muunnetaan tunnus desimaalimuotoon
    private static long toDec(byte[] bytes) {
        long result = 0;
        long factor = 1;
        for (int i = 0; i < bytes.length; ++i) {
            long value = bytes[i] & 0xffl;
            result += value * factor;
            factor *= 256l;
        }
        return result;
    }
}
