package zajecia6;

public class Zajecia6 {
    public static void main(String[] args) {
//        inheritance();
//        Access.access();
//        InheritanceConstructors.main(args);
//        Motorcycle.main(args);
//        Abstracts.main(args);
//        Finals.main(args);
//        Interfaces.main(args);
        Creatures.main(args);
    }

    private static void inheritance() {
        Painter painter = new Painter();

        Shape shape = new Shape(); // Painting null
        // źle to wygląda, lepiej by było zabronić tworzenia obiektów
        // klasy bazowej Shape

        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Star star = new Star();

        painter.paint(shape);
        painter.paint(circle);
        painter.paint(rectangle);
        painter.paint(triangle);
        painter.paint(star);
    }
}


