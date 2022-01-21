package jestb.nathanos;

public class Main {

    private static int thread_num;

    public static final void main(String argv[])
    {
        if(argv.length==2) {
            thread_num = 100;
        }
        else if(argv.length==3) {
            thread_num = Integer.parseInt(argv[2]);
        }
        else {
            System.out.print("Nathanos: This is how you should use the Blight Thrower: <time, website> [thread_number].");
            System.out.println("Read the freaking manual \"Hacker\".");
            System.exit(0);
        }

        int time = Integer.parseInt(argv[0]);
        String website = argv[1];

        Refresher refresher = new Refresher(thread_num, time, website);
        refresher.prepare();
        refresher.execute();
        refresher.end();
    }

}
