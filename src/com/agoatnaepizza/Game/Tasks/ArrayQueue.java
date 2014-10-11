package com.agoatnaepizza.Game.Tasks;

import java.util.*;
import java.io.*;

public class ArrayQueue<E> {

    public static final int CAPACITY = 10;  // default queue capacity
    private Object[] Q;                     // Generic array used to implement the queue  
    private int n;                          // actual capacity of queue
    private int front;                      // index for the top of queue
    private int rear;                       // rear of the queue
    private int size;                       // size of the queue
    
	
    public ArrayQueue(){this(CAPACITY);}

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){
	n = capacity;
	Q = (E[]) new Object [n]; 
	front = rear = size = 0;
    }
	
    public int size(){return this.size;}

	 
    public boolean isEmpty(){return this.size==0;}


    public E front() throws ArrayQueueException {return (E) Q[front];}

	/*
	 * enqueue method that throws exception if trying to enqueue element when the queue is full 
	 */
    public void enqueue(E element) throws ArrayQueueException {
    	if(this.size==n) throw new ArrayQueueException();
    	// the rear element points to "element"
    	Q[rear]=element;
    	rear=(rear + 1)%n;
    	size++; 	
    }
    /*
     * dequeue method that throws exception if trying to dequeue element when the queue is empty
     */
    public E dequeue() throws ArrayQueueException {
    	E o;
    	if(isEmpty()) throw new ArrayQueueException();
    	o=(E) Q[front];
    	// changing the index of the front element by incrementing front modulo n
    	front=(front + 1)%n;
    	size--;
    	return o;}
    /*
     * toString method that is going through the queue staring from the front element
     * size times and creating a string 
     */
    public String toString(){
    	int starter=this.front;
    	String s="[";
    	for(int i=0;i<this.size;i++){
    		s=s+Q[starter];
    		// if this is not the end add comma to the string
    		if(i!=this.size-1) s+=",";
    		// incrementing starter modulo n
    		starter = (starter + 1) % n;
    	}
    	s+="]";
    	return s;
    }

}