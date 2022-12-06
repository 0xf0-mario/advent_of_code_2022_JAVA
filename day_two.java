import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class day_two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> pointsForMove = new HashMap<String, Integer>();
        pointsForMove.put("A", 1);
        pointsForMove.put("B", 2);
        pointsForMove.put("C", 3);
        int playerOneScore = 0;
        while(in.hasNext()) {
            String line = in.nextLine();
            String[] strings = line.split(" ");

            String opp_move = strings[0];
            String my_move = strings[1];
            // A=rock, B=paper, C=scissors for both players
            // X=player must choose move to lose, Y=player must choose move to tie, Z=player must choose move to win
            if (my_move.equals("X")) {
                if (opp_move.equals("A")) {
                    my_move = "C";
                } else if (opp_move.equals("B")) {
                    my_move = "A";
                } else if (opp_move.equals("C")) {
                    my_move = "B";
                }
            } else if (my_move.equals("Y")) {
                if (opp_move.equals("A")) {
                    my_move = "A";
                } else if (opp_move.equals("B")) {
                    my_move = "B";
                } else if (opp_move.equals("C")) {
                    my_move = "C";
                }
            } else if (my_move.equals("Z")) {
                if (opp_move.equals("A")) {
                    my_move = "B";
                } else if (opp_move.equals("B")) {
                    my_move = "C";
                } else if (opp_move.equals("C")) {
                    my_move = "A";
                }
            }
            playerOneScore += pointsForMove.get(my_move);
            // simulate rock paper sicssors. 0 for lose, 3 for tie, 6 for win
            if(my_move.equals("A")) {
                if(opp_move.equals("A")) {
                    playerOneScore += 3;
                } else if(opp_move.equals("B")) {
                    playerOneScore += 0;
                } else if(opp_move.equals("C")) {
                    playerOneScore += 6;
                }
            } else if(my_move.equals("B")) {
                if(opp_move.equals("A")) {
                    playerOneScore += 6;
                } else if(opp_move.equals("B")) {
                    playerOneScore += 3;
                } else if(opp_move.equals("C")) {
                    playerOneScore += 0;
                }
            } else if(my_move.equals("C")) {
                if(opp_move.equals("A")) {
                    playerOneScore += 0;
                } else if(opp_move.equals("B")) {
                    playerOneScore += 6;
                } else if(opp_move.equals("C")) {
                    playerOneScore += 3;
                }

            } 





            

        }
        System.out.println(playerOneScore);
        in.close();
    }
}