import java.util.ArrayList;
import java.util.List;

public class Runner {
    static Long bigPalindrome = 0L;
    static Integer multiplier1 = 0;
    static Integer multiplier2 = 0;

    public static void main(String[] args) {
        final int MIN_NUMBER = 10_000;
        final int MAX_NUMBER = 99_999;
        List<Integer> listNumbers = getPrimeNumber(MIN_NUMBER, MAX_NUMBER);
        MyThread thread;

        List<MyThread> poolThreads = new ArrayList<>(4);
        for (int j = 0; j < 4; j++) {
            thread = new MyThread();
            poolThreads.add(thread);
            thread.start();
        }

        int iterator = 0;//отвечает за количество обрабатываемых чисел
        int i = 0;
        int numberThread = 0;
        while (i < listNumbers.size()) {
            List<Integer> listTenNumbers = new ArrayList<>(10);

            for (; i < iterator + 500; i++) {
                if (i < listNumbers.size()) {
                    listTenNumbers.add(listNumbers.get(i));
                } else {
                    break;
                }
            }
            iterator += 500;

            try {
                MyThread thread1 = new MyThread();
                thread1.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            thread = poolThreads.get(numberThread++);
            thread.setPrimeNumbersNew(listTenNumbers);
            if (numberThread == 4) {
                numberThread = 0;
            }
        }


        for (MyThread tr : poolThreads) {
            tr.setStopFlag(true);
            if (tr.getResult() == 0){
                System.out.println("Thread count");
                try {
                    MyThread thread1 = new MyThread();
                    thread1.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Palindrome: " + bigPalindrome);
        System.out.println("multiplier1: " + multiplier1);
        System.out.println("multiplier2: " + multiplier2);
    }

    private static List getPrimeNumber(int min, int max){
        List<Integer> listPrimeNumber = new ArrayList();
        for (int i = max; i >= min; i--){
            if (i % 2 != 0){
                listPrimeNumber.add(i);
            }
        }
        return listPrimeNumber;
    }

    public static synchronized void setBigPalindrome(Long number, Integer multiplier1, Integer multiplier2){
        if (bigPalindrome < number){
            bigPalindrome = number;
            Runner.multiplier1 = multiplier1;
            Runner.multiplier2 = multiplier2;
        }
    }
}
