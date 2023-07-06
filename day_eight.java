import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class day_eight {

    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(new FileReader("./input8"));

        String line;
        List<List<Integer>> grid = new ArrayList<>();
        while((line = in.readLine()) != null) {
            String[] split = line.split("");
            List<Integer> row = new ArrayList<>();
            for(String s : split) {
                row.add(Integer.parseInt(s));
            }
            grid.add(row);
        }
        in.close();


        


    }

    static boolean isVisible(int[][] g, int i, int j) {


        return true;
    }

}