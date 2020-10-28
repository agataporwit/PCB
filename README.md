# PCB
Two Versions of Process Creation Hierarchy

Compare the performance of process creation and destruction when implemented with and without linked lists.

Description

Version 1 of the process creation hierarchy uses linked lists to keep track of child processes as described in section "The process control block", subsection "The PCB data structure".

For the purposes of performance evaluation, the PCBs are simplified as follows:

    All PCBs are  contained in an array of size n.
    Each process is referred to by the PCB index, 0 through n-1.
    Each PCB is a structure consisting of only the two fields:
        parent: a PCB index corresponding to the process's creator
        children: a pointer to a linked list, where each list element contains the PCB index of one child process

The necessary functions are simplified as follows:

    create(p) represents the create function executed by process PCB[p]. The function creates a new child process PCB[q] of process PCB[p] by performing the following tasks:
        allocate a free PCB[q]
        record the parent's index, p, in PCB[q]
        initialize the list of children of PCB[q] as empty
        create a new link containing the child's index q and appends the link to the linked list of PCB[p]
    destroy(p) represents the destroy function executed by process PCB[p]. The function recursively destroys all descendent processes (child, grandchild, etc.) of process PCB[p] by performing the following tasks:
        for each element q on the linked list of children of PCB[p]
            destroy(q) /* recursively destroy all progenies */
            free PCB[q]
            deallocate the element q from the linked list

Version 2 of the same process creation hierarchy uses no linked lists. Instead, each PCB contains the 4 integer fields parent, first_child, younger_sibling, and older_sibling, as described in the subsection "Avoiding linked lists".
