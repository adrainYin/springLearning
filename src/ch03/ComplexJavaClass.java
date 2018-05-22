package ch03;


import org.springframework.beans.factory.annotation.Autowired;

public class ComplexJavaClass {

    private SimpleJavaClass simpleJavaClass;

    @Autowired()
    public ComplexJavaClass(SimpleJavaClass simpleJavaClass){
        this.simpleJavaClass = simpleJavaClass;
    }
}
