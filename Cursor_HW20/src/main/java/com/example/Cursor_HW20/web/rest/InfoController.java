package com.example.Cursor_HW20.web.rest;

import com.example.Cursor_HW20.entity.Info;
import com.example.Cursor_HW20.services.InfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping
    public ResponseEntity<List<Info>> getAllInfo() {
        return new ResponseEntity<>(infoService.getAllInfo(), HttpStatus.OK);
    }

}
