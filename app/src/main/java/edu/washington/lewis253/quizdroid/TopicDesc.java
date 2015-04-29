package edu.washington.lewis253.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;


public class TopicDesc extends ActionBarActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_desc);

        String topic = getIntent().getExtras().getString("topic");
        String desc = getIntent().getExtras().getString("desc");
        int numQues = getIntent().getExtras().getInt("num");

        TextView t = (TextView)findViewById(R.id.topic);
        t.setText((CharSequence)topic);
        TextView d = (TextView)findViewById(R.id.desc);
        d.setText((CharSequence)desc);
        TextView n = (TextView)findViewById(R.id.num);
        n.setText((CharSequence)("This quiz has " + "" + numQues + " questions"));

        intent = new Intent(this, Question.class);
        intent.putExtra("topic", topic);
        intent.putExtra("qnum", 1);
        intent.putExtra("numcorr", 0);



        Button begin = (Button)findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topic_desc, menu);
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
