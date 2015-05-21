package edu.washington.lewis253.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import java.util.*;
import android.content.SharedPreferences;


public class MainActivity extends ActionBarActivity {

    List<Topic> topics;
    private ListView list;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        QuizApp app = (QuizApp) getApplication();
        topics = app.getAllTopics();
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for(Topic t : topics) {
            Map<String, String> toAdd = new HashMap<String, String>();
            toAdd.put("title", t.title);
            toAdd.put("desc", t.sDesc);
            data.add(toAdd);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data,
                                                    R.layout.topic_list_item,
                                                    new String[] {"title", "desc"},
                                                    new int[] {R.id.title, R.id.desc});


        /*topics = new HashMap<String, String>();
        topics.put("Math", "This quiz contains questions about Mathematics");
        topics.put("Physics","This quiz contains questions about physics");
        topics.put("Marvel Super Heroes", "This quiz contains questions regarding the Marvel Super Heroes");*/

        intent = new Intent(this, Quiz.class);

        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        //String[] topicNames = topics.keySet().toArray(new String[topics.keySet().size()]);

        //ArrayAdapter<String> items = new ArrayAdapter<String>(this, R.layout.topic_list_item, topicNames);
        //list.setAdapter(items);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LinearLayout layout = (LinearLayout) view;
                TextView t = (TextView)layout.getChildAt(0);
                String chosen = t.getText().toString();

                intent.putExtra("topic", chosen);
                /*intent.putExtra("desc", topics.get(chosen));
                intent.putExtra("num", 2);*/

                startActivity(intent);
            }
        });


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
            Intent i = new Intent(this, Preferences.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
