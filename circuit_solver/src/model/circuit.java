package model;

import model.basic_components.component;
import model.basic_components.signal;

import java.util.*;

public class circuit {

    private static final int MAX = 100;

    // Singleton
    private static circuit instance = new circuit();

    private List<component> components = new ArrayList<component>();
    private List<wire> wires = new ArrayList<wire>();

    private Queue<component> queue = new LinkedList();

    private circuit() {

    }

    public static circuit getInstance(){
        return instance;
    }

    public void update() {
        int count = 0;
        Hashtable hash = new Hashtable();
        for (component c:components) {
            queue.add(c);
            hash.put(c, c.getName());
            count += 1;
        }
        while (!queue.isEmpty()) {
            for (component c:queue) {
                c.print();
            }
            System.out.println("-----------------------------------------");
            component cur;
            cur = queue.remove();
            if (hash.get(cur.getName()) == null) {
                hash.remove(cur.getName());
            }
            if (cur.update()) {
                for (wire w:cur.get_Output()) {
                    for (component c:w.getOutput()) {
                        if (hash.containsValue(c.getName()) == false) {
                            queue.add(c);
                            hash.put(c, c.getName());
                            count += 1;
                        }
                    }
                }
            }
            if (cur.get_Output().get(0).get_signal() == signal.UNKOWN) {
                queue.add(cur);
                count += 1;
            }
            if (count > MAX * components.size()) {
                System.out.println("Oscillation!!!");
                break;
            }
        }
        System.out.println(count);
    }

    public void add_component(component component) {
        components.add(component);
    }

    public void add_wire(wire wire) {
        wires.add(wire);
    }
}
