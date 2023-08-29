package chapter05;

public class GeneratePrimesVer01 {
    /*
     * @param maxValue는 생성 한계값이다.
     * */
    public static int[] generatePrimes(int maxValue) {
        if(maxValue >= 2) { // 유효한 경우에만
            // 선언
            int s = maxValue + 1;   // 배열 크기
            boolean[] f = new boolean[s];
            int i;

            // 배열을 true 값으로 초기화한다
            for (i = 0; i < s; i++) {
                f[i] = true;
            }

            // 알려진 비소수를 제거한다.
            f[0] = f[1] = false;

            // 체로 걸러내기
            int j;
            for (i = 2; i < Math.sqrt(s) + 1; i++) {
                if(f[i]) {  // i가 지워지지 않았으면 그 배수를 지운다.
                    for (j = 2 * i; j < s; j += i) {
                        f[j] = false;   // 배수는 소수가 아니다.
                    }
                }
            }

            // 지금까지 몇 개의 소수가 있는가?
            int count = 0;
            for (i = 0; i < s; i++) {
                if(f[i]) {
                    count++;    // 발견된 개수를 센다.
                }
            }

            int[] primes = new int[count];

            // 소수를 결과 집합에 넣는다.
            j = 0;
            for (i = 0; i < s; i++) {
                if(f[i]) {  // 소수이면
                    primes[j++] = i;
                }
            }

            return primes;  // 소수를 반환
        } else {    // maxValue < 2
            return new int[0];  // 잘못된 입력이 들어왔을 경우 널(null) 배열을 반환
        }
    }
}
