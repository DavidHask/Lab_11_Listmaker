import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> array = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String input = "";
        boolean done = false;

        do {
            System.out.println("Please choose an option: ");
            System.out.println("A – Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("I – Insert an item into the list");
            System.out.println("P – Print (i.e. display) the list");
            System.out.println("Q – Quit the program ");

            input = in.nextLine();
            if (input.equalsIgnoreCase("a")) {
                addItem(in);
            }
            if (input.equalsIgnoreCase("d")) {
                deleteItem(in);
            }
            if (input.equalsIgnoreCase("i")) {
                insertItem(in);
            }
            if (input.equalsIgnoreCase("p")) {
                print();
            }
            if (input.equalsIgnoreCase("q")) {
                done = quit();
            }

        } while (!done);
    }

    private static void addItem(Scanner pipe) {

        String item = SafeInputs.getNonZeroLenString(in, "What item do you want to add?");
        array.add(item);

    }

    private static void deleteItem(Scanner pipe) {

        int index = SafeInputs.getRangedInt(in, "What index do you want" +
                " to delete?", 0, array.size() - 1);
        array.remove(index);

    }

    private static void insertItem(Scanner pipe) {

        int index = SafeInputs.getRangedInt(in, "What index do you want" +
                " to replace?", 0, array.size() - 1);
        String item = SafeInputs.getNonZeroLenString(in, "What is the item?");
        array.set(index, item);

    }

    private static void print() {

        System.out.println("Index:   Item: ");

        for (int i = 0; i < array.size(); i++ ) {
            System.out.println(i + "    " + array.get(i));
        }

    }

    private static boolean quit() {

        boolean done = false;

        done = SafeInputs.getYNConfirm(in, "Are you sure you want to quit?");

        return done;

    }
}