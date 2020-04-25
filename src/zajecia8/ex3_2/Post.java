package zajecia8.ex3_2;

public class Post {
    public boolean sendLetter(Sender sender, Letter letter) {
        System.out.println("Name: " + sender.name); // package
        System.out.println("Surname: " + sender.surname); // package
        System.out.println("Address: " + sender.address); // package
//        System.out.println(letter.content); // private
        System.out.println("Stamp: " + letter.stamp); // public
        System.out.println("Sent letter");

        return true;
    }
}
