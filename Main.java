import org.jpl7.*;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Query q = new Query(
                "consult",
                new Term[] {new Atom("pl/engine.pl")});
        System.out.print(q.hasSolution());
        Map<String, Term> sols[] = q.allSolutions();
        for(Map<String, Term> sol: sols) {
            System.out.println(sol.toString());
        }

        Query q4 = new Query(
                new Compound(
                        "getSeat",
                        new Term[] { new Variable("Seat"), new Atom("adam")}
                )
        );
        System.out.println(q4.hasSolution());
        ArrayList<String> seats = new ArrayList<>();
        while (q4.hasMoreSolutions()) {
            Term sol = q4.nextSolution().get("Seat");
            seats.add(sol.toString());
        }
        seats.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(seats);

    }
}
