package zajecia11;

import zajecia11.exceptions.MyException;
import zajecia11.input.Input;
import zajecia11.output.Output;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Zajecia11 {
    public static void main(String[] args) throws IOException {
//        MyException.main(args); // + finally
//        Input.main(args);
        Output.main(args);

        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        pq1.offer(3);
        pq1.offer(6);
        pq1.offer(1);
        pq1.offer(9);
        System.out.println(pq1);

        while(pq1.iterator().hasNext()) {
            System.out.println(pq1.poll()); // Uwaga! kolejka trzyma elementy w strukturze heap
            // elementy wyciągane są w uporządkowany sposób tylko w momencie wywołania heap!
        }

        PriorityQueue<String> pq2 = new PriorityQueue<String>();
        pq2.offer("test1");
        pq2.offer("abc");
        pq2.offer("bed");
        pq2.offer("fed");

        System.out.println("println()");
        System.out.println(pq2);

        System.out.println("foreach");

        for (String s : pq2) {
            System.out.println(s);
        }

        System.out.println("poll()");

        while(pq2.iterator().hasNext()) {
            System.out.println(pq2.poll());
        }
    }

}
