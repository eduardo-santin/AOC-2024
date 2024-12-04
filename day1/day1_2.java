package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;

public class day1_2 {
    public static void main(String[] args) 
    {
        try 
        {
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
                // get the head of the list, use poll cause it also removes it, neat.
                x = puzzle_list1.poll();
                // System.out.println("x: " + x);


                int counter = 0;

                // find how many times the value of x appears on list2
                for (int i = 0; i < puzzle_list2.size(); i++) 
                {
                    if (x == puzzle_list2.get(i)) 
                    {
                        counter++;
                    }
                }

                sum += Math.abs(counter * x);
                // pop head

            }

            System.out.println("Sum: " + sum);



            reader.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
