import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class day_twelve {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("input12"));
        
        String line;
        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        while((line = in.readLine()) != null) {
            ArrayList<Character> row = new ArrayList<>();
            char[] split = line.toCharArray();
            System.out.println(line);
            for(char c : split) {
                row.add(c);
            }
            grid.add(row);
        }
        in.close();
        int startingX = -1;
        int startingY = -1;
        for(int m = 0; m < grid.size(); m++){
            for(int n = 0; n < grid.get(m).size(); n++){
                if(grid.get(m).get(n) == 'S'){
                    startingX = m;
                    startingY = n;
                }
            }
        }
        //a lowest height and z highest height
        int minSteps = Integer.MAX_VALUE;
        // Stack<Integer> xStack = new Stack<>();
        // Start at the starting position S.

        // Consider each of the possible moves from the current position (up, down, left, right, or diagonally).
    
        // If a move leads to a position that is off the grid, or is a character with a height more than one higher than the current position, then skip it and move on to the next move.
    
        // If a move leads to the character "E", then save this path as a potential solution and return it.
    
        // If a move leads to a position that has already been visited, then skip it and move on to the next move.
    
        // If a move leads to a new position, then add it to the list of visited positions and move to that position.
    
        // Repeat steps 2-6 until all possible paths have been considered, and then return the shortest path that leads to the character "E".
        
        




        System.out.println(minSteps);
    }

}
