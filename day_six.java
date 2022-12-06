import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day_six {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        char[] chars = line.toCharArray();
        int start = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        boolean foundFirst = false;
        for(int end = 0; end < chars.length; end++) {
            char rightChar = chars[end];

            if(charIndexMap.containsKey(rightChar)) {
                start = Math.max(start, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, end);
            if(end - start + 1 == 4 && !foundFirst) {
                foundFirst = true;
                System.out.println("Found 4");
                System.out.println(end + 1);
            }
            //now find the next window thats size 14 after you have found first
            if(foundFirst && end - start + 1 == 14) {
                System.out.println("Found 14");
                System.out.println(end + 1);
                break;
            }
        }

        in.close();
    }
}
