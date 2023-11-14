package chapter28.acyclicVisitor.part;

public class ExplodedCostVisitor implements PartVisitor {
    private double cost = 0;

    public double cost() {
        return cost;
    }

    @Override
    public void visit(PiecePart pp) {
        cost += pp.getCost();
    }

    @Override
    public void visit(Assembly a) {
    }

}
