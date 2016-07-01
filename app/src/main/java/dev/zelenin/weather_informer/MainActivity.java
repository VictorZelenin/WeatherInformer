package dev.zelenin.weather_informer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import dev.zelenin.weather_informer.parsers.HttpParser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView view = (TextView) findViewById(R.id.textView);

        JSONLoaderTask task = new JSONLoaderTask();
        task.execute();

        try {
            view.setText(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
