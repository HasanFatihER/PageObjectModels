package Utilities;

public class WaitThreadSleep {

    public void waitThreadSleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
