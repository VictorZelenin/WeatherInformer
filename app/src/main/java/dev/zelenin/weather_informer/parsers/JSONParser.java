package dev.zelenin.weather_informer.parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dev.zelenin.weather_informer.weather_context.CurrentCondition;
import dev.zelenin.weather_informer.weather_context.GeographicCoordinates;
import dev.zelenin.weather_informer.weather_context.Location;
import dev.zelenin.weather_informer.weather_context.Temperature;
import dev.zelenin.weather_informer.weather_context.Weather;
import dev.zelenin.weather_informer.weather_context.weather_states.Clouds;
import dev.zelenin.weather_informer.weather_context.weather_states.Rain;
import dev.zelenin.weather_informer.weather_context.weather_states.Snow;
import dev.zelenin.weather_informer.weather_context.weather_states.Wind;

/**
 * Created by victor on 01.07.16.
 */
public class JSONParser {
    private JSONObject rootObject;
    private JSONArray weatherArray;

    public JSONParser(String data) {
        try {
            rootObject = new JSONObject(data);
            weatherArray = rootObject.getJSONArray("weather");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Weather getWeather() {
        Weather weather = new Weather();

        Location location = parseLocation();
        CurrentCondition condition = parseCondition();
        Temperature temperature = parseTemperature();
        Clouds clouds = parseClouds();
        Wind wind = parseWind();

        weather.setLocation(location);
        weather.setCurrentCondition(condition);
        weather.setTemperature(temperature);
        weather.setWind(wind);

        switch (condition.getMainDescription()) {
            case "Clouds":
                weather.setClouds(clouds);
                break;
            case "Rain":
//                weather.setRain(null);
                weather.setRain(true);
                break;
            case "Snow":
                weather.setSnow(parseSnow());
                break;
            default:
                weather.setClouds(clouds);
                break;
        }

        return weather;
    }

    private Location parseLocation() {
        Location location = new Location();
        GeographicCoordinates coordinates = new GeographicCoordinates();

        try {
            JSONObject coordObject = getObject("coord", rootObject);
            JSONObject sysObject = getObject("sys", rootObject);

            coordinates.setLatitude(getDouble("lat", coordObject));
            coordinates.setLongitude(getDouble("lon", coordObject));

            location.setCountryName(getString("country", sysObject));
            location.setSunrise(getLong("sunrise", sysObject));
            location.setSunset(getLong("sunset", sysObject));

            location.setCityName(getString("name", rootObject));

            location.setCoordinates(coordinates);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return location;
    }

    private CurrentCondition parseCondition() {
        CurrentCondition condition = new CurrentCondition();

        try {
            JSONObject weatherObject = weatherArray.getJSONObject(0);
            JSONObject mainObject = getObject("main", rootObject);

            condition.setWeatherId(getInt("id", weatherObject));
            condition.setMainDescription(getString("main", weatherObject));
            condition.setAdditionalDescription(getString("description", weatherObject));
            condition.setImageCode(getString("icon", weatherObject));
            condition.setHumidity(getInt("humidity", mainObject));
            condition.setPressure(getDouble("pressure", mainObject));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return condition;
    }

    public Temperature parseTemperature() {
        Temperature temperature = new Temperature();

        try {
            JSONObject mainObject = getObject("main", rootObject);

            temperature.setAverageTemperature(getDouble("temp", mainObject));
            temperature.setMinTemperature(getDouble("temp_min", mainObject));
            temperature.setMaxTemperature(getDouble("temp_max", mainObject));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temperature;
    }

    private Clouds parseClouds() {
        Clouds clouds = new Clouds();

        try {
            JSONObject cloudsObject = getObject("clouds", rootObject);

            clouds.setCloudiness(getDouble("all", cloudsObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return clouds;
    }

    private Wind parseWind() {
        Wind wind = new Wind();

        try {
            JSONObject windObject = getObject("wind", rootObject);

            wind.setWindSpeed(getDouble("speed", windObject));
            wind.setWindDirection(getDouble("deg", windObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return wind;
    }

    private Rain parseRain() {
        Rain rain = new Rain();

        try {
            JSONObject rainObject = getObject("rain", rootObject);

            rain.setRainVolume(getDouble("3h", rainObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rain;
    }

    private Snow parseSnow() {
        Snow snow = new Snow();

        try {
            JSONObject snowObject = getObject("snow", rootObject);

            snow.setSnowVolume(getDouble("3h", snowObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return snow;
    }

    private int getInt(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getInt(tagName);
    }

    private long getLong(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getLong(tagName);
    }

    private double getDouble(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getDouble(tagName);
    }

    private JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getJSONObject(tagName);
    }

    private String getString(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getString(tagName);
    }
}
