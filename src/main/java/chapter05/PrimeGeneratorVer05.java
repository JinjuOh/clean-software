package chapter05;

public class PrimeGeneratorVer05 {

    private static boolean[] crossedOut;
    private static int[] result;

    /*
     * @param maxValue는 생성 한계값이다.
     * */
    public static int[] generatePrimes(int maxValue) {
        if(maxValue < 2) {
            return new int[0];  // 잘못된 입력이 들어왔을 경우 널(null) 배열을 반환
        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;  // 소수를 반환
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }

    private static void crossOutMultiples() {
        for (int i = 2; i < calcMaxPrimeFactor(); i++) {
            if(notCrossed(i)) {  // i가 지워지지 않았으면 그 배수를 지운다.
                crossOutMultiplesOf(i);
            }
        }
    }

    private static double calcMaxPrimeFactor() {
        return Math.sqrt(crossedOut.length) + 1;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i) {
            crossedOut[multiple] = true;   // 배수는 소수가 아니다.
        }
    }

    private static boolean notCrossed(int i) {
        return crossedOut[i] == false;
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        // 소수를 결과 집합에 넣는다.
        for (int j = 0, i = 2; i < crossedOut.length; i++) {
            if(notCrossed(i)) {  // 소수이면
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++) {
            if(notCrossed(i)) {
                count++;    // 발견된 개수를 센다.
            }
        }
        return count;
    }
}
