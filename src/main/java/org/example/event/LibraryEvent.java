package org.example.event;

import org.springframework.context.ApplicationEvent;

public class LibraryEvent extends ApplicationEvent {
    private Long userId;
    private String action;

    public LibraryEvent(Object source, Long userId, String action) {
        super(source);
        this.userId = userId;
        this.action = action;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }
}
