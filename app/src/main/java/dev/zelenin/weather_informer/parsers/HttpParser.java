package dev.zelenin.weather_informer.parsers;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by victor on 01.07.16.
 */
public class HttpParser {
    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static String IMG_URL = "http://openweathermap.org/img/w/";
    private static String WEATHER_API_ID = "APPID=5ba7c7ad1631d0b2d797b0ab0fabdd67";
    private static String ICON_EXTENSION = ".png";

    public String getWeatherData(String location) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            connection = (HttpURLConnection) new URL(BASE_URL + location + "&" + WEATHER_API_ID)
                    .openConnection();

            System.out.println(BASE_URL + location + "&" + WEATHER_API_ID);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            // Let's read the response
            StringBuffer buffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line + "rn");
            }

            return buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            connection.disconnect();
        }

        return null;
    }

    public byte[] getImage(String code) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            connection = (HttpURLConnection) new URL(IMG_URL + code + ICON_EXTENSION).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();

            while (inputStream.read() != -1) {
                byteArrayInputStream.write(buffer);
            }

            return byteArrayInputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            connection.disconnect();
        }

        return null;
    }
}
