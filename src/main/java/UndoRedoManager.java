
/**
 * Implement an application that support undo/redo functionality. Use a linked list to maintain a sequence of states
 * Each state change is stored as a node in the list, allowing for the easy navigation.
 * 1<>2<>3<>4<>5
 */


public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node next;
        private Node previous;

        private Node (T state) {
            this.state = state;
        }
    }

    private Node currentState;

    //Undo Operation
    public T Undo(){
        if (currentState == null) {
            System.out.println("No state to undo");
            return null;
        }
        Node previousState = currentState.previous;
        if (previousState == null) {
            System.out.println("Reached the initial start state");
        } else {
            currentState = previousState;
        }
        return currentState.state;
    }

    //Perform an operation
    public void addState(T newState) {
        // Lets create a new for the new task
        Node newNode = new Node(newState);

        //Setting the link for the new node
        newNode.previous = currentState;
        newNode.next = null;

        //Updating the next link for the current state
        if (currentState != null) {
            currentState.next = newNode;
        }
        //updating the current to the new state
        currentState = newNode;

    }

    public void Redo() {
        if (currentState == null) {
            System.out.println("No state to redo");
            return;
        }
        Node nextState = currentState.next;
        if (nextState == null) {
            System.out.println("Reached the initial start state");
        } else {
            currentState = nextState;
        }
        // ASSIGNMENT: Implement the Redo Method.
    }

    public static void main(String[] args) {
        UndoRedoManager undoRedoManager = new UndoRedoManager();
        undoRedoManager.addState("Wake up from bed");
        undoRedoManager.addState("Brush Teeth");
        undoRedoManager.addState("Take a Shower");
        undoRedoManager.addState("Go to Class");

        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.Undo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.Undo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.Undo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.Undo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);


        undoRedoManager.Redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.Redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.Redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
    }

}
