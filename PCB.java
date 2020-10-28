package com.agataporwit;

import java.util.LinkedList;
/**
 * Assignment 1 CSD 415 Tom Abbott
 *  * Process Creation Hierarchy
 *  * @Agata Porwit(Jelen)
  process creation hierarchy uses linked lists
 *  */
public class PCB
{
    private int parent;
    private LinkedList<Integer> children;

    public PCB(int p) {
        parent = p;
        children = new LinkedList<Integer>();
    }
    public int aParent() {

        return parent;
    }
    public LinkedList<Integer> getChildren() {

        return children;
    }
    public void newChildren() {

        children = new LinkedList<Integer>();
    }
    public void addChild(int i) {

        children.add(i);
    }
}