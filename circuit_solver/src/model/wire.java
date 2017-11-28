package model;

import model.basic_components.component;
import model.basic_components.signal;

import java.util.ArrayList;
import java.util.List;

public class wire {

    String name;
    private circuit circuit;
    private component input;
    private List<component> output = new ArrayList<component>();
    private signal state;

    public wire(String name, circuit circuit) {
        this.name  = name;
        this.state = signal.UNKOWN;
        circuit.add_wire(this);
    }

    public String getName() {
        return name;
    }

    public signal get_signal() {
        return this.state;
    }

    public void set_signal(signal signal) {
        this.state = signal;
    }

    public void set_input(component component) {
        this.input = component;
    }

    public void add_output(component component) {
        this.output.add(component);
    }

    public List<component> getOutput() {
        return output;
    }

    public void print() {
        System.out.println("-------------- Wire --------------");
        System.out.println(this.name);
        System.out.println(this.state);
        System.out.println("----------------------------------");
    }
}
