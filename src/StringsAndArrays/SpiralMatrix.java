package StringsAndArrays;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int leftBound = -1;
        int rightBound = matrix[0].length;
        int upperBound = -1;
        int lowerBound = matrix.length;

        int col = 0;
        int row = 0;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> list = new LinkedList<>();

        while (true) {

            // Keep moving to the right
            if (col < rightBound && !visited[row][col]) {
                while (true) {
                    process(matrix, list, visited, row, col);
                    if (col + 1 == rightBound || visited[row][col + 1]) {
                        if (noValidMoves(visited, row, col, leftBound, rightBound, upperBound, lowerBound)) return list;
                        row++;
                        break;
                    }
                    col++;
                }
            }

            if (row < lowerBound && !visited[row][col]) {
                // Keep moving down
                while (true) {
                    process(matrix, list, visited, row, col);
                    if (row + 1 == lowerBound || visited[row + 1][col]) {
                        if (noValidMoves(visited, row, col, leftBound, rightBound, upperBound, lowerBound)) return list;
                        col--;
                        break;
                    }
                    row++;
                }
            }

            if (col > leftBound && !visited[row][col]) {
                //Keep moving left
                while (true) {
                    process(matrix, list, visited, row, col);
                    if (col - 1 == leftBound || visited[row][col - 1]) {
                        if (noValidMoves(visited, row, col, leftBound, rightBound, upperBound, lowerBound)) return list;
                        row--;
                        break;
                    }
                    col--;
                }
            }

            if (row > upperBound & !visited[row][col]) {
                //Keep moving up
                while (true) {
                    process(matrix, list, visited, row, col);
                    if (row - 1 == upperBound || visited[row - 1][col]) {
                        if (noValidMoves(visited, row, col, leftBound, rightBound, upperBound, lowerBound)) return list;
                        col++;
                        break;
                    }
                    row--;
                }
            }
        }

    }

    static void process(int[][] matrix, List list, boolean[][] visited, int row, int col) {
        System.out.print(matrix[row][col] + " ");
        visited[row][col] = true;
        list.add(matrix[row][col]);
    }

    static boolean noValidMoves(boolean[][] visited, int row, int col, int lb, int rb, int ub, int lowerBound) {
        if (col + 1 >= rb || visited[row][col + 1]) {
            if (row + 1 >= lowerBound || visited[row + 1][col]) {
                if (col - 1 <= lb || visited[row][col -1]) {
                    if (row - 1 <= ub || visited[row - 1][col]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
