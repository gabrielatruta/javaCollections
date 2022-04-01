package com.company;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    
    static Integer addPrice (Integer benefit1, Integer benefit2) {
        return ((benefit1!= null ? benefit1: 0) + (benefit2 != null ? benefit2:0));
    }

    public static void main(String[] args) {

        /*
        - maps a key to value
        - duplicate keys aren't allowed, but duplicate values are
        - doesn't maintain an order
        - allows null values and a null key
        
        ??? ce se intampla in caz ca la map nu e o valoare wrapper ci un object
        > uses equals: override la equals pt a obtine un raspuns valid
        > replace methods + obiecte complexe: nu doar pe string, ci pe obiecte
         */
        HashMap<Integer, String> postalCodes = new HashMap<>();
        
        /*
        Add items to the HashMap
         */
        postalCodes.put(450084, "Zalau, Aleea Kiss Karoly, nr. 2");
        postalCodes.put(400001, "Cluj-Napoca, Str. Calea Motilor nr. 1-39; 2-40;");
        postalCodes.put(400363, "Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80");
        postalCodes.putIfAbsent(409762, "agaga");
    
        /**
         *
         */
        HashMap<Integer, PostalCode> objectPostalCode = new HashMap<>();
        objectPostalCode.putIfAbsent(1, new PostalCode(450084, "Zalau, Aleea Kiss Karoly, nr. 2"));
        objectPostalCode.putIfAbsent(2, new PostalCode(400001, "Cluj-Napoca, Str. Calea Motilor nr. 1-39; 2-40;"));
        objectPostalCode.putIfAbsent(3, new PostalCode(400363, "Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80"));
        
        for(Map.Entry<Integer, PostalCode> postalCodeEntry: objectPostalCode.entrySet())
            System.out.println("No. " + postalCodeEntry.getKey() + ": " + postalCodeEntry.getValue());
    
        System.out.println("\n");
    
        for (PostalCode postalCode: objectPostalCode.values())
            System.out.println(postalCode);
        System.out.println("\n");
    
        if (objectPostalCode.containsValue(new PostalCode(567812, "Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80")))
            System.out.println("\nThe street Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80 exists in the HashMap");
        else
            System.out.println("\nThe street Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80 doesn't exist in the HashMap");
    
        objectPostalCode.remove(1);
        objectPostalCode.remove(2, new PostalCode(400001, "Cluj-Napoca, Str. Calea Motilor nr. 1-39; 2-40;"));
    
        /**
         *
         */
        
        /*
        Access an item from HashMap while iterating through it
         */
        System.out.println("EX1:\n");
        for (Map.Entry<Integer, String> set: postalCodes.entrySet())
            System.out.println("Street with the postal code " + set.getKey() + " is: " + set.getValue());
        System.out.println("\n");

        System.out.println("EX2:\n All the streets from the HashMaps:\n" );
        for(String streets: postalCodes.values())
            System.out.println(streets);
        System.out.println("\n");

        /*
        Checking if the map contains a certain band
         */
        if (postalCodes.containsValue("Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80"))
            System.out.println("\nThe street Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80 exists in the HashMap");
        else
            System.out.println("\nThe street Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80 doesn't exist in the HashMap");

        /*
        Size of the hashmap
         */
        System.out.println("\nThe number of entries from the Hashmap: " + postalCodes.size());

        /*
        Removing an item from HashMap
         */
        postalCodes.remove(450084);
        System.out.println("\nThe number of entries from the Hashmap after removing an entry: " + postalCodes.size());
        
        /*
        Removing all the items from the HashMap
         */
        postalCodes.clear();
        System.out.println("\nThe number of entries from the Hashmap after removing everything: " + postalCodes.size());
        System.out.println("--------------------------------------------------------------------------------------------");

        /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        /*
        - doesn't allow duplicate values
        - has a single null value
        - doesn't guarantee the order of the elements
        
        > cand faci remove, iterator sau ce folosesti sa nu ai exceptii, safe way
        >
         */
        HashSet<String> bands = new HashSet<>();
        HashSet<Band> bandList = new HashSet<>();

        /*
        Add items to HashSet
         */
        bands.add("Led Zeppelin");
        bands.add("Rolling Stones");
        bands.add("Red Hot Chili Peppers");
        bands.add("Cage the Elephant");
        
        bandList.add(new Band("Led Zeppelin", "rock", "England", 4));
        bandList.add(new Band("Rolling Stones", "rock", "England", 4));
        bandList.add(new Band("Red Hot Chili Peppers", "rock", "America", 4));
        bandList.add(new Band("Cage the Elephant", "rock", "America", 6));
    
        bandList.removeIf(band -> band.equals(new Band("Rolling Stones", "rock", "England", 43)));
    
        Iterator<Band> iteratorBands = bandList.iterator();
        while(iteratorBands.hasNext())
            if(iteratorBands.next().equals(new Band("Rolling Stones", "rock", "England", 4)))
                iteratorBands.remove();

        /*
        Accessing the items from the HashSet while iterating through it
         */
        for (String band: bands)
            System.out.println(band);

        /*
        Checking if the set contains a certain band
         */
        if (bands.contains("Grouplove"))
            System.out.println("\nThe band Grouplove exists in the HashSet");
        else
            System.out.println("\nThe band Grouplove doesn't exist in the HashSet");

        /*
        Size of the HashSet
         */
        System.out.println("\nThere are " + bands.size() + " bands in the set");

        /*
        Remove an entry
         */
        bands.remove("Cage the Elephant");
        System.out.println("\nThere are " + bands.size() + " bands in the set after removing Cage The Elephant");
        if(bandList.remove(new Band("Rolling Stones", "rock", "England", 414)))
            System.out.println("The entry was successfully removed!");
        else
            System.out.println("The entry doesn't exist!");
        
        /*
        Remove all entries
         */
        bands.clear();
        System.out.println("\nThere are " + bands.size() + " bands in the set");
        System.out.println("--------------------------------------------------------------------------------------------");

         /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        /*
        - same as HashMap but the TreeMap maintains an order of the objects
        
        > treeset de tip object, cheia care defineste sortarea: age
        > compareTo metoda cu exemplu
         */
        TreeSet<String> names = new TreeSet<>();
        TreeSet<Person> persons = new TreeSet<>(new PersonComparator());

        /*
        Add items to the TreeSet
         */
        names.add("Gabriela");
        names.add("Elena");
        names.add("Aniko");
        names.add("Valentina");
        
        persons.add(new Person("Gabriela", 23));
        persons.add(new Person("Elena", 16));
        persons.add(new Person("Valentina", 21));
        persons.add(new Person("Cora", 23));
    
        System.out.println(persons);
        
        /*
        Accessing the items while iterating through the TreeSet
         */

        /*
        Accessing the items while iterating in descending order
         */
        Iterator<String> iterator = names.descendingIterator();
        System.out.println("Descending order of the TreeSet: ");
        while(iterator.hasNext())
            System.out.println(iterator.next());

        /*
        Check if a name is in the TreeSet
         */
        if (names.contains("Alexandru"))
            System.out.println("\nAlexandru is in the TreeSet");
        else
            System.out.println("\nAleandru isn't in the TreeSet");

        /*
        Size of the TreeSet
         */
        System.out.println("\nSize of the TreeSet is: " + names.size());

        /*
        Removing an entry
         */
        names.remove("Gabriela");
        System.out.println("\nSize after removing Gabriela from the TreeSet: " + names.size());

        /*
        Accessing the first entry
         */
        System.out.println("\nFirst entry from the TreeSet is: " + names.first());

        /*
        Accessing the last entry
         */
        System.out.println("\nLast entry from the TreeSet is: " + names.last());

        /*
        Removing all entries
         */
        names.clear();
        System.out.println("\nSize after removing every entry: " + names.size());
        System.out.println("--------------------------------------------------------------------------------------------");

         /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        /*
        - elements are not stored in a contiguous locations and every element is a separate object with a data part and address part
        - elements are linked using pointers and addresses
        - each element is known as a node
        - nodes cannot be accessed directly and we need to start from the head
        
        > exemplu cu obiect mai complex
        > get, lastIndexOf, removeFirst, removeLast, addAll, peek si poll
        > safe removal
         */
        LinkedList<String> animals = new LinkedList<>();
        LinkedList<Person> personLinkedList = new LinkedList<>();

        /*
        Adding elements
         */
        animals.add("cat");
        animals.add("dog");
        //add as the first
        animals.addFirst("zebra");
        //add as the last
        animals.addLast("antilope");
        
        personLinkedList.add(new Person("Elena", 16));
        personLinkedList.add(new Person("Valentina", 21));
        personLinkedList.add(new Person("Gabriela", 23));
        personLinkedList.add(new Person("Cora", 23));
        personLinkedList.add(new Person("Gabriel", 16));
    
        System.out.println("The person with the 3rd index: " + personLinkedList.get(2));
        System.out.println("Elena appears at the position: " + personLinkedList.lastIndexOf(new Person("Elena", 16)));
        System.out.println("First element: " + personLinkedList.removeFirst());
        System.out.println("Last element: " + personLinkedList.removeLast());
        
        List<Person> collectionOfPersons = new ArrayList<>();
        collectionOfPersons.add(new Person("Roxana", 22));
        collectionOfPersons.add(new Person("Annen", 29));
        
        personLinkedList.addAll(collectionOfPersons);
        personLinkedList.addAll(1, collectionOfPersons);
        
        System.out.println("The head of the list: " + personLinkedList.peek());
        System.out.println("The head of the list before removing it: " + personLinkedList.poll());

        /*
        Iterating and accessing elements
         */
        System.out.println("EX1:\n");
        for ( int i=0; i < animals.size(); i++)
            System.out.println(animals.get(i));

        System.out.println("EX2:\n");
        for (String animal: animals)
            System.out.println(animal);

        /*
        Changing the list
         */
        System.out.println("\nThe list after changing it: \n");
        animals.add(1, "bat");
        for (String animal: animals)
            System.out.println(animal);

        /*
        Removing an item
         */
        animals.remove("antilope");
        animals.remove(1);
        System.out.println("\nThe list after removing elements: \n");
        for (String animal: animals)
            System.out.println(animal);
        System.out.println("--------------------------------------------------------------------------------------------");
        /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        /*
        STREAMS
         */
        List<Integer> randomNumbers = Arrays.asList(1, 2, 10, 98, 67, 44, 12);

        /*
        MAP + COLLECT
         */
        List<Integer> squareNumbers = randomNumbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println("Square Numbers: " + squareNumbers);

        /*
        FILTER
        > cum trebuie sa definesc un predicat, cum fac linking intre ele: persoana are sub 18 ani si numele incepe cu litera A
        > predicate declarate separat
         */
        Predicate<Person> nameStartsWithG = x -> x.getName().startsWith("G");
        Predicate<Person> ageOver21 = x -> x.getAge() > 21;
        Predicate<Person> predicateCombined = nameStartsWithG.and(ageOver21);
        List<Person> allPersons = personLinkedList.stream()
                        .filter(predicateCombined).collect(Collectors.toList());
        System.out.println(allPersons);
        
        List<Predicate<Person>> allPredicates = new ArrayList<>();
        allPredicates.add(nameStartsWithG);
        allPredicates.add(ageOver21);
        List<Person> allPersons2 = personLinkedList.stream()
                        .filter(allPredicates.stream().reduce(x->true, Predicate::and))
                        .collect(Collectors.toList());
        System.out.println(allPersons2);
        
        
        animals.add("Camel");
        animals.add("Cow");
        List<String> animalsWithC = animals.stream().filter(x -> x.startsWith("C")).collect(Collectors.toList());
        System.out.println("Animals that start with C: " + animalsWithC);

        names.add("Andrei");
        names.add("Robert");
        names.add("Xenia");
        names.add("Matei");
        names.add("Radu");
        Set<String> namesThatEndWithI = names.stream().filter(x -> x.endsWith("i")).collect(Collectors.toSet());
        System.out.println("Names that end with i: " + namesThatEndWithI);

        System.out.println("First name: " + names.stream().findFirst());
        System.out.println("Find any: " + names.stream().findAny());
        System.out.println("Starts with R: " + names.stream().anyMatch(x -> x.startsWith("R")));

        int result = squareNumbers.stream().reduce(0, (x, y) -> x + y % squareNumbers.size());
        System.out.println(result);
        //CSV cu niste date: fiecare beneficiu are o valoare, totalul de platit
        List<Benefit> benefits = new ArrayList<>();
        benefits.add(new Benefit("Netflix", 56, new Person("Gabriela", 23), new Department("Entrainment")));
        benefits.add(new Benefit("Spotify Family", 42, new Person("Gabriela", 23), new Department("Entrainment")));
        benefits.add(new Benefit("HBO from RCS/RDS", 0, new Person("Olivia", 23), new Department("Entrainment")));
        benefits.add(new Benefit("Youtube premium", 45, new Person("Olivia", 23), new Department("Entrainment")));
        
        Map<Object, List<Benefit>> benefitsBasedOnOwner = benefits.stream().collect(Collectors.groupingBy(x -> x.getOwner().getName()));
    
        int sum = benefits.stream().mapToInt(Benefit::getPrice).sum();
        
        Map<String, Integer> personAndBenefitPrice = benefits.stream()
                .collect(Collectors.toMap(Benefit::getOwnerName, Benefit::getPrice, Main::addPrice));
    
        System.out.println("****** +" + personAndBenefitPrice);
        
//        Map<Person, Long> res = benefits.stream().collect(
//                Collectors.groupingBy(Benefit::getOwner, Collectors.collectingAndThen(Collectors.summarizingInt(Benefit::getPrice))));
		
//        int totalToPay = benefits.stream()
//                .reduce(0, (x, y) -> x.getPrice() + y.getPrice())

        Map<Object, Long> groupBy = names.stream().collect(Collectors.groupingBy(x-> x.startsWith("R"), Collectors.counting()));
        System.out.println("GroupBy: " + groupBy);
        //nr beneficitii total/departament
        

        List<String> animalsOrdered = animals.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted list of animals: " + animalsOrdered);

        List<Integer> reversedNumbers = new ArrayList<>(randomNumbers);
        Collections.reverse(reversedNumbers);
        System.out.println("Reversed ordered list of numbers: " + reversedNumbers);
        
        System.out.println("--------------------------------------------------------------------------------------------");
        /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        
        //compare
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Gabriela", 23));
        personArrayList.add(new Person("Gabriel", 55));
        personArrayList.add(new Person("Garofita", 13));
        personArrayList.add(new Person("Tudor", 24));
        Collections.sort(personArrayList, new CompareAge());
        System.out.println("Sorted persons by age: " + personArrayList);

        Collections.sort(personArrayList, new CompareName());
        System.out.println("Sorted persons by name: " + personArrayList);
    }
}
