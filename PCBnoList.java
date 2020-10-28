package com.agataporwit;
/**
 * Assignment 1 CSD 415 Tom Abbott
 * Process Creation Hierarchy
 * @Agata Porwit(Jelen)
 * Class for version two of the assignment no linked list used
 * PCB contains the 4 integer fields parent, first_child, younger_sibling, and older_sibling
 * */
public class PCBnoList {
    private int parent;
    private int first_child = -1;
    private int younger_sibling = -1;
    private int older_sibling = -1;

    public PCBnoList(int p) {
        parent = p;
    }
    public int getParent() {
        return parent;
    }

    public int getFirstChild() {
        return first_child;
    }

    public int getOlderSibling() {

        return older_sibling;
    }

    public int getYoungerSibling() {

        return younger_sibling;
    }

    public void setFirstChild(int first) {
        first_child = first;
    }

    public void setYoungerSibling(int younger) {
        younger_sibling = younger;
    }

    public void setOlderSibling(int older) {

        older_sibling = older;
    }
}
