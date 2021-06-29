
/**
 * @date: 20th April 2020
 * @author Tamara
 * @class gameGameApp
 */

//import JOptionP
import javax.swing.JOptionPane;

public class gameGameApp {

    public static void main(String[] args) {
        // variables
        String wordP1;
        String wordP2;
        int playAgain;
        int rounds;
        //object
        Game myGame = new Game();


        //input
        do{ //play again 
        rounds = Integer.parseInt(JOptionPane.showInputDialog(null,"How many rounds do you want to play?"));


        //process game
        for(int i=0;i<rounds;i++){ // number of rounds to play
            myGame.computeGame();

            //insert word from Player 1
            wordP1 = JOptionPane.showInputDialog(null,"Player 1 " + "\n"+ "Insert your word: ");
            myGame.setWordP1(wordP1);


            //insert word from Player 2
            wordP2 = JOptionPane.showInputDialog(null,"Player 2 " + "\n"+ "Insert your word: ");
            myGame.setWordP2(wordP2);

            myGame.computeCheck();



        //output Each Round (scores)

        JOptionPane.showMessageDialog(null, "Random letters "+ myGame.getTotalRanLetters() + "\n" +"Player1 word: " +myGame.getWordP1() + "\n" + "Player2 word: " + myGame.getWordP2()+
                "\n+"+"\n+"+"Total Score Player 1: "+ myGame.getScoreP1()+"points"+ "\n+"+"Total Score Player 2: "+ myGame.getScoreP2()+"points");
        }
            
        //output Total end game scores

        if(myGame.getScoreP1() > myGame.getScoreP2()){
            JOptionPane.showMessageDialog(null, "The final winner is Player 1");
        }else if(myGame.getScoreP1() < myGame.getScoreP2()){
            JOptionPane.showMessageDialog(null, "The final winner is Player 2");
        }else{
            JOptionPane.showMessageDialog(null,  "\n" +"FINAL SCORE: It's a draw");

        }

        //Play again Game
        playAgain = JOptionPane.showConfirmDialog(null, " Do you want to play again? ", " Notice ", JOptionPane.YES_NO_OPTION);
        }while (playAgain == JOptionPane.YES_OPTION);


            }
   }



