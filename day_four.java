import java.util.Scanner;

public class day_four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //find all the ranges that are overlapping with the current line against all other linews
        int count =0;
        while(in.hasNextLine()) {
            //get all the ranges into the list
            String line = in.nextLine();
            String[] strings = line.split(",");
            String[] startEnd1 = strings[0].split("-");
            String[] startEnd2 = strings[1].split("-");
            int start1 = Integer.parseInt(startEnd1[0]);
            int end1 = Integer.parseInt(startEnd1[1]);
            int start2 = Integer.parseInt(startEnd2[0]);
            int end2 = Integer.parseInt(startEnd2[1]);
            //check to see if these touch (start or end are equal or overlap) at all if they do increment count
            if (start1 <= end2 && end1 >= start2) {
                count++;
            }   
        }
        System.out.println(count);
        in.close();
    }

}
