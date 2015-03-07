package com.movil.saldarriaga.configurationandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preference.getString(getString(R.string.Nombre),"");
        String lastname = preference.getString(getString(R.string.Edad),"");
        String genre = preference.getString(getString(R.string.Genero),"");
        TextView n,l,g;
        n = (TextView) findViewById(R.id.name);
        l = (TextView) findViewById(R.id.lastname);
        g = (TextView) findViewById(R.id.genre);

        n.setText(name);
        l.setText(lastname);
        g.setText(genre);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intt = new Intent(this, Setting.class);
            startActivity(intt);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
