package chapter28.acyclicVisitor.modem;

public class ErnieModem implements Modem {

    String internalPattern = null;

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
        try {
            ErnieModemVisitor ev = (ErnieModemVisitor) v;
            ev.visit(this);
        } catch (ClassCastException e) {

        }
    }

}
