import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {
    private List<Integer> primeNumbersOld;
    private List<Integer> primeNumbersNew = new ArrayList<>();

    private Long result = 0L;

    private Boolean stopFlag = false;
    private String nameThread;

    @Override
    public void run() {
        while (!stopFlag){
            if (primeNumbersOld != primeNumbersNew){
                nameThread = this.currentThread().getName();

                classPalindrom palindrom = new classPalindrom();
                result = palindrom.getPalindrom1(primeNumbersNew);

                if (result == 0){
                    System.out.println("Palindrome not found " + nameThread);
                } else {
                    System.out.println(result + " " + nameThread);
                    Runner.setBigPalindrome(result, palindrom.getMultiplier1(), palindrom.getMultiplier2());
                }

                primeNumbersOld = primeNumbersNew;
            } else {
                try {
                    this.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setStopFlag(Boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    public void setPrimeNumbersNew(List<Integer> primeNumbers) {
        this.primeNumbersOld = primeNumbersNew;
        this.primeNumbersNew = primeNumbers;
//        System.out.println("listUpdate");
    }

    public Long getResult() {
        return result;
    }

    public String getNameThread() {
        return nameThread;
    }

}
