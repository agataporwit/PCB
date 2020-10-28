package com.agataporwit;
/**
 * Assignment 1 CSD 415 Tom Abbott
 *  * Process Creation Hierarchy
 *  * @Agata Porwit(Jelen)
 process creation hierarchy uses linked lists
 This class contains code for version 1 and 2 of the assignment.
 create(p) represents the create function executed by process PCB[p].
 The function creates a new child process PCB[q] of process PCB[p] by performing the following tasks:
 *  */
import java.util.LinkedList;
import java.util.ListIterator;

public class Process{
    static PCB[] indexing1;
    static PCBnoList[] indexing2;

    public static void pcb1(int size) {
        indexing1 =  new PCB[size];
        indexing1[0] = new PCB(-1);
    }

    public static void create1(int index) {
        int assignedIndex = findSpot(true);
        indexing1[assignedIndex] = new PCB(index);
        indexing1[index].addChild(assignedIndex);
    }
/**
 * for each element q on the linked list of children of PCB[p]
 * */
    public static void destroy1(int index) {
        destroyAll1(index);
        indexing1[index].newChildren();
    }

//found very similar option in one of our old assignments for linked lists woot woot
    private static void destroyAll1(int index) {
        LinkedList<Integer> children = indexing1[index].getChildren();
        ListIterator<Integer> iterator = children.listIterator();
        // set the child index position to null
        while(iterator.hasNext()) {
            int childIndex = iterator.next();
            destroy1(childIndex);
            indexing1[childIndex] = null;
        }
    }

    // looking for an available space in the array
    public static int findSpot(boolean version) {
        if (version) {
            for (int i = 0; i < indexing1.length; i++)
                if (indexing1[i] == null)
                    return i;
        } else {
            for (int i = 0; i < indexing2.length; i++) {
                if (indexing2[i] == null)
                    return i;
            }
        }
        return -1;

    }

    public static void printProcess1() {
        for (int i = 0; i < indexing1.length; i++) {
            if (indexing1[i] != null) {
                System.out.println(i + " Process: Parent: " + indexing1[i].aParent() + "  " + indexing1[i].getChildren().toString());
            } else {
                System.out.println(i + " Empty");
            }
        }
    }

//version two no linked list calls PCBnoList

    public static void pcb2(int size) {
        indexing2 = new PCBnoList[size];
        indexing2[0] = new PCBnoList(-1);
    }
//
    public static void create2(int index) {
        int newIndex = findSpot(false);
        indexing2[newIndex] = new PCBnoList(index);
        int f1 = indexing2[index].getFirstChild();
       //first child
        if (f1 == -1)
            indexing2[index].setFirstChild(newIndex);
            // old child new child relation if this is the recently new added child
        else {
            int nextSib = f1;
            boolean lastChild = false;
            while(!lastChild) {
                int ys = indexing2[nextSib].getYoungerSibling();
                if(ys == -1) {
                    indexing2[newIndex].setOlderSibling(nextSib);
                    indexing2[nextSib].setYoungerSibling(newIndex);
                    lastChild = true;
                    // go to the next sibling
                } else {
                    nextSib = indexing2[nextSib].getYoungerSibling();
                }
            }

        }

    }

    public static void destroy2(int index) {
        PCBnoList p = indexing2[index];
        // no children
        if (p.getFirstChild() == -1)
            return;
        destroyAll2(p.getFirstChild());
    }

    private static void destroyAll2(int index) {
        PCBnoList p = indexing2[index];
        int fc = p.getFirstChild();
        int ys = p.getYoungerSibling();
        //destroy all children and siblings
        if (fc != -1)
            destroyAll2(fc);
        if (ys != -1)
            destroyAll2(ys);
        indexing2[index] = null;
    }

    public static void printProcess2() {
        for (int i = 0; i < indexing2.length; i++) {
            if (indexing2[i] != null) {
                System.out.println(i + " Process : Parent: " + indexing2[i].getParent() + " First: " + indexing2[i].getFirstChild() + " Older: " +
                        indexing2[i].getOlderSibling() + " Younger: " + indexing2[i].getYoungerSibling());
            } else {
                System.out.println(i + " Empty");
            }
        }
    }
}
