package com.example.myfil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText text;
    TextView paste;
    String str,st1;

    /**
     * @author Eviatar dadon
     * @since 28/12/2019
     * @version alpha
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text =(EditText) findViewById(R.id.text);
        paste =(TextView) findViewById(R.id.paste);

        try {
            FileInputStream fis= openFileInput("test.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            st1 = br.readLine();
            paste.setText(st1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

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
     * here you move to credit activity
     * @param menu
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem menu) {
        String st = menu.getTitle().toString();
        if ((st.equals("credits"))) {
            Intent si = new Intent(this, credits.class);
            startActivity(si);
        }
        return true;
    }

    /**
     * this method put the changes to the 'collection' and saves them there.
     */
    public void savebtn(View view) throws IOException {
        str= text.getText().toString();
        if (!str.contentEquals("null")){
            try {
                FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                if(st1!=null){
                    st1= st1+str;}
                else{st1=str;}
                bw.write(st1);
                bw.close();
                paste.setText(st1);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }}

    }

    /**
     * this method resets all the collection and  the settings
     */
    public void reset(View view) {
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            st1="";
            bw.write(st1);
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        text.setText("");
        paste.setText("");
    }

    /**
     * buffer creation
     * writing to the file end close the file
     * this method saves the data that was entered (in files) and exits the app.
     */
    public void exit(View view) {
        str= text.getText().toString();
        if(!str.contentEquals("null")){
            try {
                FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                if(st1!=null){
                    st1= st1+str;}
                else{st1=str;}
                bw.write(st1);
                bw.close();
                paste.setText(st1);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finish();}
    }
}