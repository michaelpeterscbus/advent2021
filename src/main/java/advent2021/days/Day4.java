package advent2021.days;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

public class Day4 {
    private List<int[][]> boards;
    private List<Integer> drawingNumbers;

    public int bingo(String filename, String winCondition) {
        var bufferedReader = getBufferedReader(filename);
        drawingNumbers = getDrawingNumbers(bufferedReader);
        boards = getListOfBoards(bufferedReader);

        int bingoBoardIndex;
        if (winCondition.equals("first")) {
            bingoBoardIndex = findBingoAndReturnBoardIndex(drawingNumbers);
        } else {
            bingoBoardIndex = findLastBingoAndReturnBoardIndex(drawingNumbers);
        }
        var lastDrawnNumber = getLastDrawnNumber();
        var boardSum = getBoardSum(boards.get(bingoBoardIndex));
        return lastDrawnNumber * boardSum;
    }

    @SneakyThrows
    private BufferedReader getBufferedReader(String filename) {
        var file = new File("src/test/resources/day4/" + filename);
        return new BufferedReader(new FileReader(file));
    }

    @SneakyThrows
    private List<Integer> getDrawingNumbers(BufferedReader bufferedReader) {
        var drawingNumbers = Arrays.stream(bufferedReader.readLine().split(",")).map(Integer::parseInt).collect(toList());
        bufferedReader.readLine();
        return drawingNumbers;
    }

    private int findBingoAndReturnBoardIndex(List<Integer> drawingNumbers) {
        for (int i = 0; i < drawingNumbers.size(); i++) {
            int boardIndex = 0;
            for (int[][] board : boards) {
                for (int row = 0; row < board.length; row++) {
                    for (int column = 0; column < board[row].length; column++) {
                        if (board[row][column] == drawingNumbers.get(i)) {
                            board[row][column] = -1;
                            if (hasABingo(board)) {
                                return boardIndex;
                            }
                        }
                    }
                }
                boardIndex++;
            }
            drawingNumbers.set(i, -1);
        }
        return -1;
    }

    private int findLastBingoAndReturnBoardIndex(List<Integer> drawingNumbers) {
        var bingoCount = new HashSet<Integer>();
        for (int i = 0; i < drawingNumbers.size(); i++) {
            int boardIndex = 0;
            for (int[][] board : boards) {
                for (int row = 0; row < board.length; row++) {
                    for (int column = 0; column < board[row].length; column++) {
                        if (board[row][column] == drawingNumbers.get(i)) {
                            board[row][column] = -1;
                            if (hasABingo(board)) {
                                bingoCount.add(boardIndex);
                                if (bingoCount.size() == boards.size()) {
                                    return boardIndex;
                                }
                            }
                        }
                    }
                }
                boardIndex++;
            }
            drawingNumbers.set(i, -1);
        }
        return -1;
    }

    private boolean hasABingo(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < board[i].length; j++) {
                rowSum += board[i][j];
                columnSum += board[j][i];
            }
            if (rowSum == -5 || columnSum == -5) {
                return true;
            }
        }
        return false;
    }

    @SneakyThrows
    private List<int[][]> getListOfBoards(BufferedReader bufferedReader) {
        String input;
        List<int[][]> boardList = new ArrayList<>();
        int[][] currentBoard = new int[5][5];
        int columnIndex = 0;
        while ((input = bufferedReader.readLine()) != null) {
            if (input.equals("")) {
                boardList.add(currentBoard);
                currentBoard = new int[5][5];
                columnIndex = 0;
            } else {
                var currentRowArray = input.split(" ");
                var numbersInCurrentRow = new ArrayList<Integer>();
                for (int i = 0; i < currentRowArray.length; i++){
                    if (!currentRowArray[i].equals("")) {
                        numbersInCurrentRow.add(parseInt(currentRowArray[i]));
                    }
                }
                int rowIndex = 0;
                for (Integer number : numbersInCurrentRow){
                    currentBoard[columnIndex][rowIndex] = number;
                    rowIndex++;
                }
                columnIndex++;
            }
        }
        boardList.add(currentBoard);
        return boardList;
    }

    private int getLastDrawnNumber() {
        for (Integer number : drawingNumbers) {
            if (number != -1 ) {
                return number;
            }
        }
        return -1;
    }

    private int getBoardSum(int[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != -1) {
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }
}
