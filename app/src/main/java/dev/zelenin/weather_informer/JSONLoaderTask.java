package dev.zelenin.weather_informer;

import android.os.AsyncTask;

import dev.zelenin.weather_informer.parsers.HttpParser;
import dev.zelenin.weather_informer.parsers.JSONParser;
import dev.zelenin.weather_informer.weather_context.Weather;

/**
 * Created by victor on 01.07.16.
 */
public class JSONLoaderTask extends AsyncTask<String, Void, Weather> {

    @Override
    protected Weather doInBackground(String... params) {
        HttpParser httpParser = new HttpParser();

        String data = httpParser.getWeatherData(params[0]);
        Weather weather = new JSONParser(data).getWeather();

//        weather.setImage(httpParser.getImage(weather.getCurrentCondition().getImageCode()));

        return weather;
    }

}
