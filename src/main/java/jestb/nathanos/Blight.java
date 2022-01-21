package jestb.nathanos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Blight implements Runnable {

    int id;
    String website;

    public Blight(int id, String website) {
        this.id = id;
        this.website = website;
    }

    @Override
    public void run() {
        System.out.println("Blighter " + this.id + " blighting website: " + this.website);
        while(true) {
            blightCall();
        }
    }

    public void blightCall() {
        try {
            URL critter = new URL(this.website);
            HttpURLConnection connection = (HttpURLConnection) critter.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Blightcaller");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("The Blight Caller feigned death!");
        }
    }
}
