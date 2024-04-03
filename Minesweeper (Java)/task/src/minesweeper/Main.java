package minesweeper;

import java.lang.Math;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void printMineField(String[][] minefield) {
        for (int i = 0; i < minefield.length; i++) {
            if (i == 0) {
                System.out.println(" |123456789|");
                System.out.println("-|---------|");
                System.out.printf("%d|", i + 1);
            } else {

                System.out.printf("%d|", i + 1);

            }
            for (int j = 0; j < minefield[i].length; j++) {
                System.out.print(minefield[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("-|---------|");
    }

    public static String[][] updateSeeableField(String[][] updatedMinefield2, String[][] SeeableField, String[][] minefieldWithMines2) {

        for(int i = 0; i < 9 * 9; i++) {
            for(int j = 0; j < SeeableField.length; j++) {
                for(int k = 0; k < SeeableField[0].length; k++) {

                    if (SeeableField[j][k].equals("/")) {

                        if (j > 0 && k > 0 && !SeeableField[j - 1][k - 1].equals("/")) {
                            if (!minefieldWithMines2[j - 1][k - 1].equals("X")) {
                                SeeableField[j - 1][k - 1] = updatedMinefield2[j - 1][k - 1];
                                if (updatedMinefield2[j - 1][k - 1].equals(".")) {
                                    SeeableField[j - 1][k - 1] = "/";
                                }
                            }
                        }

                        if (j > 0 && !SeeableField[j - 1][k].equals("/")) {
                            if (!minefieldWithMines2[j - 1][k].equals("X")) {
                                SeeableField[j - 1][k] = updatedMinefield2[j - 1][k];
                                if (updatedMinefield2[j - 1][k].equals(".")) {
                                    SeeableField[j - 1][k] = "/";
                                }
                            }
                        }

                        if (j > 0 && k < updatedMinefield2[j].length - 1 && !SeeableField[j - 1][k + 1].equals("/")) {
                            if (!minefieldWithMines2[j - 1][k + 1].equals("X")) {
                                SeeableField[j - 1][k + 1] = updatedMinefield2[j - 1][k + 1];
                                if (updatedMinefield2[j - 1][k + 1].equals(".")) {
                                    SeeableField[j - 1][k + 1] = "/";
                                }
                            }
                        }

                        if (k < updatedMinefield2[j].length - 1 && !SeeableField[j][k + 1].equals("/")) {
                            if (!minefieldWithMines2[j][k + 1].equals("X")) {
                                SeeableField[j][k + 1] = updatedMinefield2[j][k + 1];
                                if (updatedMinefield2[j][k + 1].equals(".")) {
                                    SeeableField[j][k + 1] = "/";
                                }
                            }
                        }

                        if (j < updatedMinefield2.length - 1 && k < updatedMinefield2[j].length - 1 && !SeeableField[j + 1][k + 1].equals("/")) {
                            if (!minefieldWithMines2[j + 1][k + 1].equals("X")) {
                                SeeableField[j + 1][k + 1] = updatedMinefield2[j + 1][k + 1];
                                if (updatedMinefield2[j + 1][k + 1].equals(".")) {
                                    SeeableField[j + 1][k + 1] = "/";
                                }
                            }
                        }

                        if (j < updatedMinefield2.length - 1 && !SeeableField[j + 1][k].equals("/")) {
                            if (!minefieldWithMines2[j + 1][k].equals("X")) {
                                SeeableField[j + 1][k] = updatedMinefield2[j + 1][k];
                                if (updatedMinefield2[j + 1][k].equals(".")) {
                                    SeeableField[j + 1][k] = "/";
                                }
                            }
                        }

                        if (j < updatedMinefield2.length - 1 && k > 0 && !SeeableField[j + 1][k - 1].equals("/")) {
                            if (!minefieldWithMines2[j + 1][k - 1].equals("X")) {
                                SeeableField[j + 1][k - 1] = updatedMinefield2[j + 1][k - 1];
                                if (updatedMinefield2[j + 1][k - 1].equals(".")) {
                                    SeeableField[j + 1][k - 1] = "/";
                                }
                            }
                        }

                        if (k > 0 && !SeeableField[j][k - 1].equals("/")) {
                            if (!minefieldWithMines2[j][k - 1].equals("X")) {
                                SeeableField[j][k - 1] = updatedMinefield2[j][k - 1];
                                if (updatedMinefield2[j][k - 1].equals(".")) {
                                    SeeableField[j][k - 1] = "/";
                                }
                            }
                        }
                    }
                }
            }
        }




        return SeeableField;
    }

    public static String[][] updateDangerLevel(String[][] minefield) {

        int danger = 0;
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                if (minefield[i][j].equals("X")) {
                    continue;

                } else {

                    if (i > 0 && j > 0) {
                        if (minefield[i - 1][j - 1].equals("X")) {
                            danger++;
                        }
                    }

                    if (i > 0) {
                        if (minefield[i - 1][j].equals("X")) {
                            danger++;
                        }
                    }

                    if (i > 0 && j < minefield[i].length - 1) {
                        if (minefield[i - 1][j + 1].equals("X")) {
                            danger++;
                        }
                    }

                    if (j < minefield[i].length - 1) {
                        if (minefield[i][j + 1].equals("X")) {
                            danger++;
                        }
                    }

                    if (i < minefield.length - 1 && j < minefield[i].length - 1) {
                        if (minefield[i + 1][j + 1].equals("X")) {
                            danger++;
                        }
                    }

                    if (i < minefield.length - 1) {
                        if (minefield[i + 1][j].equals("X")) {
                            danger++;
                        }
                    }

                    if (i < minefield.length - 1 && j > 0) {
                        if (minefield[i + 1][j - 1].equals("X")) {
                            danger++;
                        }
                    }

                    if (j > 0) {
                        if (minefield[i][j - 1].equals("X")) {
                            danger++;
                        }
                    }
                }

                if (danger > 0) {
                    minefield[i][j] = Integer.toString(danger);
                    danger = 0;
                } else {

                }
            }
        }

        return minefield;
    }

    public static String[][] printPlayableMinefield(String[][] minefield) {

        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                if (minefield[i][j].equals("X")) {
                    minefield[i][j] = ".";
                }
            }
        }
        return minefield;
    }


    public static void main(String[] args) {
        // write your code here
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int danger = 0;
        int minesFound = 0;
        int flagsFound = 0;

        String[][] minefield = new String[9][9];
        String[][] playableMinefield = new String[9][9];
        String [][] minefieldWithMines = new String[9][9];
        String[][] SeeableMinefield = new String[9][9];
        String[][] minefieldWithMines2 = new String[9][9];
        String [][] updatedMinefield2 = new String[9][9];
        String[][] solution = new String[9][9];

        for (int i = 0; i < minefield.length; i++) {

            for (int j = 0; j < minefield[i].length; j++) {
                minefield[i][j] = ".";
            }
        }

        for (int i = 0; i < minefield.length; i++) {

            for (int j = 0; j < minefield[i].length; j++) {
                SeeableMinefield[i][j] = ".";
            }
        }

        System.out.println("How many mines do you want on the field?");
        int mines = scan.nextInt();
        for (int i = 0; i < mines; i++) {
            int ranI = random.nextInt(minefield.length);
            int ranJ = random.nextInt(minefield[0].length);
            if (minefield[ranI][ranJ].equals("X")) {
                i--;
            } else {
                minefield[ranI][ranJ] = "X";
            }
        }

        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                minefieldWithMines[i][j] = minefield[i][j];
            }
        }
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                minefieldWithMines2[i][j] = minefield[i][j];
            }
        }


        updateDangerLevel(minefield);
        playableMinefield = printPlayableMinefield(minefield);

        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                updatedMinefield2[i][j] = playableMinefield[i][j];
            }
        }

        


        //printMineField(playableMinefield);
        printMineField(SeeableMinefield);
        int move = 0;
        while (true) {
            move++;

            System.out.println("Set/delete mines marks (x and y coordinates): ");
            int coordiX = scan.nextInt();
            int coordiY = scan.nextInt();
            String type = scan.next();



            if (type.equals("free")) {
                if (move == 1 && minefieldWithMines[coordiY - 1][coordiX - 1].equals("X")) {

                    for (int i = 0; i < 1; i++) {
                        int ranI = random.nextInt(minefield.length);
                        int ranJ = random.nextInt(minefield[0].length);

                        if (minefieldWithMines[ranI][ranJ].equals("X")) {
                            i--;

                        } else {
                            minefieldWithMines[ranI][ranJ] = "X";
                            minefieldWithMines[coordiY - 1][coordiX - 1] = ".";
                            minefieldWithMines2[coordiY - 1][coordiX - 1] = ".";
                            minefieldWithMines2[ranI][ranJ] = "X";
                            SeeableMinefield[coordiY - 1][coordiX - 1] = "/";
                            //playableMinefield[coordiY - 1][coordiX - 1] = "/";
                            updateDangerLevel(minefieldWithMines);
                            updatedMinefield2 = printPlayableMinefield(minefieldWithMines);



                            if (Character.isDigit(updatedMinefield2[coordiY - 1][coordiX - 1].charAt(0))) {
                                SeeableMinefield[coordiY - 1][coordiX - 1] = updatedMinefield2[coordiY - 1][coordiX - 1];
                            } else {
                                SeeableMinefield[coordiY - 1][coordiX - 1] = "/";
                                SeeableMinefield = updateSeeableField(updatedMinefield2, SeeableMinefield, minefieldWithMines2);
                            }
                        }
                    }
                } else if (minefieldWithMines2[coordiY - 1][coordiX - 1].equals("X")) {
                    System.out.println("You stepped on a mine and failed!");
                    System.exit(0);

                } else if (Character.isDigit(updatedMinefield2[coordiY - 1][coordiX - 1].charAt(0))) {
                    SeeableMinefield[coordiY - 1][coordiX - 1] = updatedMinefield2[coordiY - 1][coordiX - 1];

                } else {
                    SeeableMinefield[coordiY - 1][coordiX - 1] = "/";
                    SeeableMinefield = updateSeeableField(updatedMinefield2, SeeableMinefield, minefieldWithMines2);
                }
            }

            if (type.equals("mine")) {

                if (playableMinefield[coordiY - 1][coordiX - 1].equals("*")) {
                    playableMinefield[coordiY - 1][coordiX - 1] = ".";
                    SeeableMinefield[coordiY - 1][coordiX - 1] = ".";
                    flagsFound--;
                } else {
                    playableMinefield[coordiY - 1][coordiX - 1] = "*";
                    SeeableMinefield[coordiY - 1][coordiX - 1] = "*";
                    flagsFound++;
                }
            }
            for(int l = 0; l < updatedMinefield2.length; l++ ) {
                for(int m = 0; m < updatedMinefield2[0].length; m++) {

                    if (minefieldWithMines2[l][m].equals("X")) {
                        solution[l][m] = minefieldWithMines2[l][m];
                    } else if(Character.isDigit(updatedMinefield2[l][m].charAt(0))) {
                        solution[l][m] = updatedMinefield2[l][m];
                    } else {
                        solution[l][m] = "/";
                    }
                }
            }
            printMineField(SeeableMinefield);
            //printMineField(updatedMinefield2);
            //printMineField(minefieldWithMines2);
            int solutionNum = 0;
            int counter = 0;

            for (int i = 0; i < minefield.length; i++) {

                for (int j = 0; j < minefield[i].length; j++) {
                    if (minefieldWithMines2[i][j].equals("X")) {
                        if (SeeableMinefield[i][j].equals("*")) {
                            minesFound++;
                            if(minesFound == mines) {

                                /*for (int k = 0; k < minefield.length; k++) {

                                    for (int l = 0; l < minefield[i].length; l++) {

                                        if (playableMinefield[k][l].equals("*")) {

                                                flagsFound++;


                                        }


                                    }
                                }*/
                                if (flagsFound == mines){

                                    System.out.println("Congratulations! You found all the mines!");
                                    System.exit(0);
                                }

                            }
                        }
                    }



                }
                for(int l = 0; i < minefield.length; i++) {
                    for(int m = 0; m < minefield[0].length; m++) {

                        if (Character.isDigit(solution[l][m].charAt(0)) || solution[l][m].equals("/")) {
                            solutionNum++;
                        }
                        if (SeeableMinefield[l][m].equals(solution[l][m])) {
                            counter++;
                            if (counter == solutionNum) {
                                System.out.println("Congratulations! You found all the mines!");
                                System.exit(0);

                            }
                        }
                    }
                }
            }
            minesFound = 0;
            counter = 0;


        }

    }
}
