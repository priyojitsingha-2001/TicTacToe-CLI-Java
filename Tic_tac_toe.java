import java.util.Scanner;

class Tic_tac_toe {
    // 00 02 04
    // 20 22 24
    // 40 42 44
    static boolean trun = true;
    static char[][] board = { { ' ', '|', ' ', '|', ' ' },
            { '-', '+', '-', '+', '-' },
            { ' ', '|', ' ', '|', ' ' },
            { '-', '+', '-', '+', '-' },
            { ' ', '|', ' ', '|', ' ' } };

    static void starting_message() {
        System.out.println("\t  TIC TAC TOE");
        try {
            System.out.println("RULES:");
            Thread.sleep(2000);
            System.out.println("To place your mark on board enter the box number");
            Thread.sleep(2000);
            System.out.println("For first box press 1 and it follows till 9");
            Thread.sleep(2000);
            System.out.println("like this:");
            Thread.sleep(2000);
            char[][] sample_board = { { '1', '|', '2', '|', '3' },
                    { '-', '+', '-', '+', '-' },
                    { '4', '|', '5', '|', '6' },
                    { '-', '+', '-', '+', '-' },
                    { '7', '|', '8', '|', '9' } };
            for (int i = 0; i < 5; i++) {
                System.out.print("\t");
                for (int j = 0; j < 5; j++) {
                    System.out.print(sample_board[i][j]);
                }
                System.out.println();
            }
            Thread.sleep(2000);
            System.out.println("player 1: O\tPlayer 2: X\n\tstarts after 5s......");
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    static void whose_turn(char board[][]) {
        Scanner sc = new Scanner(System.in);
        print_board(board);
        if (trun == true) {
            trun = true;
            System.out.print("player 1 (O): ");
            int position = sc.nextInt();
            place(board, position, 'O');
            trun = false;
        } else {
            trun = false;
            System.out.print("player 2 (X): ");
            int position = sc.nextInt();
            place(board, position, 'X');
            trun = true;
        }
    }

    static boolean is_board_empty(char board[][]) {
        // check wether the board is full or atleast have an empty room
        System.out.println("\033[H\033[2J");//this clears the console
        System.out.flush();//flush() function resets the cursor position to the top of the screen
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == ' ')
                    return true;
            }
        }
        return false;
    }

    static void print_board(char board[][]) {
        // function that prints the game board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void place(char board[][], int position, char player) {
        // checks wether the place on board is empty/unplayed and puts it according to
        // the place

        // first row
        if (position == 1 && board[0][0] == ' ')
            board[0][0] = player;
        if (position == 2 && board[0][2] == ' ')
            board[0][2] = player;
        if (position == 3 && board[0][4] == ' ')
            board[0][4] = player;
        // second row
        if (position == 4 && board[2][0] == ' ')
            board[2][0] = player;
        if (position == 5 && board[2][2] == ' ')
            board[2][2] = player;
        if (position == 6 && board[2][4] == ' ')
            board[2][4] = player;
        // third row
        if (position == 7 && board[4][0] == ' ')
            board[4][0] = player;
        if (position == 8 && board[4][2] == ' ')
            board[4][2] = player;
        if (position == 9 && board[4][4] == ' ')
            board[4][4] = player;
    }
    static char winner(char board[][]) {
        // Horizontal win conditions
        if ((board[0][0] == 'O') && (board[0][2] == 'O') && (board[0][4] == 'O'))
            return 'O';
        else if ((board[0][0] == 'X') && (board[0][2] == 'X') && (board[0][4] == 'X'))
            return 'X';
        else if ((board[2][0] == 'O') && (board[2][2] == 'O') && (board[2][4] == 'O'))
            return 'O';
        else if ((board[2][0] == 'X') && (board[2][2] == 'X') && (board[2][4] == 'X'))
            return 'X';
        else if ((board[4][0] == 'O') && (board[4][2] == 'O') && (board[4][4] == 'O'))
            return 'O';
        else if ((board[4][0] == 'X') && (board[4][2] == 'X') && (board[4][4] == 'X'))
            return 'X';
        // Vertical win conditions
        else if ((board[0][0] == 'O') && (board[2][0] == 'O') && (board[4][0] == 'O'))
            return 'O';
        else if ((board[0][0] == 'X') && (board[2][0] == 'X') && (board[4][0] == 'X'))
            return 'X';
        else if ((board[0][2] == 'O') && (board[2][2] == 'O') && (board[4][2] == 'O'))
            return 'O';
        else if ((board[0][2] == 'X') && (board[2][2] == 'X') && (board[4][2] == 'X'))
            return 'X';
        else if ((board[0][4] == 'O') && (board[2][4] == 'O') && (board[4][4] == 'O'))
            return 'O';
        else if ((board[0][4] == 'X') && (board[2][4] == 'X') && (board[4][4] == 'X'))
            return 'X';
        // diagonal win conditions
        else if ((board[0][0] == 'O') && (board[2][2] == 'O') && (board[4][4] == 'O'))
            return 'O';
        else if ((board[0][0] == 'X') && (board[2][2] == 'X') && (board[4][4] == 'X'))
            return 'X';
        else if ((board[4][0] == 'O') && (board[2][2] == 'O') && (board[0][4] == 'O'))
            return 'O';
        else if ((board[4][0] == 'X') && (board[2][2] == 'X') && (board[0][4] == 'X'))
            return 'X';
        // draw condition
        else
            return 'D';
    }

    public static void main(String[] args) {
        starting_message(); // it displays the rules at the begining of the game
        if ((int)(2+(Math.random()*100))%2==0) {
            trun=true;
        } else {
            trun=false;
        }
        while (is_board_empty(board)) {
            whose_turn(board);
        }
        if(winner(board)=='X')
        System.out.println("\t\tX WON");
        else if(winner(board)=='O')
        System.err.println("\t\tO WON\n");
        else
        System.out.println("\t\tDRAW\n");
        //printing the final board for ease
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}