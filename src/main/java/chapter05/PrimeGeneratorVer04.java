package chapter05;

public class PrimeGeneratorVer04 {

    private static boolean[] isCrossed;
    private static int[] result;

    /*
     * @param maxValue는 생성 한계값이다.
     * */
    public static int[] generatePrimes(int maxValue) {
        if(maxValue < 2) {
            return new int[0];  // 잘못된 입력이 들어왔을 경우 널(null) 배열을 반환
        } else {
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;  // 소수를 반환
        }
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        isCrossed = new boolean[maxValue + 1];
        for (int i = 2; i < isCrossed.length; i++)
            isCrossed[i] = false;
    }

    private static void crossOutMultiples() {
        for (int i = 2; i < calcMaxPrimeFactor(); i++) {
            if(notCrossed(i)) {  // i가 지워지지 않았으면 그 배수를 지운다.
                crossOutMultiplesOf(i);
            }
        }
    }

    private static double calcMaxPrimeFactor() {
        return Math.sqrt(isCrossed.length) + 1;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < isCrossed.length; multiple += i) {
            isCrossed[multiple] = true;   // 배수는 소수가 아니다.
        }
    }

    private static boolean notCrossed(int i) {
        return isCrossed[i] == false;
    }

    private static void putUncrossedIntegersIntoResult() {
        int j;
        int i;
        // 지금까지 몇 개의 소수가 있는가?
        int count = 0;
        for (i = 2; i < isCrossed.length; i++) {
            if(notCrossed(i)) {
                count++;    // 발견된 개수를 센다.
            }
        }

        result = new int[count];

        // 소수를 결과 집합에 넣는다.
        j = 0;
        for (i = 2; i < isCrossed.length; i++) {
            if(notCrossed(i)) {  // 소수이면
                result[j++] = i;
            }
        }
    }
}
