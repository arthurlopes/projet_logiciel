package com.company;

import model.circuit;
import model.basic_components.*;
import model.special_components.pin;
import model.wire;

public class Main {

    public static void main(String[] args) {
        circuit circuit = model.circuit.getInstance();
        componentFactory factory = new componentFactory();
        component c1 = factory.create_component("NOR", "comp1", circuit);
        component c2 = factory.create_component("NOR", "comp2", circuit);
        wire w1 = new wire("wire1", circuit);
        wire w2 = new wire("wire2", circuit);
        wire w3 = new wire("wire3", circuit);
        wire w4 = new wire("wire4", circuit);
        pin p1  = new pin("pin1", circuit);
        pin p2  = new pin("pin2", circuit);

        p1.add_Output(w1);
        p2.add_Output(w2);
        c1.add_Input(w1);
        c2.add_Input(w2);
        c1.add_Input(w3);
        c2.add_Output(w3);
        c1.add_Output(w4);
        c2.add_Input(w4);

        p1.change_state(signal.FALSE);
        p2.change_state(signal.TRUE);

        circuit.update();

        System.out.println("-------------------- STATES --------------------------");
        w1.print();
        w2.print();
        w3.print();
        w4.print();

    }
}
