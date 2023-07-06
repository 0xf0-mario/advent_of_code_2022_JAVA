import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class day_ten {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader("input10"));

        int sum = 1;
        String line;
        int currentCycle = 0;
        ArrayList<Integer> reportOut = new ArrayList<>();
        // Find the signal strength during the 20th, 60th, 100th, 140th, 180th, and 220th cycles. What is the sum of these six signal strengths?
        Queue<Integer> report = new LinkedList<>(Arrays.asList(20, 60, 100, 140, 180, 220));
        while((line = in.readLine()) != null){
            String[] split = line.split(" ");
            
            if(split[0].equals("addx")){
                Integer x = Integer.parseInt(split[1]);
                currentCycle += 2;
                if(report.peek() == currentCycle){
                    reportOut.add(sum * currentCycle);
                    report.remove(currentCycle);
                } else if (report.peek() < currentCycle){
                    
                }
                sum += x;
            } else if (split[0].equals("noop")) {
                currentCycle++;
                if(report.peek() == currentCycle){
                    reportOut.add(sum * currentCycle);
                    report.remove(currentCycle);
                } else if (report.peek() < currentCycle){
                    
                }
            }
            
        }
        in.close();
    }
}