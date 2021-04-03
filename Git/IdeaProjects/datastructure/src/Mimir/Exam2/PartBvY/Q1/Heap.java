package Mimir.Exam2.PartBvY.Q1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Heap<T> implements StepCounter<T>{
    protected ArrayList<T> items;
    private int numComparisons, numSwaps;
    private Comparator<? super T> comparator;

    //47, 33, 99, 51, 42, 13, 28, 64, 76

    public Heap(){
        items = new ArrayList<>();
    }
    //
    public Heap(Comparator<? super T> comparator){
        items = new ArrayList<T>();
        this.comparator = comparator;
    }
    //
    public Heap(ArrayList<T> arr){
        items = arr;
        this.heapifyUp();
    }
    //
//	//O(1)
    public boolean isEmpty(){
        return (items.size() == 0) ;
    }
    //
//	//O(1)
    public T peek(){
        if(!isEmpty()){
            return items.get(0);
        }
        return null;
    }
    //	//O(log n)
    private void heapRebuild(int rootIndex) {
        int childIndex = (2 * rootIndex)+1;
        if(childIndex < items.size()){
            int rightChildIndex = childIndex+1;
            //compare siblings to use larger one
            if( (rightChildIndex <  items.size() )  &&
                    ( compareItems(   items.get(rightChildIndex) , items.get(childIndex)  ) > 0)    ){
                childIndex = rightChildIndex; //use rightChild to compare against the parent since it is the larger of the 2 children
            }
            //compare parent with larger child node
            if( compareItems(items.get(rootIndex) ,  items.get(childIndex)  )  < 0  ){
                swap(rootIndex, childIndex, items);//child is greater than the parent so we need to swap //swap counter incremented in method
                heapRebuild(childIndex);//recursive call to make the subtree into a heap (MOVE DOWNWARD and compare)
            }
        }
    }

	private void swap(int i, int j, ArrayList<T> arr) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
        this.incrementNumSwaps();
	}

    private void heapifyUp() {
        for(int i=items.size()-1; i>=0; i--){
            heapRebuild(i);
        }
    }

	@SuppressWarnings("unchecked")
	private int compareItems(T item1, T item2){
        this.incrementNumComparisons();
        if(comparator == null){
            return (((Comparable <T>) item1).compareTo(item2));
        }
        return comparator.compare(item1, item2);
	}

    @Override
    public void resetNumComparisons() {
        this.numComparisons = 0;
    }

    @Override
    public void resetNumSwaps() {
        this.numSwaps = 0;
    }

    @Override
    public void resetAllCounters() {
         this.resetNumComparisons();
         this.resetNumSwaps();
    }

    @Override
    public int getNumComparisons() {
        return this.numComparisons;
    }

    @Override
    public int getNumSwaps() {
        return this.numSwaps;
    }

    @Override
    public void incrementNumComparisons() {
        this.numComparisons++;
    }

    @Override
    public void incrementNumSwaps() {
        this.numSwaps++;
    }
    /* Q1
         * Implement the StepCounter Interface provided and override all its methods accordingly.
        Note: displayNumComparisonsAndNumSwaps should print using the following format
        "Number of Comparisons= %03d | Number of Swaps= %03d\n"
     */

    @Override
	public void displayNumComparisonsAndNumSwaps(){
        printf("Number of Comparisons= %03d | Number of Swaps= %03d\n", numComparisons, numSwaps);
	}
	/* Q2
	 * Write the method displayContent(), so that it prints the content of the Heap’s array
	Note: print each item on its own line with the index followed by the item using the following format
	"[%3d]  %4s\n"
	 */

	public void displayContent(){
        for (int i = 0; i < items.size(); i++) {
            printf("[%3d]  %4s\n", i, items.get(i));
        }
	}

    /* Q3
     * Rewrite the insert method so that it will
     * return an array containing the number of Comparisons, number of Swaps
     * performed to complete the insertion of item into the Heap
     */
    public int[] insert(T item)throws HeapException{
        this.resetAllCounters();
        if(!items.add(item)){
            throw new HeapException("Heap Insertion Failed");
        }
        int loc = items.size()-1;
        int parentIndex = (loc-1)/2;

        while( (parentIndex >= 0 ) && ( compareItems(items.get(loc),items.get(parentIndex)  )  >0 ) ){
            swap(loc, parentIndex, items);
            loc = parentIndex;
            parentIndex = (loc-1)/2;
        }
        return new int[]{this.getNumComparisons(), this.getNumSwaps()};
	}
    /* Q4
     * Rewrite the delete method so that it will
     * return an array containing the number of Comparisons, number of Swaps
     * performed to complete the deletion of item from the Heap
     */

	public int[] delete(){
        int i = 0;
        this.resetAllCounters();
        if(!isEmpty()){
            int loc = items.size()-1;//calculate index of last item
            items.set(0, items.get(loc)); //place item from last index into the root at index 0
            items.remove(loc);//remove the last value from the items arraylist
            heapRebuild(0);
        }
        return new int[]{this.getNumComparisons(), this.getNumSwaps()};
	}
	/* Q5
	 * Complete the method getThreeLargest() so that it retrieves and
	 * returns an array of type T containing the 3 largest values in the array.
	Note: When the method is complete, the Heap should have the same content as before.
	 */

    @SuppressWarnings("unchecked")
	public T[] getThreeLargest(){
	    Object[] temp = items.toArray();
        Arrays.sort(temp); // Sorting in ascending order
        return (T[]) new Object[]{temp[items.size()-1], temp[items.size()-2], temp[items.size()-3]};
	}

	private void printf(@NotNull String str, Object... arg){
        System.out.printf(str, arg);
	}
}