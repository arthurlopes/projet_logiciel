package model;

import model.basic_components.component;
import model.basic_components.signal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class circuit {

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
        for (component c:components) {
            queue.add(c);
        }
        while (!queue.isEmpty()) {
            component cur;
            cur = queue.remove();
            if (cur.update()) {
                for (wire w:cur.get_Output()) {
                    for (component c:w.getOutput()) {
                        queue.add(c);
                    }
                }
            }
            if (cur.get_Output().get(0).get_signal() == signal.UNKOWN) {
                queue.add(cur);
            }
        }
    }

    public void add_component(component component) {
        components.add(component);
    }

    public void add_wire(wire wire) {
        wires.add(wire);
    }
}
