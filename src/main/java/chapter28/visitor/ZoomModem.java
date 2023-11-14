package chapter28.visitor;

public class ZoomModem implements Modem {

    int configurationValue = 0;

    @Override
    public void dial(String pno) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void send(char c) {

    }

    @Override
    public char recv() {
        return 0;
    }

    public void accept(ModemVisitor v) {
        v.visit(this);
    }
}
