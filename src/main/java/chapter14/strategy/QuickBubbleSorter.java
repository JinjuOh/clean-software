package chapter14.strategy;

public class QuickBubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandle itsSorthandle = null;

    public QuickBubbleSorter(SortHandle handle) {
        this.itsSorthandle = handle;
    }

    public int sort(Object array) {
        itsSorthandle.setArray(array);
        length = itsSorthandle.length();
        operations = 0;

        if(length <= 1) {
            return operations;
        }

        boolean thisPassInOrder = false;
        for (int nextToLast = length - 2; nextToLast >= 0 && !thisPassInOrder ; nextToLast--) {
            thisPassInOrder = true; // 잠재적으로
            for (int index = 0; index <= nextToLast ; index++) {
                if(itsSorthandle.outOfOrder(index)) {
                    itsSorthandle.swap(index);
                    thisPassInOrder = false;
                    operations++;
                }
            }
        }
        return operations;
    }
}
