package com.example;

import com.example.dto.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        App a = new App();
        a.convertJavaToJson();
          //  a.convertJsonTojava();

    }

    public void convertJavaToJson() throws Exception{

        Customer c= new Customer();
        c.setId(101);
        c.setName("Natha");
        c.setPhno(123456l);

        Customer c2 = new Customer();
        c2.setId(102);
        c2.setName("Babloo");
        c2.setPhno(99231155l);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("customer.json"),Arrays.asList(c,c2));
        mapper.writeValue(System.out, Arrays.asList(c,c2));

        System.out.println("JSON Created..!");
    }

    public void convertJsonTojava() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        Customer [] customers = mapper.readValue(new File("customer.json"),Customer[].class);
        
        for(Customer c : customers){

            System.out.println(c);
        }

    }
}
