import java.util.List;

public class classPalindrom {
    private Long multiplier1 = 0l;
    private Long multiplier2 = 0l;
    private Long palindrom = 0l;

    public Long getPalindrom(List<Long> listPrimeNumbers, Integer iterator){
        for (int i = iterator; i < listPrimeNumbers.size() && i < iterator + 30; i++){
            for (int j = iterator; j < listPrimeNumbers.size() && j < iterator + 30; j++){
                Long temp = listPrimeNumbers.get(i) * listPrimeNumbers.get(j);
                Boolean resultChecking = checkOnPalindrom(temp);
                if (resultChecking && palindrom < temp){
                    multiplier1 = listPrimeNumbers.get(i);
                    multiplier2 = listPrimeNumbers.get(j);
                    palindrom = temp;
                }
            }
        }
        return palindrom;
    }

    public Long getMultiplier1() {
        return multiplier1;
    }

    public Long getMultiplier2() {
        return multiplier2;
    }

    private Boolean checkOnPalindrom(Long number){
        Integer trueValue = 0;
        String stringNumber = Long.toString(number);
        char[] charNumbers = stringNumber.toCharArray();

        for (int i = 0; i<charNumbers.length; i++){
            int val1 = Character.getNumericValue(charNumbers[i]);
            int val2 = Character.getNumericValue(charNumbers[(charNumbers.length - 1) - i]);
            if(val1 == val2){
                trueValue++;
            }
        }

        if (trueValue == 10){
            return true;
        }

        return false;
    }
}
