package dev.zelenin.weather_informer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import dev.zelenin.weather_informer.weather_context.Weather;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView view = (TextView) findViewById(R.id.textView);
        EditText text = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        JSONLoaderTask task = new JSONLoaderTask();
        button.setOnClickListener(v -> {

            task.execute(text.getText().toString());

            try {
                Weather weather = task.get();
                System.out.println(weather);
                view.setText(weather.getLocation().getCityName() + "  temp: " + weather.getTemperature());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}