package com.company;

import java.util.Comparator;

public class CompareAge implements Comparator<Person> {
    
    @Override
    public int compare(Person o1, Person o2) {
        
        if (o1.getAge() == null && o2.getAge() != null)
            return -1;
        else if (o1.getAge() != null && o2.getAge() == null)
            return 1;
        return o1.age - o2.age;
    }
}
