package com.company;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class gui {


        public static void main(String[] args) {

            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showOpenDialog(null);
            // int returnValue = jfc.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                System.out.println("the maze file is "+selectedFile.getAbsolutePath());
                Main Maze_solution = new Main(selectedFile.getAbsolutePath());
            }

        }

    }



