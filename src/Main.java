import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //task 1
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));

        nums.stream().filter(n -> n % 2 != 0).forEach(System.out::print);
        System.out.println();
        //task2
        Set<Integer> setNums = new TreeSet<>(nums);
        setNums.stream().filter(n -> n % 2 == 0).forEach(System.out::print);
        System.out.println();

        //task3&4
        String context, result = "";
        try {
            context = Files.readString(Paths.get("src/text.txt"));
            result = context.replaceAll("[^a-zA-Zа-яА-Я ]", "").toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Long> mapWords = Stream.of(result.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        mapWords.keySet().forEach(System.out::println);
        mapWords.values().forEach(System.out::println);
        mapWords.entrySet().forEach(System.out::println);
    }
}