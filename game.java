import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class game {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        char player = 'x';
        char computer = 'o';
        int count = 0;                                                              // يحسب عدد مرات الإدخال في حال حدوث تعادل

        char[][] gameboard = new char[3][3];
        gameboard[0][0] = '1';
        gameboard[0][1] = '2';
        gameboard[0][2] = '3';
        gameboard[1][0] = '4';
        gameboard[1][1] = '5';
        gameboard[1][2] = '6';
        gameboard[2][0] = '7';
        gameboard[2][1] = '8';
        gameboard[2][2] = '9';

        boolean gameover = false;

        while (!gameover) {
            printboard(gameboard);
            System.out.println("Enter number from 1 to 9:");
            int number = e.nextInt();

            // جزء دور اللاعب
            // احول الرقم الى صف وعمود
            int row = (number - 1) / 3; // الرقم الي يدخله يقسمه على 3 لتحديد الصف
            int col = (number - 1) % 3; // الرقم الي يدخله يأخذ منه الباقي لتحديد العمود
            if (number >= 1 && number <= 9 && gameboard[row][col] == (char) (number + '0')) {                                     // بيحول الرقم المدخل الى حرف
                gameboard[row][col] = player;                                                                         // بيحط حرف اللاعب في الخانة
                count++;

                // اتحقق من فوز اللاعب
                if (win(gameboard, player, computer)) {
                    printboard(gameboard);
                    System.out.println("You are the winner!");
                    gameover = true;

                } else if (nowin(count)) {
                    printboard(gameboard);
                    System.out.println("There is no winner!");
                    gameover = true;

                    // جزء الكمبيوتر
                } else {
                    boolean validmove = false;
                    while (!validmove) {
                        int computernumber = ThreadLocalRandom.current().nextInt(1, 10);                                               // اختيار رقم عشوائي بين 1 و 9
                        row = (computernumber - 1) / 3;
                        col = (computernumber - 1) % 3;
                        if (computernumber >= 1 && computernumber <= 9 && gameboard[row][col] == (char) (computernumber + '0')) {                 // التحقق من حركة الكمبيوتر
                            gameboard[row][col] = computer;                                                                                        // بيحط حرف الكمبيوتر في الخانة
                            count++;

                            // تحقق من فوز الكمبيوتر
                            if (win(gameboard, computer, player)) {
                                printboard(gameboard);
                                System.out.println("Computer is the winner!");
                                gameover = true;
                            } else if (nowin(count)) {
                                printboard(gameboard);
                                System.out.println("There is no winner!");
                                gameover = true; }
                            validmove = true;
                        } } }
            } else {
                System.out.println("Invalid move. Try again!");
            } } }

    // اطبع المصفوفة
    public static void printboard(char[][] board) {
        for (int row = 0; row < board.length; row++) {                                                                                // يعبي كل صف
            for (int col = 0; col < board[row].length; col++) {                                               // حطيتها بداخل فور عشان أول صف يعبي فيه 3 أعمدة وهكذا
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();  }}

    // دالة فحص الفوز
    public static boolean win(char[][] board, char player, char opponent) {
        // تحقق من الصفوف
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;                                                                      // فوز اللاعب
            }
            if (board[row][0] == opponent && board[row][1] == opponent && board[row][2] == opponent) {
                return true;                                                                    // فوز الكمبيوتر
            }}

        // تحقق من الأعمدة
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;                                                                            // فوز اللاعب
            }
            if (board[0][col] == opponent && board[1][col] == opponent && board[2][col] == opponent) {
                return true;                                                                            // فوز الكمبيوتر
            }}

        // تحقق من الفوز في الزوايا
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player) ||
                (board[0][0] == opponent && board[1][1] == opponent && board[2][2] == opponent) ||
                (board[0][2] == opponent && board[1][1] == opponent && board[2][0] == opponent); }

    // اتحقق من التعادل
    public static boolean nowin(int count) {
        return count == 9;                                                     // يتحقق من إذا كانت جميع الخانات ممتلئة
    }
}










