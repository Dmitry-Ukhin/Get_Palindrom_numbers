import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class classPalindrom {
    private Integer multiplier1 = 0;
    private Integer multiplier2 = 0;
    private Long palindrom = 0L;

    public Long getPalindrom(List<Integer> listPrimeNumbers, Integer iterator){
        for (int i = iterator; i < listPrimeNumbers.size() && i < iterator + 30; i++){
            for (int j = iterator; j < listPrimeNumbers.size() && j < iterator + 30; j++){
                Long temp = (long)listPrimeNumbers.get(i) * listPrimeNumbers.get(j);
                Boolean resultChecking = checkOnPalindrom(temp); //7942552497
                System.out.println(temp);

                if (resultChecking && palindrom < temp){
                    multiplier1 = listPrimeNumbers.get(i);
                    multiplier2 = listPrimeNumbers.get(j);
                    palindrom = temp;
                }
            }
        }
        return palindrom;
    }

    public Long getPalindrom1(List<Integer> listPrimeNumbers){
        for (int i = 0; i < listPrimeNumbers.size(); i++){
//            System.out.println(listPrimeNumbers.get(i) + " Multiplier1");
            for (int j = 0; j < listPrimeNumbers.size(); j++){
                Long temp = (long)listPrimeNumbers.get(i) * listPrimeNumbers.get(j);
                Boolean resultChecking = checkOnPalindrom(temp); //7942552497
//                System.out.println(temp + " " + listPrimeNumbers.get(i) + " * " + listPrimeNumbers.get(j));

//                if(listPrimeNumbers.get(i) == 99_001){
////                    System.out.println("Palindrome : " + temp + " " + multiplier1 + " * " + multiplier2);
//                    System.out.println(listPrimeNumbers.get(j));
//                } else if (listPrimeNumbers.get(i) == 98_879){
//                    System.out.println();
//                    System.out.println(listPrimeNumbers.get(j));
//                }

                if (resultChecking && palindrom < temp){
                    multiplier1 = listPrimeNumbers.get(i);
                    multiplier2 = listPrimeNumbers.get(j);
                    palindrom = temp;
                }
            }
        }
        return palindrom;
    }

    public Integer getMultiplier1() {
        return multiplier1;
    }

    public Integer getMultiplier2() {
        return multiplier2;
    }

    private Boolean checkOnPalindrom(Long number){
        String stringNumber = Long.toString(number);
        String reverseString = recursiveReverse(stringNumber);

        return stringNumber.equals(reverseString);
    }

    private String recursiveReverse(String str){
        if ((null == str) || (str.length() <= 1)){
            return str;
        }
        return recursiveReverse(str.substring(1)) + str.charAt(0);
    }
}
