package com.example.myfil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class credits extends AppCompatActivity {

    /**
     * set the options menu
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     *  jump to the main activity
     * @param menu
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem menu) {
        String st = menu.getTitle().toString();
        if ((st.equals("main activity"))) {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
}