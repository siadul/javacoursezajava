package zajecia4.student;

public class Student {
    private String name; // słowo private oznacza, że pole jest widoczne wyłącznie
                         // w klasie, która je posiada (czyli Student w tym przypadku)
    private String surname;
    private int birthdate; // rok urodzenia

    public void setName(String name) {
        // name = name; // argument name zasłania pole name
        this.name = name; // muszę użyć this, aby określić, że w pierwszym przypadku
                          // chodzi mi o pole name
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthdate() {
        return birthdate;
    }

    // Zadanie
    // a) dodać pola 'name', 'surname', 'birthdate' - wystarczy rok urodzenia
    // b) dodać metody setName, setSurname i setBirthdate, które ustawiają
    //    pola z pkt1
    // c) dodać metody getName, getSurname i getBirthdate, które zwracają wartości
    //    pól z pkt1
    // d) stworzyć 2 studentów (2 obiekty klasy Student) i wywołać metody z pkt b) i c)

    // metody setSOMETHING to tzw. settery
    // metody getSOMETHING to tzw. gettery
    // łącznie metody getSOMETHING i setSOMETHING to tzw. akcesory
}
