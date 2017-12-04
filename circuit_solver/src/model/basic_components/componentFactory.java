package model.basic_components;

import model.circuit;

public class componentFactory {

    public componentFactory() {
    }

    public component create_component(String type, String name, circuit circuit) {
        if (type == "OR") {
            return new or(name, circuit);
        } else if (type == "AND") {
            return new and(name, circuit);
        } else if (type == "NOR") {
            return new nor(name, circuit);
        }
        return null;
    }
}
