package Mimir.Homework3;

public class Driver implements DriverInterface {
    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        Driver driver = new Driver();
        for (int pickTestType = 0; pickTestType < 6; pickTestType++) {
            for (int pickListType = 0; pickListType < 2; pickListType++) {
                driver.runTestCase(pickListType(pickListType), pickTestType(pickTestType),
                        10);
            }
        }
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public Driver() {
    }

    @Override
    public ListInterface<Integer> createList(ListType listType, TestType forTestType) {
        ListInterface<Integer> list = null;
        if (listType == ListType.ArrayBasedList) {
            ListInterface<Integer> arrayList = null;
            switch (forTestType) {
                case AddSortedOdd:
                    arrayList = new ArrayBasedList<>(5000);
                    initializeList(arrayList, 1, 9999, 2);
                    break;
                case AddSortedEven:
                    arrayList = new ArrayBasedList<>(5000);
                    initializeList(arrayList, 2, 10000, 2);
                    break;
                case AddAll:
                    arrayList = new ArrayBasedList<>(10000);
                    initializeList(arrayList, 1, 10000, 1);
                    break;
                case AddAllAtIndexZero:
                    arrayList = new ArrayBasedList<>(10000);
                    arrayList.add(arrayList.size(), 0);
                    break;
                case RemoveAllEven:
                    arrayList = createList(ListType.ArrayBasedList, TestType.AddAll);
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i) % 2 == 0)
                            arrayList.remove(i);
                    }
                    break;
                case RemoveAllOdd:
                    arrayList = createList(ListType.ArrayBasedList, TestType.AddAll);
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i) % 2 != 0)
                            arrayList.remove(i);
                    }
                    break;
            }
            list = arrayList;
        } else if (listType == ListType.LinkedList) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            switch (forTestType) {
                case AddSortedOdd:
                    initializeList(linkedList, 1, 9999, 2);
                    break;
                case AddSortedEven:
                    initializeList(linkedList, 2, 10000, 2);
                    break;
                case AddAll:
                    initializeList(linkedList, 1, 10000, 1);
                    break;
                case AddAllAtIndexZero:
                    linkedList.add(linkedList.size(), 0);
                    break;
                case RemoveAllEven:
                    linkedList = (LinkedList<Integer>) createList(ListType.LinkedList, TestType.AddAll);
                    for (int i = 0; i < linkedList.size(); i++) {
                        if (linkedList.get(i) % 2 == 0)
                            linkedList.remove(i);
                    }
                    break;
                case RemoveAllOdd:
                    linkedList = (LinkedList<Integer>) createList(ListType.LinkedList, TestType.AddAll);
                    for (int i = 0; i < linkedList.size(); i++) {
                        if (linkedList.get(i) % 2 != 0)
                            linkedList.remove(i);
                    }
                    break;
            }
            list = linkedList;
        }

        return list;
    }

    @Override
    public ListInterface<Integer> initializeList(ListInterface<Integer> list, int firstNumber, int
            lastNumber, int increment) {
        if (increment == 0)
            return null;

        for (int i = firstNumber; i <= lastNumber; i += increment)
            list.add(i);
        return list;
    }

    @Override
    public double memoryUsage() {
        return (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())
                / (double) (1024 * 1024);
    }

    @Override
    public TestTimes runTestCase(ListType listType, TestType testType, int numberOfTimes) {
        TestTimes testTimes = new TestTimes();

        for (int i = 0; i < numberOfTimes; i++) {
            testTimes.startTime = System.nanoTime();
            createList(listType, testType);
            testTimes.startTime = System.nanoTime();
            testTimes.addTestTime(testTimes.endTime - testTimes.startTime);
        }
        return testTimes;
    }

    public static ListType pickListType(int i) {
        ListType listType = null;
        switch (i) {
            case 0:
                listType = ListType.ArrayBasedList;
                break;
            case 1:
                listType = ListType.LinkedList;
                break;
        }
        return listType;
    }

    public static TestType pickTestType(int i) {
        TestType testType = null;
        switch (i) {
            case 0:
                testType = TestType.AddSortedOdd;
                break;
            case 1:
                testType = TestType.AddSortedEven;
                break;
            case 2:
                testType = TestType.AddAll;
                break;
            case 3:
                testType = TestType.AddAllAtIndexZero;
                break;
            case 4:
                testType = TestType.RemoveAllEven;
                break;
            case 5:
                testType = TestType.RemoveAllOdd;
                break;
        }
        return testType;
    }
}
