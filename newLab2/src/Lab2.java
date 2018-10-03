import java.util.*;
import java.io.*;

// Lab 2: Insertion sorting a linked list.

public class Lab2 {

    // Constants to control the testing of the sorting
    private static final int NUM_TRIALS = 10; // How many random lists to sort.
    private static final int LIST_SIZE = 100; // How many random items in each list to be sorted.
    private static final int ITEM_MAX = LIST_SIZE * 100; // Max size of a random item
    private static Random generator = new Random(); // For efficiency: create a random number
    // generator once and use it as needed.

    public static void main( String[] args ) {
        System.out.println( "\n\nCOMP 2140 Fall 2018 Lab 2 Solution"
                + "\nInsertion sorting a linked list\n" );

        testLinkedListSorting();

        System.out.println( "\nLab 2 program ends normally\n" );
    } // end main

    // testLinkedListSorting
    //
    // Purpose: To make sure that the sort() method in the LinkedList class works.
    //           Create NUM_TRIALS linked lists containing LIST_SIZE items,
    //           sorts them and verifies that they are sorted.
    //           It prints a line for each trial, reporting on success or failure.
    private static void testLinkedListSorting() {
        LinkedList myList;

        System.out.println( NUM_TRIALS + " trials of insertion sorting"
                + " a linked list containing " + LIST_SIZE
                + " random items.\n" );
        for ( int i = 0; i < NUM_TRIALS; i++ ) {
            myList = createRandomList( LIST_SIZE, ITEM_MAX );
            myList.insertionSort();
            System.out.print( "Trial " + i + ": List was " );
            if ( myList.isSorted() )
                System.out.println( "correctly sorted." );
            else
                System.out.println( "not correctly sorted. *** ERROR ***" );
        } // end for

    } // end testLinkedListSorting

    // createRandomList
    //
    // Purpose: Return a linked list containing listSize random item, each item
    //          no larger than maxItemValue.
    private static LinkedList createRandomList( int listSize, int maxItemValue ) {
        LinkedList list = new LinkedList(); // start with an empty list

        // Insert listSize random items into the list
        for ( int i = 0; i < listSize; i++ ) {
            list.insert( generator.nextInt( maxItemValue ) );
        } // end for

        return list;
    } // end createRandomList

} // end class Lab2Solution


// ***********************************************************************************


//
// LinkedList class: A linked list with a pointer (top) to the first node in the list.
//                   Each node contains an int and a pointer to the next node in the list.
class LinkedList {

    private Node top; // Points to the first node in the list, or null (if the list is empty).

    public LinkedList() { // constructor creates an empty list
        top = null;
    }

    // insert:
    //
    // Purpose: Insert the new value (insertVal) into the list.
    //          (We are not worrying about keeping the list in order,
    //          so we're just inserting at front.)
    public void insert( int insertVal ) {
        top = new Node( insertVal, top );
    }

    // insertionSort:
    //
    // Purpose: Perform an insertion sort on the calling LinkedList
    //          to put it into ascending order.
    public void insertionSort() {












        // ****** YOUR CODE GOES HERE ******
        // ****** (you can add private helper methods, too) *******

    } // end insertionSort

    // isSorted:
    //
    // Purpose: To verify that the linked list is in ascending order.
    //          Returns true if it is sorted, false if it isn't.
    public boolean isSorted() {

        boolean sorted = true;
        Node curr = top;
        int prevValue = top.getItem();

        while(curr.getNext() != null && sorted)
        {
            if(curr.getItem()<=prevValue)
            {
                sorted = false;
            }
            else
            {
                prevValue = curr.getItem();
                curr = curr.getNext();
            }
        }

    } // end isSorted



    //BONUS CODE
    public boolean recIsSorted()
    {
        return recIsSorted(top);
    }

    public boolean recIsSorted(Node curr)
    {
        if(curr.getItem()>((curr.getNext()).getItem()))
            return false;
        else if (curr.getNext()==null)
            return true;
        else
            return recIsSorted(curr.getNext());
    }
} // end class LinkedList



// ***********************************************************************************



// A very boring linked list node, containing one int and a pointer to the next node.
class Node {

    private int item;
    private Node next;

    public Node( int i, Node n ) {
        item = i;
        next = n;
    }

    public int getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public void setItem( int i ) {
        item = i;
    }

    public void setNext( Node n ) {
        next = n;
    }
} // end class Node
