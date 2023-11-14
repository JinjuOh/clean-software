package chapter28.acyclicVisitor.part;

public interface PartVisitor {
    public void visit(PiecePart pp);
    public void visit(Assembly a);
}
