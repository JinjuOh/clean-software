package chapter28.acyclicVisitor.part;

import java.util.HashMap;

public class PartCountVisitor implements PartVisitor {

    private int pieceCount = 0;
    private HashMap pieceMap = new HashMap();

    @Override
    public void visit(PiecePart pp) {
        pieceCount++;
        String partNumber = pp.getPartNumber();
        int partNumberCount = 0;
        if(pieceMap.containsKey(partNumber)) {
            Integer carrier = (Integer) pieceMap.get(partNumber);
            partNumberCount = carrier.intValue();
        }
        partNumberCount++;
        pieceMap.put(partNumber, new Integer(partNumberCount));
    }

    @Override
    public void visit(Assembly a) {

    }

    public int getPieceCount() {
        return pieceCount;
    }

    public int getPartNumberCount() {
        return pieceMap.size();
    }

    public int getCountForPart(String partNumber) {
        int partNumberCount = 0;
        if(pieceMap.containsKey(partNumber)) {
            Integer carrier = (Integer) pieceMap.get(partNumber);
            partNumberCount = carrier.intValue();
        }
        return partNumberCount;
    }
}
