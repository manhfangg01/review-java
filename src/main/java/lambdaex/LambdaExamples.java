package lambdaex;

import java.security.AsymmetricKey;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class LambdaExamples {
    int limit = 3;

    void doIt(){
        List<String> names=List.of("Java", "Python", "C++", "JavaScript", "Go");
        names.stream().filter(name -> name.length() > limit).forEach(System.out::println);
        limit++;
        System.out.println("-------------------------------");
    }
    void main() {
        doIt();
        doIt();
    }
}
