package dev.zelenin.weather_informer.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import dev.zelenin.weather_informer.weather_context.CurrentCondition;
import dev.zelenin.weather_informer.weather_context.GeographicCoordinates;
import dev.zelenin.weather_informer.weather_context.Location;
import dev.zelenin.weather_informer.weather_context.Temperature;
import dev.zelenin.weather_informer.weather_context.Weather;

/**
 * Created by victor on 01.07.16.
 */
public class JSONParser {
    private JSONObject rootObject;

    public JSONParser(String data) {
        try {
            rootObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Weather getWeather() {
        return null;
    }

    public Location parseLocation() {
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

    public CurrentCondition parseCondition() {
        CurrentCondition condition = new CurrentCondition();

        try {
            JSONObject weatherObject = getObject("weather", rootObject);
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

//    public Temperature parseTemperature(){}

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
