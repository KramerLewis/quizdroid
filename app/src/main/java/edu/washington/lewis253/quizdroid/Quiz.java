package edu.washington.lewis253.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Quiz extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String topic = getIntent().getExtras().getString("topic");
        String desc = getIntent().getExtras().getString("desc");
        int numQues = getIntent().getExtras().getInt("num");



        if (savedInstanceState == null) {

            FragmentManager m = getFragmentManager();
            FragmentTransaction t = m.beginTransaction();

            Bundle b = new Bundle();
            b.putString("topic", topic);
            b.putString("desc", desc);
            b.putInt("num", numQues);

            TopicDescription d = new TopicDescription();
            d.setArguments(b);

            t.add(R.id.container, d);
            t.commit();


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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
