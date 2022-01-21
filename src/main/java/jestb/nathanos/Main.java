package jestb.nathanos;

public class Main {

    public static final void main(String argv[])
    {
        int time = 20;
        int thread_num = 100;
        String website = "https://agml.pt/";
        Refresher refresher = new Refresher(thread_num, time, website);
        refresher.prepare();
        refresher.execute();
        refresher.end();
    }

}
