package no_17681;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // case 01
//        int n = 5;
//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};

        // case 02
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};

        String[] result = solution.solution(n, arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] map1 = new String[n][n];
        String[][] map2 = new String[n][n];
        boolean[][] board = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);

            // 0 채우기
            if (binary1.length() < n) {
                StringBuffer sb = new StringBuffer(binary1);
                for (int j = 0; j < (n - binary1.length()); j++) {
                    sb.insert(0, "0");
                }
                binary1 = sb.toString();
            }
            if (binary2.length() < n) {
                StringBuffer sb = new StringBuffer(binary2);
                for (int j = 0; j < (n - binary2.length()); j++) {
                    sb.insert(0, "0");
                }
                binary2 = sb.toString();
            }

            map1[i] = binary1.split("");
            map2[i] = binary2.split("");
        }

        for (int i = 0; i < n; i++) {
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                board[i][j] = map1[i][j].equals("1") || map2[i][j].equals("1");
                answer[i] += board[i][j] ? "#" : " ";
            }
        }

        return answer;
    }
}