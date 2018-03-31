package tk.hireyesin.kijijiparserv3;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button1);
        textView = (TextView)findViewById(R.id.textView1);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void ClickMe(View v) {
        MyTask mt = new MyTask();
        mt.execute();
    }


    class MyTask extends AsyncTask<Void, Void, Void> {

        HttpParser hp=new HttpParser();
        String link="https://www.kijiji.ca/rss-srp-3-bedroom-apartments-condos/grand-montreal/lasalle/k0c215l80002?ad=offering";
        @Override
        protected Void doInBackground(Void... params) {


            hp.makeItemList(link);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
           ArrayList<Item> il = hp.getItemList();
//            for(Item i:il){
                //textView.append(i.toString());
            //Item testItem= new Item("a","b","c","d","e",1,2,3);

                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                intent.putParcelableArrayListExtra("items_list", il);
                startActivity(intent);
            //textView.setText("length: "+il.size());
        //    }

        }
    }
}

