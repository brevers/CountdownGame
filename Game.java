
/**
 * @date: 20th April 2020
 * @author Tamara
 * @class gameGameApp
 */

//imports
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class Game {

    //variables
    private final String consonantsList;
    private final String vowelsList;
    private final String []KeywordsJava;
    private String wordP1;
    private String wordP2;
    private int numConso;
    private int numVowel;

    private String randomLetters;
    private String randomVowels;
    private int scoreP1;
    private int scoreP2;
    private String totalRanLetters;
    private int check1;
    private int check2;

    //constructor method
    public Game(){
        consonantsList = "bcdfghklmnprstvwxy";
        vowelsList = "aeiou";
        KeywordsJava =new String [] {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default",
        "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if", "implements", "import",
        "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch", "synchronised", "this", "throw", "throws",
        "transient", "try", "void", "volatile", "while"};
        
        wordP1 = "";
        wordP2 = "";

        randomLetters = "";
        randomVowels = "";
        scoreP1 = 0;
        scoreP2 = 0;
        check1 = 0;
        check2 = 0;
    }
    //object Random
    Random rand = new Random();

    //Setters

    public void setWordP1(String wordP1) {
        this.wordP1 = wordP1;
    }

    public void setWordP2(String wordP2) {
        this.wordP2 = wordP2;
    }

    //Getters
    public String getWordP1() {
        return wordP1;
    }

    public String getWordP2() {
        return wordP2;
    }

    public int getScoreP1() {
        return scoreP1;
    }

    public int getScoreP2() {
        return scoreP2;
    }
    public String getTotalRanLetters() { //It helps to make clear who win and show the random letters when showing the scores.
        return totalRanLetters;
    }



    //compute
    public void computeGame() {
        scoreP1= 0;//brings the score to 0 if they chose to play again
        scoreP2= 0;
        numConso = Integer.parseInt(JOptionPane.showInputDialog(null,"How many CONSONANTS (out of 9 letters) do you want?"));
        numVowel = Integer.parseInt(JOptionPane.showInputDialog(null,"How many VOWELS (out of 9 letters) do you want?"));

        if(numConso + numVowel!=9){ //number of consonants and vowels
            JOptionPane.showMessageDialog(null, "Please make sure you enter a valid number of Consonants and Vowels");
            computeGame();//game will go back if the number of CONS & VOWEL are not correct

         //check the correct number of Consonants and Vowels (9Total)
        }else {
            char[] text1 = new char[numConso];
            char[] text2 = new char[numVowel];

            for(int j =0; j<numConso;j++){
                text1[j] = consonantsList.charAt(rand.nextInt(consonantsList.length()));
            }
            for (int j=0; j< text1.length; j++){
                randomLetters += text1[j];
            }
            for(int k =0; k<numVowel;k++){
                text2[k] = vowelsList.charAt(rand.nextInt(vowelsList.length()));
            }
            for (int k=0; k< text2.length; k++){
                randomVowels += text2[k];
            }
            totalRanLetters = randomLetters + randomVowels;
            JOptionPane.showMessageDialog(null, "BUILD UP A WORD WITH THE FOLLOWING LETTERS: " +"\n"+"\n"+randomLetters +" "+ randomVowels );

            randomVowels=""; //String will go to 0 for new consonants the next game
            randomLetters="";//String will go to 0 for new vowels the next game


        }
    }
    //check if random letters are used in the words given by players
    public void computeCheck(){
        check1=0; // bring the variable to 0 each round
        check2=0;
        for(int i = 0; i<wordP1.length();i++){
                if(totalRanLetters.indexOf(wordP1.charAt(i)) == -1){
                    check1--;
                }else{
                    check1++;
                }
            }
        for(int i = 0; i<wordP2.length();i++){
                if(totalRanLetters.indexOf(wordP2.charAt(i)) == -1){
                    check2--;

                }else{
                    check2++;
                }
            }
     		//check if the words are on the list given and which is the longest
     		//both used Random letters
            if(check1 == wordP1.length() && check2 == wordP2.length()){
                 JOptionPane.showMessageDialog(null, "Thanks for using Random letters");
                if(Arrays.asList(KeywordsJava).contains(wordP1)&& Arrays.asList(KeywordsJava).contains(wordP2)&& wordP1.length() > wordP2.length() //words from players are on the list and compare each other
                || Arrays.asList(KeywordsJava).contains(wordP1) && !Arrays.asList(KeywordsJava).contains(wordP2)){

                    JOptionPane.showMessageDialog(null, "Congratulations!    Player 1 WON this Round");
                    scoreP1++;

                }else if(Arrays.asList(KeywordsJava).contains(wordP2)&& Arrays.asList(KeywordsJava).contains(wordP1) && wordP2.length() > wordP1.length()
                || Arrays.asList(KeywordsJava).contains(wordP2) && !Arrays.asList(KeywordsJava).contains(wordP1)){

                    JOptionPane.showMessageDialog(null, "Congratulations!    Player 2 WON this Round");
                    scoreP2++;

                }else if(Arrays.asList(KeywordsJava).contains(wordP1) && Arrays.asList(KeywordsJava).contains(wordP2)&& wordP1.length() == wordP2.length()){

                    JOptionPane.showMessageDialog(null, "  DRAW!!  ");
                    scoreP1++;
                    scoreP2++;

                }else{
                    JOptionPane.showMessageDialog(null, "Unfortunately those words are not in our Java List");
                }


             //Just one player used Random letters

            }else if (check1 == wordP1.length() && check2 != wordP2.length()){  //Only player1 has used Random letters
                JOptionPane.showMessageDialog(null, "Player2 did not play with the characters given");
                if(Arrays.asList(KeywordsJava).contains(wordP1)){
                    JOptionPane.showMessageDialog(null, "Congratulations!    Player 1 WON this Round");
                    scoreP1++;
                }else{
                    JOptionPane.showMessageDialog(null, "Player 1 your word is not on the java list." +"\n"+"It is a draw 0 points.");
                }
            }else if(check1 != wordP1.length() && check2 == wordP2.length()){ // Only Player2 used Random letters
                JOptionPane.showMessageDialog(null, "Player1 did not play with the characters given");
                if(Arrays.asList(KeywordsJava).contains(wordP2)){
                    JOptionPane.showMessageDialog(null, "Congratulations!    Player 2 WON this Round");
                    scoreP2++;
                }else{
                    JOptionPane.showMessageDialog(null, "Player 2 your word is not on the java list." +"\n"+"It is a draw 0 points.");

                }
            }else{ //None of the players used Random letters
                JOptionPane.showMessageDialog(null, "Both Player 1 and Player 2 didnt use the letters given. 0 points");

            }

    }

}






