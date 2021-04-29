package semantic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import lab1.ParseException;


public class SymbolTable {
    HashMap<String, Integer> map = new HashMap<>();

    public Integer get(String name) throws ParseException {
        if (!map.containsKey(name))
            throw new ParseException(name + " is not found in the symbol table");

        return map.get(name);
    }

    public void set(String name, Integer value) {

        map.put(name, value);
    }

    public void printMap() {
        System.out.println("Map = ");
        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
