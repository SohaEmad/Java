package com.company;

public class Path {

    char [][]result = Main.result;

    public  void build_border( int width, int height, int[][]maze){
        // fill result array with values for the border
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < Main.result[0].length; j++) {
                if (maze[i][j] == 1) {
                    Main.result[i][j] = '#';
                }
                else Main.result[i][j]='0';

            }
        }


    }

    public  void print_result()
    {
        // print result array
        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[i].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public  char solver( point start, point end ) {

// set the start and end of the maze to find the path
        result[start.y_pos][start.x_pos] = 's';
        result[end.x_pos][end.y_pos] = 'E';
        char solvable = find_path(result, start);

        //Clear the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == 'N' || result[i][j] == '0') {
                    result[i][j] = ' ';
                }

            }
        }
// set the start and the end again for the final output stage
        result[start.y_pos][start.x_pos] = 's';
        result[end.x_pos][end.y_pos] = 'E';
        return solvable;
    }

    private  char find_path(char[][] maze_in, point pos)
    {
        if(result[pos.y_pos][pos.x_pos] == 'E'){
            return 'X';	}

        else
        {

            // try south
            char temp = '0';
            result[pos.y_pos][pos.x_pos] = 'v';	//Visited

            int offset = pos.y_pos + 1;
            if(offset >= maze_in.length) offset = 0;
            char south = result[offset][pos.x_pos];

            if(south == '0' || south == 'E')
            {
                temp = find_path(maze_in, new point(offset, pos.x_pos));
                result[offset][pos.x_pos] = temp;
                if(temp == 'X') return 'X' ;
            }


            //  try east
            offset = pos.x_pos + 1;
            if(offset >= maze_in[0].length) offset = 0;

            char east = result[pos.y_pos][offset];
            if(east == '0' || east == 'E')
            {
                //Go east
                temp= find_path(maze_in, new point(pos.y_pos , offset));
                result[pos.y_pos][offset] = temp;
                if(temp == 'X') return 'X';
            }



// try west
            offset = pos.x_pos - 1;
            if (offset < 0) offset = maze_in[0].length - 1;

            char west = result[pos.y_pos][offset];
            if (west == '0' || west == 'E') {
                //Go west
                temp = find_path(maze_in, new point(pos.y_pos, offset));
                result[pos.y_pos][offset] = temp;
                if (temp == 'X') return 'X';
            }


// try north
            offset = pos.y_pos - 1;
            if (offset < 0) offset = maze_in.length - 1;

            char north = result[offset][pos.x_pos];
            if (north == '0' || north == 'E') {
                //Go north
                temp = find_path(maze_in, new point(offset, pos.x_pos));
                result[offset][pos.x_pos] = temp;
                if (temp == 'X') return 'X';
            }

        }

        return 'N';	//Dead-end go back

    }
}
