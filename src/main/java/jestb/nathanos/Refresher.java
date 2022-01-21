package jestb.nathanos;

import java.util.ArrayList;

public class Refresher {

    int thread_num;
    int time;
    String website;
    ArrayList<Blight> blightCaller = new ArrayList<Blight>();
    ArrayList<Thread> putriss = new ArrayList<Thread>();

    public Refresher(int thread_num, int time, String website) {
        this.thread_num = thread_num;
        this.time = time;
        this.website = website;
    }

    public void prepare() {
        for(int i = 0; i < this.thread_num; i++) {
            Blight runnable = new Blight(i, this.website);
            blightCaller.add(runnable);
        }
    }
    public void execute() {
        for(int i = 0; i < this.thread_num; i++) {
            Blight attack = blightCaller.get(i);
            Thread apothecary = new Thread(attack);
            putriss.add(apothecary);
            apothecary.start();
        }
    }

    public void end() {
        try {
            Thread.sleep(1000*time);
            for(int i = 0; i < this.thread_num; i++) {
                Thread apothecary = putriss.get(i);
                apothecary.stop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
