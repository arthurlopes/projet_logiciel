package model.special_components;

import model.basic_components.component;
import model.basic_components.signal;
import model.wire;
import model.circuit;

public class pin extends component {

    private signal state;

    public pin(String name, circuit circuit) {
        super(name, circuit);
        this.state = signal.UNKOWN;
    }

    @Override
    public boolean update() {
        for (wire w:this.get_Output()) {
            w.set_signal(state);
        }
        return true;
    }

    public void change_state(signal s) {
        this.state = s;
    }

    public signal get_state() {
        return state;
    }

}
