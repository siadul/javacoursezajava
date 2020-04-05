package zajecia6;

// dziedzieczenie
// class NAZWA_KLASY_POCHODNEJ extends NAZWA_KLASY_BAZOWEJ { }
//

public class Painter {
//    public void paint(Circle circle) {
//        System.out.println("Painting " + circle.getName());
//    }
//
//    public void paint(Rectangle rectangle) {
//        System.out.println("Painting " + rectangle.getName());
//    }
//
//    public void paint(Triangle triangle) {
//        System.out.println("Painting " + triangle.getName());
//    }
    // Dzięki dziedziczeniu nie musze pi

    public void paint(Shape shape) {
        System.out.println("Painting " + shape.getName());
    }
}

class Figure {}

class Shape {
//    private String name = "circle"; // UWAGA! prywatnych pól (ani metod) nie dziedziczymy
    protected String name = null;
    // Jeżeli chcę mieć dostęp do pola wyłącznie w klasie definiującej to pole, bądź
    // w klasach pochodnych to używam modyfikatora dostępu protected

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// class Circle extends Shape, Figure {
// Powyższa linia się nie skompiluje, klasa nie może dziedziczyć po więcej niż jednej klasie
// (nie licząc klasy Object, po której wszystkie klasy dziedzią niejawnie)
// na tym samym poziomie hierarchi.
// Jest natomiast możliwe dziedziczenie wielopoziomowe Circle extends Shape; Shape extends Figure

class Circle extends Shape {
    Circle() {
        name = "circle";
    }
}

class Rectangle extends Shape {
    Rectangle() {
        name = "rectangle";
    }
}

class Triangle extends Shape {
    Triangle() {
        name = "triangle";
    }
}

class Star extends Shape {
    Star() {
        name = "star";
    }
}