package lambdaex;

import java.security.AsymmetricKey;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class LambdaExamples {
    void main() {
        Receiver receiver = msg -> {
            Predicate<String> filter = Predicate.not(String::isBlank);
            Function<String, String> function = mess -> "[LOG]"+ mess.toUpperCase() ;
            Consumer<String> consumer = System.out::println;

            if(filter.test(msg)) {
               String drop= function.apply(msg);
               consumer.accept(drop);
            }
            else  {
                System.out.println("Lo");
            }
        };
        receiver.process("Hello");
    }
}
