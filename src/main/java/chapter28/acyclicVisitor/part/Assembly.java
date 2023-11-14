package chapter28.acyclicVisitor.part;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Assembly implements Part {

    private List parts = new LinkedList();
    private String partNumber;
    private String description;

    public Assembly(String partNumber, String description) {
        this.partNumber = partNumber;
        this.description = description;
    }

    public void add(Part part) {
        parts.add(part);
    }

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Iterator getParts() {
        return parts.iterator();
    }

    @Override
    public void accept(PartVisitor v) {
        v.visit(this);
        Iterator i = getParts();
        while (i.hasNext()) {
            Part p = (Part) i.next();
            p.accept(v);
        }

    }
}
