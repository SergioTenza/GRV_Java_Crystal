package com.crystalprinter.grv.Controllers;

import com.crystalprinter.grv.Services.exporterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class reportController {
    //@Autowired
    //exporterService exporterService;

    @GetMapping()
    public String getReportAsString(){
        return "De momento nada Amijo";
    }

    @PostMapping()
    public String createReport(){
        return "";
    }

}
