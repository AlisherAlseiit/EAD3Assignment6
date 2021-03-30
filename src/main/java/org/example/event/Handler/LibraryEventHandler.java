package org.example.event.Handler;

import org.example.event.LibraryEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LibraryEventHandler implements ApplicationListener<LibraryEvent> {
    @Override
    public void onApplicationEvent(LibraryEvent libraryEvent) {
        System.out.println("------------------------");
        System.out.println("User with id: " + libraryEvent.getUserId() + "," + libraryEvent.getAction());
    }

}
