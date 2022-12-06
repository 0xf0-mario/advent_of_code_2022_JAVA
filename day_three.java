import java.util.Scanner;

public class day_three {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sum = 0;
        while(in.hasNext()){
            // take the next three lines
            String line = in.nextLine();
            String line2 = in.nextLine();
            String line3 = in.nextLine();
            // split into half
            char[] h1 = line.toCharArray();
            char[] h2 = line2.toCharArray();
            char[] h3 = line3.toCharArray();
            // char[] h1 = new char[chars.length];
            // char[] h2 = new char[chars2.length];
            // char[] h3 = new char[chars3.length];
            // for(int i = 0; i < chars.length/2; i++){
            //     h1[i] = chars[i];
            // }
            // for(int i = chars.length/2; i < chars.length; i++){
            //     h2[i-chars.length/2] = chars[i];
            // }
            char[] counts1 = new char[52];
            char[] counts2 = new char[52];
            char[] counts3 = new char[52];
            for(int i = 0; i < h1.length; i++){
                if(h1[i] >= 'a' && h1[i] <= 'z'){
                    counts1[h1[i]-'a']++;
                } else if(h1[i] >= 'A' && h1[i] <= 'Z'){
                    counts1[h1[i]-'A'+26]++;
                }
            }
            for(int i = 0; i < h2.length; i++){
                if(h2[i] >= 'a' && h2[i] <= 'z'){
                    counts2[h2[i]-'a']++;
                } else if(h2[i] >= 'A' && h2[i] <= 'Z'){
                    counts2[h2[i]-'A'+26]++;
                }
            }
            for(int i = 0; i < h3.length; i++){
                if(h3[i] >= 'a' && h3[i] <= 'z'){
                    counts3[h3[i]-'a']++;
                } else if(h3[i] >= 'A' && h3[i] <= 'Z'){
                    counts3[h3[i]-'A'+26]++;
                }
            }
            // check where the count is not zero for all three
            for(int i = 0; i < 52; i++){
                if(counts1[i] != 0 && counts2[i] != 0 && counts3[i] != 0){
                    sum += (i +1);
                    break;
                }
            }

        }
        System.out.println(sum);
        in.close();
    }
}
