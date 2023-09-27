package com.example.Cursor_HW20.services.impl;

import com.example.Cursor_HW20.entity.Info;
import com.example.Cursor_HW20.repository.InfoRepository;
import com.example.Cursor_HW20.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public List<Info> getAllInfo() {
        return infoRepository.findAll();
    }

}
