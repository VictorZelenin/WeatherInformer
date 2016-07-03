package dev.zelenin.weather_informer.view.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import dev.zelenin.weather_informer.JSONLoaderTask;
import dev.zelenin.weather_informer.R;
import dev.zelenin.weather_informer.weather_context.Weather;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        JSONLoaderTask task = new JSONLoaderTask();
        button.setOnClickListener(v -> {

            task.execute(validateText(text.getText().toString()));

            // intent -> weather
            try {
                Weather weather = task.get();
                Intent intent = new Intent(this, AdditionalActivity.class);
                // TODO send weather obj to another activity
                intent.putExtra("weather", weather);
                startActivity(intent);

            } catch (InterruptedException | ExecutionException e) {
                Toast.makeText(this, "Wrong input", Toast.LENGTH_LONG);
                e.printStackTrace();
            }
        });
    }

    private String validateText(String text) {
        String[] arr = text.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String str : arr) {
            builder.append(str).append("%20");
        }


        return builder.toString();
    }
}