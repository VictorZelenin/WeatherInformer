package dev.zelenin.weather_informer;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import dev.zelenin.weather_informer.parsers.HttpParser;
import dev.zelenin.weather_informer.parsers.JSONParser;
import dev.zelenin.weather_informer.weather_context.Weather;

/**
 * Created by victor on 01.07.16.
 */
public class JSONLoaderTask extends AsyncTask<String, Void, Weather> {

    private ImageView image;

    @Override
    protected Weather doInBackground(String... params) {
        HttpParser parser = new HttpParser();


        String data = parser.getWeatherData(params[0]);
        Weather weather = new JSONParser(data).getWeather();

//        weather.setImage(parser.getImage(weather.getCurrentCondition().getImageCode()));
        InputStream in = null;
        try {
            in = new URL("http://openweathermap.org/img/w/" +
                    weather.getCurrentCondition().getImageCode() + ".png").openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        weather.setBitmap(BitmapFactory.decodeStream(in));
        return weather;
    }

}
