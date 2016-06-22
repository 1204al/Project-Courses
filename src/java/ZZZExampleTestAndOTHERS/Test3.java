package ZZZExampleTestAndOTHERS;

import controllers.ICommand;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        Map<String, Integer> commands = new HashMap<>();
        commands.put("a",1);
        commands.put("bb",2);
        commands.put("ac",5);
        commands.put("ad",8);
        System.out.println(commands.get("a"));
        System.out.println(commands.get("asdasd"));




    }
}
