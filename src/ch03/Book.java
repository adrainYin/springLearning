package ch03;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
    private Context context;

    @Autowired
    public Book(Context context) {
        this.context = context;
    }
}
