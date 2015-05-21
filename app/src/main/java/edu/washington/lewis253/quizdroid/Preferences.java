package edu.washington.lewis253.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.SharedPreferences.*;
import android.view.View;
import android.widget.*;


public class Preferences extends ActionBarActivity {

    QuizApp app;
    Editor editor;
    EditText urlText;
    EditText frequencyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        app = (QuizApp) getApplication();
        editor = app.prefs.edit();
        urlText = (EditText) findViewById(R.id.url);
        frequencyText = (EditText) findViewById(R.id.freq);
        if(app.prefs.contains("url")) {
            urlText.setText((CharSequence) app.prefs.getString("url", ""));
        }
        if(app.prefs.contains("freq")) {
            frequencyText.setText((CharSequence) ("" + app.prefs.getInt("freq", 5)));
        }
        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("url", urlText.getText().toString());
                editor.putInt("freq", Integer.parseInt(frequencyText.getText().toString()));
                editor.commit();
                finish();
            }
        });
        Button cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
