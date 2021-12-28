package no_77484;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // case 1
        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};

        // case 2
        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};

        // case 3
        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};

        int[] result = solution.solution(lottos3, win_nums3);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};

        for (int num1 : lottos) {
            if (num1 == 0) {
                answer[0]--;
            }
            for (int num2 : win_nums) {
                if (num1 == num2) {
                    answer[0]--;
                    answer[1]--;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] > 6) {
                answer[i]--;
            }
        }

        return answer;
    }
}