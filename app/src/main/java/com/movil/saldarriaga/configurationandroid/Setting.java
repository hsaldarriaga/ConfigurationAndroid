package com.movil.saldarriaga.configurationandroid;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * Created by hass-pc on 04/03/2015.
 */
public class Setting extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int version = Build.VERSION.SDK_INT;
        if (version >= Build.VERSION_CODES.HONEYCOMB) {
            Initialize();
        } else {
            Initialize9(); 
        }
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void Initialize() {
        getFragmentManager().beginTransaction().replace(android.R.id.content, new Preferencefragment()).commit();
    }

    @SuppressWarnings("deprecation")
    private void Initialize9() {
        addPreferencesFromResource(R.xml.xmlsetting);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class Preferencefragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.xmlsetting);
        }
    }
}
