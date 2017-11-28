package model.basic_components;

import model.wire;
import model.circuit;

public class and extends component {

    public and(String name, circuit circuit) {
        super(name, circuit);
    }

    @Override
    public boolean update() {
        signal old = this.get_Output().get(0).get_signal();
        signal cur = this.get_Input().get(0).get_signal();
        for (wire w: this.get_Input()) {
            this.get_Input().stream().skip(1);
            if (w.get_signal() == signal.FALSE || cur == signal.FALSE) {
                cur = signal.FALSE;
            } else if (w.get_signal() == signal.TRUE && cur == signal.TRUE) {
                cur = signal.TRUE;
            } else {
                cur = signal.UNKOWN;
            }
        }

        for (wire w: this.get_Output()) {
            w.set_signal(cur);
        }

        if (cur == old) {
            return false;
        } else {
            return true;
        }
    }
}
