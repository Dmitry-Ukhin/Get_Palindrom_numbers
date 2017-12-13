import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        final long MIN_NUMBER = 10000;
        final long MAX_NUMBER = 99999;
        List<Long> listNumbers = getPrimeNumber(MIN_NUMBER, MAX_NUMBER);

        Long bigPalindrom = 0l;
        Long multiplier1 = 0l;
        Long multiplier2 = 0l;

        for (int i = 0; i < listNumbers.size(); i += 20){
            MyThread thread = new MyThread(listNumbers, i);
            thread.start();
            try {
                thread.join();
            }catch (InterruptedException e){
                System.out.printf("Thread %s stopped", thread.getName());
            }

            if(bigPalindrom < thread.getResult()){
                bigPalindrom = thread.getResult();
                multiplier1 = thread.getMultiplier1();
                multiplier2 = thread.getMultiplier2();
            }
        }

        System.out.println("Palindrom: " + bigPalindrom + "\n");
        System.out.println("multiplier1: " + multiplier1 + "\n");
        System.out.println("multiplier2: " + multiplier2 + "\n");
    }

    private static List getPrimeNumber(long min, long max){
        List<Long> listPrimeNumber = new ArrayList();
        for (long i = max; i >= min; i--){
            if (i % 2 != 0){
                listPrimeNumber.add(i);
            }
        }
        return listPrimeNumber;
    }
}
