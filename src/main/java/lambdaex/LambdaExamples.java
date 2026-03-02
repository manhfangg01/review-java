package lambdaex;

import java.util.Comparator;
import java.util.function.BiConsumer;

public class LambdaExamples {
     void main() {
         /*
         Nếu nó thấy đó là Tên Class (chữ cái đầu viết hoa, ví dụ String::toUpperCase, Claims::getSubject),
         nó hiểu là: "À, đối số đầu tiên sẽ là thằng gọi hàm".

         Nếu nó thấy đó là một Biến/Đối tượng (ví dụ myPrinter::print, System.out::println, examMapper::toResponse),
         nó hiểu là: "À, thằng này có sẵn rồi, đối số truyền vào sẽ là tham số cho hàm của nó".
          */
         // Tạo 1 anonymous class
         MyPrinter printer = System.out::println;

         printer.printCustom("Hello World!");
         printer.printWithTimestamp("Hello World!");
         MyPrinter.printSystemHeader("Hello World!");



    }
}
