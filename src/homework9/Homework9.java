
package homework9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**This program will read from a file that has a dictionary of english words and 
 * their spanish translations separated by one space on a single line per 
 * pairing. We will read the file and create one map that has the english word
 * as the key and the spanish translation as the value and then from that map
 * we will create another map that has the spanish word as the key and the
 * english word will be the value. We will then ask the user to enter an english
 * or spanish word. If it appears as a key in either map, it will print out if 
 * the user entered word was either english or spanish and then will also print
 * out it's translation. If it doesn't appear it the mappings, then the program
 * will tell the user it isn't in the dictionary and to enter another english or
 * spanish word. The can keep on doing this until they enter *, which will 
 * terminate the program
 * @author Ryan Hilsabeck
 */
public class Homework9 
{


    public static void main(String[] args) throws FileNotFoundException
    {
       //putting scanner on top of to read it
       Scanner keyboard = new Scanner(new FileReader("C:/Temp/Translator.txt"));
       //create new TreeMap to store engish as the key and spanish as the value
       Map <String, String> dictionaryMap = new TreeMap<>();
       
       //This loop will keep going until no more lines in file, it will split
       //the english word from the spanish word and put the english word as the
       //key and the spanish word as the value
       while(keyboard.hasNextLine())
       {
           String [] columns = keyboard.nextLine().split(" ");
           dictionaryMap.put(columns[0], columns[1]);
       }
       System.out.println("English to Spanish Dictionary is: ");
       System.out.println(dictionaryMap);
       
       //Create a new Map to store the spanish to english(reverse)
       Map<String, String> revDictionaryMap = new TreeMap<>();
       //Using the Map.Entry to enter the english to spanish Map we created 
       //earlier and put those values into the new map by putting the value
       //(spanish word) as the key and by putting the key(english word) as the
       //value
       for(Map.Entry<String,String> entry : dictionaryMap.entrySet())
       {
           revDictionaryMap.put(entry.getValue(), entry.getKey());
       }
       System.out.println("Spanish to English Dictionary is: ");
       System.out.println(revDictionaryMap);
       
       //Next section is asking the user to enter in a spanish or english word
       //to get either the spanish or english translation of that word, 
       //depending on what they enter. The will enter * when they want to 
       //terminate the program
       String input;
       Scanner sc = new Scanner(System.in);
       
       System.out.print("Enter a spanish or english word. When you want\n" +
                        "to terminate program, enter *: ");
       
       input = sc.nextLine();
       //while they don't enter *, we will first search the english to spanish
       //mapping that we created to see if the input they entered is a key in 
       //there. If they entered an english word and it appears in the mapping as
       //a key, it will print out the translation
       while(!input.equals("*"))
       {
           if(dictionaryMap.containsKey(input))
           {
               System.out.println(input + " is an english word. The spanish " +
                                  "word is " + dictionaryMap.get(input) + ".");
           }
           else
           {
            //If the input they entered doesn't appear as a key in the english
            //to spanish dictionary map, then it is either a spanish word and we
            //will then search the spanish to english dictionary map to see if
            //the user input is a key in there. If it is, then we will output
            //the translation to the user
            if(revDictionaryMap.containsKey(input))
            {
               System.out.println(input + " is a spanish word. The english " +
                                  "word is " + revDictionaryMap.get(input) +
                                             ".");
            }
           
            //If input from the user does not show up as a key in either the 
            //english to spanish dictionary map or the spanish to english
            //dictionary map, then there is no dictionary entry for the word in
            //the file and we will state that to the user
            else
               System.out.println("No dictionary entry for " + input);
           }
           //We will then ask the user to enter another word or they can entere
           //* if they want to terminate the program
           System.out.print("Enter a spanish or english word. When you want\n" +
                        "to terminate program, enter *: ");
       
           input = sc.nextLine();           
        }
       //This will print out to the user when they enter * and wish to terminate
       //the program
       System.out.println("Goodbye");
       
    }
}
