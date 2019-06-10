package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // make result to manipulate it from any function
   static char result[][];
String maze_path;
   public Main( String maze_path){

        // read required file by file path
        File fd = new File(maze_path);
        // Scanner for file reading
        Scanner in = null;
        try {
            in = new Scanner(fd);
        } catch (FileNotFoundException e) {
            // error handling
            System.out.println("can't find file plz fix path and make sure file exist \n" + e.toString());
        }

// read maze paramters

       int  width = in.nextInt(); // column
       int  height = in.nextInt(); // row
       // set empty container for input maze
      int [][]  maze = new int[height][width];

       // init result two dimension array width and height
       result = new char[height][width];

        int s_x_index = in.nextInt(); // start x index
        int s_y_index = in.nextInt();   // start y index
        int e_x_index = in.nextInt();  // end x index
        int e_y_index = in.nextInt();  // end y index

        // fill  a two dimensional array with values
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                maze[i][j] = in.nextInt();
        in.close();


        // set Maze path

       Path path= new Path();


        // replace each one by #
     path.build_border(width, height,maze);

        // test the result array after replcing  print_result();

        // define start and end point
        point  srt_poi = new point(s_x_index, s_y_index );
        point  end_poi= new point(e_x_index,e_y_index);

        // check if the maze solvable or not and solve the maze
     if(  path.solver(srt_poi, end_poi)!='X'){
         System.out.println("unsolvable ");
     }
     else{

         System.out.println("the maze solution is ");
        path.print_result();}
    }





}
