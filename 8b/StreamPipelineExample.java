import java.util.*;
import java.util.stream.Collectors;

public class StreamPipelineExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> processedNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .map(n -> n * 2)         // Double them
                .collect(Collectors.toList()); // Collect into a list

        System.out.println(processedNumbers);
    }
}
