# Ants
Topics : Inheritance, Java Collections Framework, Abstract Classes

## Activity Description 

Give the group a simple UML diagram and explain the basic idea of the program. Queen ants create various ants of different types which I want to store in a variety of different collections. 

First, ask them what collection I should use if I just wanted to store all my ants in the order they’ve been created. Any kind of list is a good example. Next ask them to, based on the code in AntFarm.java, write how I should instantiate that list, and add the new ant to it. 

Next, tell them that ants have a natural order based on their name, followed by their size. Ask the group how I would define a natural order in the Ant class. What do I need to change about the Ant class, and what method do I need to implement? After that, ask them to write a compareTo method for Ant that sorts ants first by name and then by size. 

Next, ask the group what I should do if I wanted to store the ants in a sorted order. One answer is that I could use the .sort() method on the already existing collection of ants, another would be a collection that stores things in a sorted order such as a TreeSet. 

Next tell the group that I also want to maintain a collection which lets me keep track of the ants so that I always know which ant is the biggest. Ask them what I would do to both sort the ants in a different order, and what collection I would use. Then have them write out all those components on the board. 
