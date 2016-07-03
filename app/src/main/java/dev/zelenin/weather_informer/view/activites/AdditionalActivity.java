package dev.zelenin.weather_informer.view.activites;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import dev.zelenin.weather_informer.R;
import dev.zelenin.weather_informer.view.fragments.CurrentWeatherFragment;
import dev.zelenin.weather_informer.weather_context.Weather;

public class AdditionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);

//        Weather weather = ;
        CurrentWeatherFragment currentWeatherFragment = new CurrentWeatherFragment();
        Bundle args = new Bundle();
        args.putParcelable("weather", getIntent().getParcelableExtra("weather"));

        currentWeatherFragment.setArguments(args);

        getFragmentManager().beginTransaction()
                .add(R.id.main_container, currentWeatherFragment)
                .addToBackStack(null)
                .commit();

//        System.out.println(weather);
    }
}
