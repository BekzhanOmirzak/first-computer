package springbootfirtst.springbootfistproject.util;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;


@Service
public class EmailValidator implements Predicate<String> {


    @Override
    public boolean test(String s) {
        //todo use regex to validate the email;
        return true;
    }


}
