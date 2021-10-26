package no_1835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br;
    public static StringTokenizer st;
    static String[] names = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public static int n;
    static boolean[] visited = new boolean[8];
    static int depth = -1;
    static int answer = 0;
    static String[] datas;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        datas = new String[n];
        st = new StringTokenizer(br.readLine(), "");
        for(int i = 0; st.hasMoreTokens(); i++){
            datas[i] = st.nextToken();
        }

        System.out.println(solution());
    }

    public static int solution() {
        permutation("");
        return answer;
    }

    public static void permutation(String lines) {
        if (depth == 7) {
            if (checkCondition(lines))
                answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                depth++;
                visited[i] = true;
                permutation(lines + names[i]);
                visited[i] = false;
                depth--;
            }
        }
    }

    public static boolean checkCondition(String lines) {
        for (int i = 0; i < datas.length; i++) {
            int index1 = lines.indexOf(datas[i].charAt(0) + "");
            int index2 = lines.indexOf(datas[i].charAt(2) + "");
            int value = index1 > index2 ? index1 - index2 - 1 : index2 - index1 - 1;
            if (datas[i].charAt(3) == '=' && value != datas[i].charAt(4) - '0') {
                return false;
            } else if (datas[i].charAt(3) == '>' && value <= datas[i].charAt(4) - '0') {
                return false;
            } else if (datas[i].charAt(3) == '<' && value >= datas[i].charAt(4) - '0') {
                return false;
            }
        }
        return true;
    }
}