import java.util.List;

public class MyThread extends Thread{
    private Integer iterator = 0;
    private List<Long> listPrimeNumbers;
    private Long result = 0l;
    private Long multiplier1 = 0l;
    private Long multiplier2 = 0l;

    public MyThread(List<Long> list, Integer iterator){
        this.iterator = iterator;
        this.listPrimeNumbers = list;
    }

    @Override
    public void run() {
        classPalindrom palindrom = new classPalindrom();
        result = palindrom.getPalindrom(listPrimeNumbers, iterator);
        multiplier1 = palindrom.getMultiplier1();
        multiplier2 = palindrom.getMultiplier2();
    }

    public Long getMultiplier1() {
        return multiplier1;
    }

    public Long getMultiplier2() {
        return multiplier2;
    }

    public Long getResult() {
        return result;
    }
}
