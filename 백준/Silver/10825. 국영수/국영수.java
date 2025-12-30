import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List <Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            members.add(new Member(name, korean, english, math));
        }
        members.sort((o1, o2) -> {
            if (o1.korean != o2.korean) return o2.korean - o1.korean;
            if (o1.english != o2.english) return o1.english - o2.english;
            if (o1.math != o2.math) return o2.math - o1.math;

            return o1.name.compareTo(o2.name);
            
        });
        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.name).append("\n");
        }

        System.out.println(sb);
    }
}

class Member {
    String name;
    int korean, english, math;

    public Member(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}