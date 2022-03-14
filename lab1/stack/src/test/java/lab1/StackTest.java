package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

class StackTest {
    private static Stack<String> newStack;
    private static Stack<String> emptyStack;

    @BeforeEach
    public void newStack(){
        newStack = new Stack<>();
        emptyStack = new Stack<>();

        newStack.push("Futebol");
        newStack.push("Basquetebol");
        newStack.push("Andebol");
        newStack.push("Futsal");
    }

    @AfterEach
    public void clearStack(){
        newStack.clear();
    }

    @Test
    @DisplayName("A stack is empty on construction.")
    public void testIsEmpty(){
        assertTrue(emptyStack.isEmpty(), "Stack must be empty on construction!");
    }

    @Test
    @DisplayName("A stack has size 0 on construction.")
    public void testSizeAtConstruction(){
        assertTrue(emptyStack.size() == 0, "Stack must have size 0 on construction!");
    }

    @Test
    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    public void nPushesnSize(){
        assertEquals(4, newStack.size(), "The size is not the expected one!");
    }

    @Test
    @DisplayName("If one pushes x then pops, the value popped is x.")
    public void pushXpopX(){
        newStack.push("Voleibol");
        assertEquals("Voleibol", newStack.pop(), "The popped value is incorrect!");
    }

    @Test
    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    public void pushThenPeek() {
        newStack.push("Hoquei");
        int stackSize = newStack.size();
        assertEquals("Hoquei", newStack.peek(), "The peeked value is incorrect!");
        assertEquals(stackSize, newStack.size(), "The size is not the same after peeking!");
    }

    @Test
    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    public void emptyAfterPops() {
        popsAll(newStack, newStack.size());
        assertTrue(newStack.isEmpty(), "Stack should be empty, but it isn't!");
    }

    @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    public void popFromEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            emptyStack.pop();
        });
    }

    @Test
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    public void peekIntoEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            emptyStack.peek();
        });
    }

    @Test
    @DisplayName("For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
    public void pushFullStack() {
        newStack = new Stack<>(2);

        newStack.push("Futebol");
        newStack.push("Basquetebol");

        assertThrows(IllegalStateException.class, () -> {
            newStack.push("Triplo Salto");
        });
    }
    private void popsAll(Stack<String> stack, int n) {
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
    }

}

