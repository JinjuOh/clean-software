package chapter28.acyclicVisitor.part;

public interface Part {
    public String getPartNumber();
    public String getDescription();
    public void accept(PartVisitor v);
}
