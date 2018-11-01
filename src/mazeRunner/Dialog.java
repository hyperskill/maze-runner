package mazeRunner;

import javafx.util.Pair;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Dialog {

    private static final Pattern pattern = Pattern.compile(" *\\d+ +\\d+ *$");

    public static Pair<Integer, Integer> getSize() {
        askForInput();
        Pair<Integer, Integer> size;
        while (true) {
            try {
                size = readInput();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            if (size.getKey() < 3 || size.getValue() < 3) {
                System.out.println(Messages.WRONG_SIZE.message);
                continue;
            }
            break;

        }
        return size;
    }

    private static void askForInput() {
        System.out.println(Messages.START.message);
    }

    private static Pair<Integer, Integer> readInput() throws Exception {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (!pattern.matcher(line).matches()) {
            throw new Exception(Messages.WRONG_FORMAT.message);
        }
        Scanner inLine = new Scanner(line);

        return new Pair<>(inLine.nextInt(), inLine.nextInt());
    }

    enum Messages {
        START("Please, enter the size of a maze"), WRONG_FORMAT("Wrong input format. Please try again."),
        WRONG_SIZE("Wrong size of the maze. One size can not be less than 3. Please try again");
        final String message;

        Messages(String message) {
            this.message = message;
        }
    }
}
