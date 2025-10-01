package br.dev.norn.event_flow.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("events")
public class EventController {

    public RequestEntity<?> request;
    public EventController(RequestEntity<?> request) {}
}
