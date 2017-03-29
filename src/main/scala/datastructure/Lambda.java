package datastructure;

import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by WAZHANG-DEV on 3/3/2017.
 */
@ClassPreamble(
   author = "Justin",
   date = "02/12/2005"
)
@interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
}

public class Lambda
{
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block
    ) {
        for(X p: source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }

        source.forEach(entry->{
            if (tester.test(entry)) {
                block.accept(mapper.apply(entry));
            }
        });
    }

    //use aggregate functions
    public static void processIterator(List<String> source) {
        source.stream().filter(entry->entry.contains("ABC")).map(entry->entry.replace('a', 'b')).forEach(entry->System.out.print(entry));
    }

    interface Operator<T> {
        int operation(T x, T y);
    }

    public int caculator(int a, int b, Operator<Integer> operator){
        return operator.operation(a, b);
    }

    @Test
    public void TestCaculator(){
        Operator<Integer> add = (a, b)->a+b;
        Operator<Integer> substract = (a, b) -> a - b;

        caculator(4, 5, add);
        caculator(10,9, substract);
    }
}

