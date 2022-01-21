package jestb.nathanos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class Blight implements Runnable {

    private int id;
    private final AtomicBoolean phylactery = new AtomicBoolean(false);
    private String website;
    private Thread worker;

    public Blight(int id, String website) {
        this.id = id;
        this.website = website;
    }

    @Override
    public void run() {
        //System.out.println("Blight Thrower " + this.id + ": Blighting " + this.website);
        phylactery.set(true);
        while(phylactery.get()) {
            try {
                Thread.sleep(1);
                blightCall();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Blight Thrower: I was interrupted!");
            }
        }
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        phylactery.set(false);
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
            //System.out.println("Blight Thrower " + this.id + ": Website: " + this.website + " has been blighted!");
            ;
        }
    }
}
