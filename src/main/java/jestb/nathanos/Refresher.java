package jestb.nathanos;

import java.util.ArrayList;

public class Refresher {

    int thread_num;
    String website;
    ArrayList<Blight> blightCaller = new ArrayList<Blight>();

    public Refresher(int thread_num, String website) {
        this.thread_num = thread_num;
        this.website = website;
    }

    public void prepare() {
        for(int i = 0; i < this.thread_num; i++) {
            Blight threader = new Blight(i, this.website);
            blightCaller.add(threader);
        }
    }
    public void execute() {
        for(int i = 0; i < this.thread_num; i++) {
            Blight attack = blightCaller.get(i);
            Thread apothecary = new Thread(attack);
            apothecary.start();
        }
    }
}
