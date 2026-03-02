package lambdaex;

@FunctionalInterface
public interface MyPrinter {
    // 1. Abstract Method: Đây là "trái tim" của Lambda
    // Bạn phải tự định nghĩa logic khi sử dụng.
    void printCustom(String msg);

    // 2. Default Method: "Tính năng tặng kèm"
    // Các đối tượng tạo từ interface này có sẵn dùng luôn, có thể gọi từ instance.
    default void printWithTimestamp(String msg) {
        String timestamp = java.time.LocalTime.now().toString();
        System.out.println("[" + timestamp + "] Default: " + msg);
    }

    // 3. Static Method: "Công cụ dùng chung"
    // Thuộc về bản thân Interface, gọi trực tiếp bằng tên Interface, không cần tạo object.
    static void printSystemHeader(String title) {
        System.out.println("=== SYSTEM STATIC: " + title.toUpperCase() + " ===");
    }
}
