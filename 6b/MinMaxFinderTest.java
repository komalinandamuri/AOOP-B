public class MinMaxFinderTest {
    public static void main(String[] args) {
        // Test with Integer
        Integer[] intArray = {3, 1, 4, 1, 5, 9};
        MinMaxFinder<Integer> intFinder = new MinMaxFinderImpl<>();
        System.out.println("Integer Array - Max: " + intFinder.findMax(intArray));
        System.out.println("Integer Array - Min: " + intFinder.findMin(intArray));

        // Test with Float
        Float[] floatArray = {3.14f, 1.59f, 2.65f, 5.89f};
        MinMaxFinder<Float> floatFinder = new MinMaxFinderImpl<>();
        System.out.println("Float Array - Max: " + floatFinder.findMax(floatArray));
        System.out.println("Float Array - Min: " + floatFinder.findMin(floatArray));

        // Test with String
        String[] stringArray = {"apple", "banana", "cherry"};
        MinMaxFinder<String> stringFinder = new MinMaxFinderImpl<>();
        System.out.println("String Array - Max: " + stringFinder.findMax(stringArray));
        System.out.println("String Array - Min: " + stringFinder.findMin(stringArray));

        // Test with Character
        Character[] charArray = {'a', 'b', 'c', 'd'};
        MinMaxFinder<Character> charFinder = new MinMaxFinderImpl<>();
        System.out.println("Character Array - Max: " + charFinder.findMax(charArray));
        System.out.println("Character Array - Min: " + charFinder.findMin(charArray));
    }
}
