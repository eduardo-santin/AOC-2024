package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;

public class day1_1 {
    public static void main(String[] args) {
        try {
            //puzzle input list
            // List <Integer> puzzle_list1 = new ArrayList<>();
            // List <Integer> puzzle_list2 = new ArrayList<>();
            LinkedList<Integer> puzzle_list1 = new LinkedList<>();
            LinkedList<Integer> puzzle_list2 = new LinkedList<>();


            // Create a file object 
            File file = new File("day1/input.txt"); 

            // Get the absolute path of file f 
            String absolute = file.getAbsolutePath();
            file = new File(absolute);
            System.out.println("Reading File: " + file.getAbsolutePath());

            // verify it exist
            if (!file.exists()) {
                System.err.println("File not found: " + absolute);
                return;
            }

            // parse data
            //puzzle input is two columns
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();


            while (line != null) 
            {

                // put the value in the seperate list
                String [] numbers = line.split("   ");

                puzzle_list1.add(Integer.parseInt(numbers[0]));
                puzzle_list2.add(Integer.parseInt(numbers[1]));

                line = reader.readLine();

            }

            int sum = 0;

            int x = 0;
            int y = 0;

            // iterate through the list and find the lowest value in both columns
            while (!puzzle_list1.isEmpty()) 
            {


                // find the smallest value in the first column
                x = puzzle_list1.get(puzzle_list1.indexOf(Collections.min(puzzle_list1)));
                y = puzzle_list2.get(puzzle_list2.indexOf(Collections.min(puzzle_list2)));


                // add the value to the sum
                sum += Math.abs(y - x);


                // remove the value from the list
                puzzle_list1.remove(puzzle_list1.indexOf(Collections.min(puzzle_list1)));
                puzzle_list2.remove(puzzle_list2.indexOf(Collections.min(puzzle_list2)));

            }

            System.out.println("Sum: " + sum);


            reader.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
