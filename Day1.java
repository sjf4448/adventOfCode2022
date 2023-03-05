import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

class Elf implements Comparable<Elf>{
    /** total calories carried by this eld */
    private int calories;

    /**
     * creates a new elf associated with a number of calories
     * */
    Elf(ArrayList<Integer> food){
        for (int item: food){
            this.calories += item;
        }
    }

    /**
     * returns the total calories carried by this elf
     * */
    int getCalories() {
        return calories;
    }

    @Override
    public int compareTo(Elf o) {
        return o.calories - this.calories;
    }
}
public class Day1{
    /**
     * uses a file input to build a list of elves
     * */
    private static TreeSet<Elf> buildElves(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner sc = new Scanner(f);

        TreeSet<Elf> elves = new TreeSet<>();

        ArrayList<Integer> food = new ArrayList<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.equals("")){
                elves.add(new Elf(food));
                food.clear();
            }
            else {
                food.add(Integer.parseInt(line));
            }
        }
        return elves;
    }

    /**
     * creates a set of elves associated with a number of calories
     * prints the three highest calorie counts
     * prints the sum of the three highest calorie counts
     * */
    public static void main(String[] args) throws FileNotFoundException {
        TreeSet<Elf> elves = buildElves(args[0]);
        int topThree = 0;
        for (int i = 0; i < 3; i++){
            int calories = elves.first().getCalories();
            System.out.println(calories);
            topThree += calories;
            elves.remove(elves.first());
        }
        System.out.println("Sum: " + topThree);
    }
}
