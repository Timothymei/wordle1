//Import util
import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class example {

        public static void main(String[] args)  throws IOException {

            //Introduction
            System.out.println("Welcome to Wordle!");
            System.out.println("==================");
            System.out.println("The goal is to guess the 5-letter word within 6 attempts. For each");
            System.out.println("guess that you make, a series of symbols will appear below that guess. ");
            System.out.println("If the letter is correct, a + will appear. If the letter is in the ");
            System.out.println("word but in the wrong position, a o will appear. And if the letter is ");
            System.out.println("completely wrong, a _ will appear. Good luck and have fun!");
            System.out.println("==================");


            // arraylist to store strings
            List<String> listOfStrings = new ArrayList<String>();
            // load content of file based on specific delimiter
            Scanner sc2 = new Scanner(new FileReader("wordle-answers.txt")).useDelimiter("\r\n*");
            String str;
            // checking end of file
            while (sc2.hasNext()) {
                str = sc2.next();
                // adding each string to arraylist
                listOfStrings.add(str);
            }
            // convert any arraylist to array
            String[] words = listOfStrings.toArray(new String[0]);

            //Pick random 5-character word out of array
            Random r = new Random();
            int randomNumber = r.nextInt(words.length);
            String wordRam = words[randomNumber];
            //Testing purposes System.out.print(wordRam);

            // arraylist to store strings
            List<String> listOfStrings2 = new ArrayList<String>();
            // load content of file based on specific delimiter
            Scanner sc3 = new Scanner(new FileReader("wordle-dictionary.txt")).useDelimiter("\r\n*");
            String str1;
            // checking end of file
            while (sc3.hasNext()) {
                str1 = sc3.next();
                // adding each string to arraylist
                listOfStrings2.add(str1);

            }

            // convert any arraylist to array
            String[] check = listOfStrings.toArray(new String[0]);
            //check array index & check array value System.out.println(check.length); System.out.println(Arrays.toString(check));
            System.out.println(check.length);



                    //Counter variables to keep track of correct and tries
            int counter = 5;
            int attempts = 6;
            boolean checker = false;

            //Main while loop to keep attempts at 6
            while (attempts > 0) {

                checker = false;

                //Input
                System.out.println(" ");
                System.out.println(attempts + " attempts remaining, please enter your guess:");
                Scanner sc = new Scanner(System.in);
                String word = sc.nextLine();

                for(String x : check){
                    if(x.equals(word)){
                        checker = true;
                        break;
                    }
                }

                //Checking characters
                if (word.length() != 5) {
                    System.out.println("You have to input 5 characters");
                    System.out.println("This attempt does not count");

                } else {
                    if(checker == true) {


                        //Checking characters match
                        for (int i = 0; i < word.length(); ++i) {

                            //Correct
                            if (word.charAt(i) == wordRam.charAt(i)) {
                                System.out.print("+");
                                counter = counter - 1;


                                //Correct 5 times in a row, break loop
                                if (counter <= 0) {
                                    attempts = attempts - 6;
                                    break;
                                }

                                //Else if the character is in any part of the word
                            } else {
                                boolean x = true;
                                for (int j = 0; j < wordRam.length(); ++j) {
                                    if (word.charAt(i) == wordRam.charAt(j)) {
                                        System.out.print("o");
                                        x = false;

                                        //Restore counter to 5
                                        counter = 5;
                                        break;
                                    }
                                }
                                //Boolean not changed, then incorrect
                                if (x == true) {
                                    System.out.print("_");
                                    //Restore counter to 5
                                    counter = 5;
                                }

                            }

                        }
                        //Each attempt counter
                        attempts = attempts - 1;
                    }
                    else {
                        System.out.println("You have to input a real word.");
                    }
                }

                }
            //Final conditions after loop is broken
            //Counter == 0 means all five characters were correct
            if (counter == 0) {
                System.out.println(" ");
                System.out.println("You got it right");
                System.out.println("The word was: " + wordRam);
                //else meaning attempts were up and you did not get it correct
            } else {
                System.out.println(" ");
                System.out.println("Dang you suck, you had six tries and still got it wrong, you probaby play some trash game like fortnite L + Bozo");
                System.out.println("The word was: " + wordRam);
            }

        }

    }

