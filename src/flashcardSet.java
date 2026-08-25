import java.util.ArrayList;
import java.util.List;

public class flashcardSet {

    private List<Flashcard> _flashcardsHeap;

    public flashcardSet(){
        _flashcardsHeap = new ArrayList<>();
    }

    public Flashcard[] getAsArray(){ //Prints current flashcards in order of priority

    };

    public int size(){
        return _flashcardsHeap.size();
    }

    public String getMax(){ //Finds next flashcard
        if (_flashcardsHeap.isEmpty()){
            return null;
        }else{
            return _flashcardsHeap.get(0).getValue();
        }
    };

    public void enqueue(String value, int priority){ //makes new flashcard
        Flashcard newFlashcard = new Flashcard(value, priority);
        _flashcardsHeap.add(newFlashcard);
        int i = _flashcardsHeap.size() -1; //Set index to last flashcard in heap
        while (i>0 && (_flashcardsHeap.get(i).getPriority()) > (_flashcardsHeap.get((i-1)/2).getPriority())){ //While the current is larger than its parent
            Flashcard temp = _flashcardsHeap.get(i);
            _flashcardsHeap.set(i,_flashcardsHeap.get((i-1)/2)); //Set current to parent
            _flashcardsHeap.set(((i-1)/2), temp); //Set former parent to current
            i = (i-1)/2; //Switch index to current's new spot
        }
    }

    public String dequeue(int confidence){ //Instead of removing from the heap we adjust priority and put it back into the heap
        if (_flashcardsHeap.isEmpty()){
            return null;
        }

        Flashcard currentFlashcard = _flashcardsHeap.getFirst();

        if (confidence == 0){
            (currentFlashcard).setPriority(100);
            enqueue(currentFlashcard.getValue(), currentFlashcard.getPriority());
        }
        return "hi";
    }

    public void adjustFlashcardPriority(int confidence, Flashcard currentFlashcard){
        if (confidence == 0){
            currentFlashcard.setPriority(0);
        }
    }

}
