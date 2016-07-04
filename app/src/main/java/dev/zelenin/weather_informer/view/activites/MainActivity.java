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
import dev.zelenin.weather_informer.view.fragments.StartingFragment;
import dev.zelenin.weather_informer.weather_context.Weather;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartingFragment startingFragment = new StartingFragment();

        getFragmentManager().beginTransaction()
                .add(R.id.main_container, startingFragment)
                .addToBackStack(null)
                .commit();

    }

}