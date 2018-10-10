package StacksAndQueues;

import java.util.LinkedList;

public class AnimalShelterQueue {
    static long count = 0;

    public static class Animal {
        String name;
        long arrivalTime;
    }

    public static class Dog extends Animal {
        public Dog(String name) {
            this.name = name;
        }
    }

    public static class Cat extends Animal {
        public Cat(String name) {
            this.name = name;
        }
    }

    private LinkedList<Dog> dogQueue = new LinkedList<>();
    private LinkedList<Cat> catQueue = new LinkedList<>();

    public void enque(Animal animal) {

        animal.arrivalTime = count++;

        if (animal instanceof Dog) {
            dogQueue.add((Dog) animal);
        }
        else {
            catQueue.add((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogQueue.getFirst().arrivalTime < catQueue.getFirst().arrivalTime) {
            return dogQueue.pop();
        }

        return catQueue.pop();
    }

    public Dog dequeueDog() {
        return dogQueue.pop();
    }

    public Cat dequeuCat() {
        return catQueue.pop();
    }

    public static void main(String[] args) {
        AnimalShelterQueue queue = new AnimalShelterQueue();

        queue.enque(new Dog("A"));
        queue.enque(new Cat("1"));
        queue.enque(new Dog("B"));
        queue.enque(new Dog("C"));
        queue.enque(new Cat("2"));

        System.out.println(queue.dequeuCat().name);
        System.out.println(queue.dequeueDog().name);
        System.out.println(queue.dequeueAny().name);

    }


}
