package lambdaex;

import java.util.Comparator;
import java.util.function.BiConsumer;

public class LambdaExamples {
     void main() {
        Comparator<String> stringComparator= new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        int compare = stringComparator.compare("a", "b");
        System.out.printf("compare = %d%n", compare);

        Comparator<String> lambdaComparator = String::compareTo;
        Comparator<Integer> integerComparator = Integer::compare;

        int compare1 =lambdaComparator.compare("a", "b");
        int compare2 =integerComparator.compare(1,2);

        BiConsumer<Integer,Integer> consumer = (a, b) -> System.out.println("With lambda"+a+b);
        consumer.accept(compare1,compare2);

    }
}
