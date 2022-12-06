import java.util.Scanner;

// Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?

public class day_one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // while you dont hit a line that is just a line break you are still processing one elf
        int maxCalories = 0;
        int secondMaxCalories = 0;
        int thirdMaxCalories = 0;
        int current_calories = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("")) {
                current_calories = 0;
                continue;
            }
            // split the line into the name and the calories
            
           
            current_calories += Integer.parseInt(line);
            // if the calories are greater than the current max, update the max
            if (current_calories > maxCalories) {
                thirdMaxCalories = secondMaxCalories;
                secondMaxCalories = maxCalories;
                maxCalories = current_calories;
            }
            else if (current_calories > secondMaxCalories) {
                thirdMaxCalories = secondMaxCalories;
                secondMaxCalories = current_calories;
            }
            else if (current_calories > thirdMaxCalories) {
                thirdMaxCalories = current_calories;
            }
        }
        in.close();

        
        System.out.println("the most calories with " + (maxCalories + secondMaxCalories + thirdMaxCalories)+ " calories.");
    }

}