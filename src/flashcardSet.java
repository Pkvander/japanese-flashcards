import java.util.ArrayList;
import java.util.List;

public class flashcardSet <V, P extends Comparable<P>> implements BinaryHeap<V, P>{

    private List<Prioritized<V,P>> _flashcardsHeap;

    public flashcardSet(){
        _flashcardsHeap = new ArrayList<>();
    }

    public Prioritized<V, P>[] getAsArray(){ //Prints current flashcards in order of priority

    };

    public int size(){
        return _flashcardsHeap.size();
    }

    public V getMax(){ //Finds next flashcard
        if (_flashcardsHeap.isEmpty()){
            return null;
        }else{
            return _flashcardsHeap.get(0).getValue();
        }
    };

    public void enqueue(V value, P priority){ //makes new flashcard
        Flashcard<V,P> newFlashcard = new Flashcard(value, priority);
        _flashcardsHeap.add(newFlashcard);
        int i = _flashcardsHeap.size() -1; //Set index to last flashcard in heap
        while (i>0 && ((Comparable) _flashcardsHeap.get(i).getPriority()).compareTo(_flashcardsHeap.get((i-1)/2).getPriority())>0){ //While the current is larger than its parent
            Prioritized<V,P> temp = _flashcardsHeap.get(i);
            _flashcardsHeap.set(i,_flashcardsHeap.get((i-1)/2)); //Set current to parent
            _flashcardsHeap.set(((i-1)/2), temp); //Set former parent to current
            i = (i-1)/2; //Switch index to current's new spot
        }
    }

    public V dequeue(int confidence){ //Instead of removing from the heap we adjust priority and put it back into the heap
        if (_flashcardsHeap.isEmpty()){
            return null;
        }
        Flashcard<V,P> currentFlashcard = (Flashcard)_flashcardsHeap.get(0);
        if (confidence == 0){
            (_flashcardsHeap.get(0)).setPriority(5);
        }
    }

    public void adjustFlashcardPriority(int confidence, Flashcard currentFlashcard){
        if (confidence == 0){
            currentFlashcard.setPriority(0);
        }
    }

}
