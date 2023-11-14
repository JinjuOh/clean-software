package chapter28.acyclicVisitor.modem;

public class HayesModem implements Modem {

    String configurationString = null;

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
            HayesModemVisitor hv = (HayesModemVisitor) v;
            hv.visit(this);
        } catch (ClassCastException e) {

        }
    }
}
