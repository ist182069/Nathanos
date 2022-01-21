package jestb.nathanos;

import java.util.ArrayList;

public class Refresher {

    int thread_num;
    int time;
    String website;
    ArrayList<Blight> blightCaller = new ArrayList<Blight>();

    public Refresher(int thread_num, int time, String website) {
        System.out.println("Nathanos: Greetings \"Hacker\".");
        this.thread_num = thread_num;
        this.time = time;
        this.website = website;
    }

    public void prepare() {
        System.out.println("Nathanos: I am preparing " + this.thread_num + " Blight Throwers for " + this.website + ".");
        for(int i = 0; i < this.thread_num; i++) {
            Blight runnable = new Blight(i, this.website);
            blightCaller.add(runnable);
        }
    }
    public void execute() {
        System.out.println("Nathanos: The Blight is deployed!");
        for(int i = 0; i < this.thread_num; i++) {
            Blight blight = blightCaller.get(i);
            blight.start();
        }
        System.out.println("Nathanos: The Blight is up for " + this.time + " seconds.");
    }

    public void end() {
        try {
            Thread.sleep(1000*time);
            System.out.println("Nathanos: Our job here is done. Now just clean the mess.");
            for(int i = 0; i < this.thread_num; i++) {
                Blight blight = blightCaller.get(i);
                blight.stop();
            }
            System.out.println("Nathanos: Let us return to the Undercity... for now.");
        } catch (InterruptedException e) {
            ;
        }
    }
}
