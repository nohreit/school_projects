package Mimir.Homework4;


import java.util.ArrayList;
import java.util.Iterator;

public class Driver implements DriverInterface {
    public static void main(String[] args) {
        Driver driver = new Driver();
        ArrayList<TestTimes> queueTests = new ArrayList<>();
        ArrayList<TestTimes> stackTests = new ArrayList<>();

        for (int qType = 0; qType < QueueType.values().length; qType++) {
            for (int qTest = 0; qTest < QueueTestType.values().length; qTest++)
                queueTests.add(driver.runQueueTestCase(driver.queueType(qType),
                        driver.queueTestType(qTest), 10));
        }

        for (int sType = 0; sType < StackType.values().length; sType++) {
            for (int sTest = 0; sTest < StackTestType.values().length; sTest++)
                stackTests.add(driver.runStackTestCase(driver.stackType(sType),
                        driver.stackTestType(sTest), 10));
        }
        println(queueTests.size());
        println(stackTests.size());
    }

    public Driver() {
    }

    final int size = 10000;

    @Override
    public QueueInterface<String> createQueue(QueueType queueType, QueueTestType queueTestType) {
        QueueInterface<String> queue;
        switch (queueType) {
            case ArrayBasedQueue: {
                ArrayBasedQueue<String> arrQ = new ArrayBasedQueue<>();
                if (arrQ.isEmpty()) {
                    for (int i = 0; i < size; i++)
                        arrQ.enqueue("String " + (i + 1));
                }
                switch (queueTestType) {
                    case Enqueue:
                        arrQ = new ArrayBasedQueue<>();
                        if (arrQ.isEmpty()) {
                            for (int i = 0; i < size; i++)
                                arrQ.enqueue("String " + (i + 1));
                        }
                        break;
                    case Dequeue:
                        if (!arrQ.isEmpty()) {
                            for (String ignored : arrQ)
                                arrQ.dequeue();
                        } else throw new NullPointerException("Empty list");
                        break;
                    case Iterate:
                        if (!arrQ.isEmpty()) {
                            Iterator<String> it = arrQ.iterator();
                            while (it.hasNext()) {
                                println(it.next());
                            }
                        } else throw new NullPointerException("Empty list");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + queueTestType);
                }
                queue = arrQ;
            }
            break;
            case LinkedQueue: {
                LinkedQueue<String> linkQ = new LinkedQueue<>();
                if (linkQ.isEmpty()) {
                    for (int i = 0; i < size; i++)
                        linkQ.enqueue("String " + (i + 1));
                }
                switch (queueTestType) {
                    case Enqueue:
                        linkQ = new LinkedQueue<>();
                        if (linkQ.isEmpty()) {
                            for (int i = 0; i < size; i++)
                                linkQ.enqueue("String " + (i + 1));
                        }
                        break;
                    case Dequeue:
                        if (!linkQ.isEmpty()) {
                            for (String ignored : linkQ)
                                linkQ.dequeue();
                        } else throw new NullPointerException("Empty list");
                        break;
                    case Iterate:
                        if (!linkQ.isEmpty()) {
                            Iterator<String> it = linkQ.iterator();
                            while (it.hasNext()) {
                                println(it.next());
                            }
                        } else throw new NullPointerException("Empty list");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + queueTestType);
                }
                queue = linkQ;
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + queueType);
        }
        return queue;
    }

    @Override
    public StackInterface<String> createStack(StackType stackType, StackTestType stackTestType) {
        StackInterface<String> stack;
        switch (stackType) {
            case ArrayBasedStack: {
                ArrayBasedStack<String> arrS = new ArrayBasedStack<>();
                if (arrS.isEmpty()) {
                    for (int i = 0; i < size; i++)
                        arrS.push("String " + (i + 1));
                }
                switch (stackTestType) {
                    case Push:
                        arrS = new ArrayBasedStack<>();
                        if (arrS.isEmpty()) {
                            for (int i = 0; i < size; i++)
                                arrS.push("String " + (i + 1));
                        }
                        break;
                    case Pop:
                        if (!arrS.isEmpty()) {
                            for (String ignored : arrS)
                                arrS.pop();
                        } else throw new NullPointerException("Empty list");
                        break;
                    case Iterate:
                        if (!arrS.isEmpty()) {
                            Iterator<String> it = arrS.iterator();
                            while (it.hasNext()) {
                                println(it.next());
                            }
                        } else throw new NullPointerException("Empty list");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + stackTestType);
                }
                stack = arrS;
            }
            break;
            case LinkedStack: {
                LinkedStack<String> linkS = new LinkedStack<>();
                if (linkS.isEmpty()) {
                    for (int i = 0; i < size; i++)
                        linkS.push("String " + (i + 1));
                }
                switch (stackTestType) {
                    case Push:
                        linkS = new LinkedStack<>();
                        if (linkS.isEmpty()) {
                            for (int i = 0; i < size; i++)
                                linkS.push("String " + (i + 1));
                        }
                        break;
                    case Pop:
                        if (!linkS.isEmpty()) {
                            for (String ignored : linkS)
                                linkS.pop();
                        } else throw new NullPointerException("Empty list");
                        break;
                    case Iterate:
                        if (!linkS.isEmpty()) {
                            Iterator<String> it = linkS.iterator();
                            while (it.hasNext()) {
                                println(it.next());
                            }
                        } else throw new NullPointerException("Empty list");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + stackTestType);
                }
                stack = linkS;
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + stackType);
        }
        return stack;
    }

    @Override
    public TestTimes runQueueTestCase(QueueType queueType, QueueTestType queueTestType, int numberOfTimes) {
        TestTimes testTimes = new TestTimes();
        for (int i = 0; i < numberOfTimes; i++) {
            testTimes.startTime = System.nanoTime();
            this.createQueue(queueType, queueTestType);
            testTimes.endTime = System.nanoTime();
            testTimes.addTestTime((long) (testTimes.endTime - testTimes.startTime));
        }
        return testTimes;
    }

    @Override
    public TestTimes runStackTestCase(StackType stackType, StackTestType stackTestType, int numberOfTimes) {
        TestTimes testTimes = new TestTimes();

        for (int i = 0; i < numberOfTimes; i++) {
            testTimes.startTime = System.nanoTime();
            this.createStack(stackType, stackTestType);
            testTimes.endTime = System.nanoTime();
            testTimes.addTestTime((long) (testTimes.endTime - testTimes.startTime));
        }
        return testTimes;
    }

    public QueueType queueType(int p) {
        QueueType q;
        switch (p) {
            case 0:
                q = QueueType.ArrayBasedQueue;
                break;
            case 1:
                q = QueueType.LinkedQueue;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
        }
        return q;
    }

    public QueueTestType queueTestType(int p) {
        QueueTestType q;
        switch (p) {
            case 0:
                q = QueueTestType.Enqueue;
                break;
            case 1:
                q = QueueTestType.Dequeue;
                break;
            case 2:
                q = QueueTestType.Iterate;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
        }
        return q;
    }

    public StackType stackType(int p) {
        StackType q;
        switch (p) {
            case 0:
                q = StackType.ArrayBasedStack;
                break;
            case 1:
                q = StackType.LinkedStack;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
        }
        return q;
    }

    public StackTestType stackTestType(int p) {
        StackTestType q;
        switch (p) {
            case 0:
                q = StackTestType.Push;
                break;
            case 1:
                q = StackTestType.Pop;
                break;
            case 2:
                q = StackTestType.Iterate;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
        }
        return q;
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}
