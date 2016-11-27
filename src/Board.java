public class Board {
    private Mark[][] board;
    private static final int TO_WIN = 4;
    private static final int MIN_LINE = 0;
    private static final int MAX_LINE = 5;
    private static final int MIN_CELL = 0;
    private static final int MAX_CELL = 6;

    public Board() {
        board = new Mark[MAX_LINE + 1][MAX_CELL + 1];
        for (int line = 0; line < (MAX_LINE + 1); line++) {
            for (int cell = 0; cell < (MAX_CELL + 1); cell++) {
                board[line][cell] = Mark.EMPTY;
            }
        }
    }
    
    public void printBoard() {
        System.out.println(" ");
        for (int line = 0; line < (MAX_LINE + 1); line++) {
            System.out.print((MAX_LINE - line) + " | ");
            for (int cell = 0; cell < (MAX_CELL + 1); cell++) {
                System.out.print(board[line][cell] + " | ");
            }
            System.out.println();
        }
        System.out.println("    0   1   2   3   4   5   6 ");
        System.out.println(" ");
    }

    public void placeMark(int cell, int line, Mark mark) {
        board[line][cell] = mark;
    }
    
    public int findFreeLine(int cell) {
        int line = MAX_LINE;
        while (board[line][cell] != Mark.EMPTY) {
            line--;
            if (line < MIN_LINE) {
                return line = -1;
            }
        }
        return line;
    }
    
    public boolean isCellFull (int freeLine) {
        if (freeLine >= MIN_LINE) {
            return false;
        }
        return true;
    }
    
    public boolean checkIfCellInRange (int cell) {
        if (cell <= MAX_CELL && cell >= MIN_CELL) {
            return true;
        }
        return false;
    }
    
    public boolean checkIfWins(Mark mark, int cell, int line) {
        boolean horizontalLine = checkHorizontals(mark);
        boolean verticalLine = checkVerticals(mark);
        boolean diagonalLine = checkDiaganals(mark, cell, line);
        if (horizontalLine || verticalLine || diagonalLine) {
            return true;
        } 
        return false;
    }

    private boolean checkHorizontals(Mark mark) {
        boolean wins = false;
        int marksInLine = 0;
        for (int cell = 0; cell < (MAX_CELL + 1); cell++) {
            for (int line = 0; line < (MAX_LINE + 1); line++) {
                if (board[line][cell] == mark) {
                    marksInLine++;
                    if (marksInLine == TO_WIN) {
                        wins = true;
                    }
                } else {
                    marksInLine = 0;
                }
            }
        }
        return wins;
    }

    private boolean checkVerticals(Mark mark) {
        boolean wins = false;
        int marksInLine = 0;
        for (int line = 0; line < (MAX_LINE + 1); line++) {
            for (int cell = 0; cell < (MAX_CELL + 1); cell++) {
                if (board[line][cell] == mark) {
                    marksInLine++;
                    if (marksInLine == TO_WIN) {
                        wins = true;
                    }
                } else {
                    marksInLine = 0;
                }
            }
        }
        return wins;
    }

    private boolean checkDiaganals(Mark mark, int cell, int line) {
        if (checkRightDiaganals(mark, cell, line) || checkLeftDiaganals(mark, cell, line)) {
            return true;
        }
        return false;
    }
    
    private boolean checkRightDiaganals(Mark mark, int cell, int line) {
        boolean wins = false;
        int marksInLine = 0;
        cell = cell - TO_WIN + 1;
        for (int i = (line + TO_WIN - 1); i > (line - TO_WIN + 1); i--) {
            if(checkIfFieldInBoard(cell, i)) {
                if (board[i][cell] == mark) {
                    marksInLine++;
                    if (marksInLine == TO_WIN) {
                        wins = true;
                    }
                } else {
                    marksInLine = 0;
                }
            }
            cell++;
        }
        return wins;
    }
    
    private boolean checkLeftDiaganals(Mark mark, int cell, int line) {
        boolean wins = false;
        int marksInLine = 0;
        cell = cell - TO_WIN + 1;
        for (int i = (line - TO_WIN + 1); i < (line + TO_WIN - 1); i++) {
            if(checkIfFieldInBoard(cell, i)) {
                if (board[i][cell] == mark) {
                    marksInLine++;
                    if (marksInLine == TO_WIN) {
                        wins = true;
                    }
                } else {
                    marksInLine = 0;
                }
            }
            cell++;
        }
        return wins;
    }
    
    private boolean checkIfFieldInBoard (int cell, int line) {
        boolean cellIsInRange = (cell <= MAX_CELL && cell >= MIN_CELL);
        boolean lineIsInRange = (line <= MAX_LINE && line >= MIN_LINE);
        return cellIsInRange && lineIsInRange;
    }
}
