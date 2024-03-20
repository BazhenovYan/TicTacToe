package GeekBrains.ProcStyleTicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class ProcStyleTicTacToe {

    /* private  - значит, что можно использовать только в данном классе
     (область видимости)*/

    /*static - можно использовать только в статических методах */
    /*Arrays.fill - используется для заполнения массива одинаковыми значениями*/
    private  final static char DOT_X = 'X';
    private final static char DOT_O = '0';
    private final static char DOT_EMPTY = '•';

    private final static int SIZE = 3;
   private  static char[][] map = new char[SIZE][SIZE];



    public static void main(String[] args) {

        initMap(); // инициализация поля
        printMap(); // печать поля

        goMan();


        //checkRow(row);
        //checkCol(col);
    }
    private static void goMan(){
        Scanner scan = new Scanner(System.in);
        int row;
        int col;

        do {
            System.out.println("Введите координаты строку: ");
            row = scan.nextInt();

            System.out.println("Введите координаты колонку: ");
            col = scan.nextInt();

            if (!checkCol(col) || !checkRow(row)) {
                continue;
            }
            if (checkCol(col) || checkRow(row)){
                System.out.println("Значения должно быть целым числом в диапазоне от 1 до " + SIZE);
                break;
            }

        }
        while(!checkCell(row, col));

        map[row][col] = DOT_X;
        printMap();
    }

    private static boolean checkCell(int row, int col){
        if (row < 1 || row > SIZE || col < 1 || col > SIZE) {
            return false;
        }
        if (map[row][col] == DOT_EMPTY){
            return true;
        }
        return false;
    }

    private static boolean checkRow(int row) {

        if (row < 1 || row > SIZE) {

        }
        return false;

    }

    private static boolean checkCol(int col) {
        if (col < 1 || col > SIZE) {

        }
        return false;
    }

    private static void initMap() {
        for (int i = 0; i < map.length; i++) {

       Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    private static void printMap() {
        printMapHeader(); // печать шапки (нумерации колонки)
        printMapState(); // печать карты (поля)
    }

    private static void printMapState() {
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1)+ " " ); // нумерация строк
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static void printMapHeader() {
        for (int i = 0; i <= map.length; i++) {
            System.out.print(i + " "); // нумерация столбцов

        }
        System.out.println();
        System.out.println();
    }

}
