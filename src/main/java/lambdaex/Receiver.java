package lambdaex;

@FunctionalInterface
public interface Receiver {
    void process(String msg);
}
