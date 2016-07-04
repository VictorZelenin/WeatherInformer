package dev.zelenin.weather_informer.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import dev.zelenin.weather_informer.JSONLoaderTask;
import dev.zelenin.weather_informer.R;
import dev.zelenin.weather_informer.weather_context.Weather;

/**
 * Created by victor on 04.07.16.
 */
public class StartingFragment extends Fragment {

    private static final String SPACE_CODE = "%20";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedState) {
        return inflater.inflate(R.layout.starting_fragment, container, false);
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        Button button = (Button) getView().findViewById(R.id.button2);
        EditText cityName = (EditText) getView().findViewById(R.id.editText2);

        button.setOnClickListener(view -> {
            JSONLoaderTask task = new JSONLoaderTask();
            task.execute(validateText(cityName.getText().toString()));

            try {
                Weather weather = task.get();

                CurrentWeatherFragment weatherFragment = new CurrentWeatherFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("weather", weather);

                weatherFragment.setArguments(bundle);

                getFragmentManager().beginTransaction().
                        replace(R.id.main_container, weatherFragment)
                        .addToBackStack(null)
                        .commit();


            } catch (InterruptedException | ExecutionException e) {
                Toast.makeText(this.getActivity(), "Wrong input", Toast.LENGTH_LONG);
                e.printStackTrace();
            }

        });
    }

    private String validateText(String text) {
        String[] arr = text.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String str : arr) {
            builder.append(str).append(SPACE_CODE);
        }

        return builder.toString();
    }

}
