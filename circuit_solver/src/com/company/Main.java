package com.company;

import model.circuit;
import model.basic_components.*;
import model.special_components.pin;
import model.wire;

public class Main {

    public static void main(String[] args) {
        circuit circuit = model.circuit.getInstance();
        componentFactory factory = new componentFactory();
        component c1 = factory.create_component("AND", "comp1", circuit);
        component c2 = factory.create_component("OR", "comp2", circuit);
        wire w1 = new wire("wire1", circuit);
        wire w2 = new wire("wire2", circuit);
        wire w3 = new wire("wire3", circuit);
        wire w4 = new wire("wire4", circuit);
        wire w5 = new wire("wire5", circuit);
        wire w6 = new wire("wire6", circuit);
        pin p1  = new pin("pin1", circuit);
        pin p2  = new pin("pin2", circuit);
        pin p3  = new pin("pin3", circuit);
        pin p4  = new pin("pin4", circuit);

        c1.add_Input(w1);
        c1.add_Input(w2);
        c1.add_Output(w3);
        c2.add_Input(w3);
        c2.add_Input(w4);
        c2.add_Output(w5);
        c2.add_Input(w6);
        p1.add_Output(w1);
        p2.add_Output(w2);
        p3.add_Output(w4);
        p4.add_Output(w6);


        p1.change_state(signal.TRUE);
        p2.change_state(signal.TRUE);
        p3.change_state(signal.FALSE);
        p4.change_state(signal.FALSE);


        circuit.update();

        /*
        p1.update();
        p2.update();
        p3.update();
        p4.update();
        c1.update();
        c2.update();
        */
        System.out.println("-------------------- STATES --------------------------");
        w1.print();
        w2.print();
        w3.print();
        w4.print();
        w5.print();
        w6.print();

    }
}
