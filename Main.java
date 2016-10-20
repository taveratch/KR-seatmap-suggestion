import org.jpl7.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Integer;
import java.util.*;

public class Main {

    public static boolean consult() {
        Query q = new Query(
                "consult",
                new Term[] {new Atom("pl/engine.pl")});

        return q.hasSolution();
    }

    public static String readAndBuildKB() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Height: ");
        int height = Integer.parseInt(scanner.nextLine());
        System.out.print("Need extra privacy (yes/No): ");
        boolean privacy = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Travel with a child (yes/No): ");
        boolean hasChild = scanner.nextLine().equalsIgnoreCase("yes");

        return String.format("age(%d,user).", age) + "\n" +
                String.format("tall(%d,user).", height) + "\n" +
                String.format("prefers(user,private)%s", privacy ? "." : " :- false.") + "\n" +
                String.format("hasChild(user)%s", hasChild ? "." : " :- false.") + "\n";
    }

    public static void writeFile(File file, String content) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.flush();
        fw.close();
    }

    public static void createUserKB() {
        String userFactFileContent = ":- module(user_facts,[]).\n" + readAndBuildKB();
        File userFactFile = new File("pl/user_facts.pl");
        if(userFactFile.exists()) {
            userFactFile.delete();
        }
        try {
            userFactFile.createNewFile();
            writeFile(userFactFile, userFactFileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String> maxFrequency(Map<String, Integer> map) {
        List<String> result = new ArrayList<String>();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        int maxFreq = 0;
        for(Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue() > maxFreq) {
                result.clear();
                result.add(entry.getKey());
                maxFreq = entry.getValue();
            } else if(entry.getValue() == maxFreq){
                result.add(entry.getKey());
            }
        }
        return result;

    }

    public static void main(String[] args) {

        createUserKB();
        consult();

        Query q4 = new Query(
                new Compound(
                        "getSeat",
                        new Term[] { new Variable("Seat"), new Atom("user")}
                )
        );

        HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
        while (q4.hasMoreSolutions()) {
            String sol = q4.nextSolution().get("Seat").toString().toUpperCase();
            Integer freq = freqMap.get(sol);
            if(freq == null) {
                freqMap.put(sol, 1);
            } else {
                freqMap.put(sol, freq + 1);
            }
        }

        List<String> maxFrequency = maxFrequency(freqMap);
        System.out.println("Golden seats: " + maxFrequency.toString());
        Set<String> okSeats = freqMap.keySet();
        okSeats.removeAll(maxFrequency);
        System.out.println("Ok seats: " + okSeats);
    }
}
