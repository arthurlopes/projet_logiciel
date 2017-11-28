package model.basic_components;

import model.wire;
import model.circuit;

import java.util.ArrayList;
import java.util.List;

public abstract class component implements updatable {

    private String name;
    private circuit circuit;
    private List<wire> input  = new ArrayList<wire>();
    private List<wire> output = new ArrayList<wire>();

    public component(String name, circuit circuit) {
        this.name = name;
        this.circuit = circuit;
        circuit.add_component(this);
    }

    public void remove_input(wire wire) {
        // TODO
    }

    public void remove_output(wire wire) {
        // TODO
    }

    public String getName() {
        return this.name;
    }

    public List<wire> get_Input() {
        return input;
    }

    public List<wire> get_Output() {
        return output;
    }

    public void add_Input(wire input) {
        this.input.add(input);
        input.add_output(this);
    }

    public void add_Output(wire output) {
        this.output.add(output);
        output.set_input(this);
    }

    public void print() {
        System.out.println("------------ Component -----------");
        System.out.println(this.name);
    }
}
