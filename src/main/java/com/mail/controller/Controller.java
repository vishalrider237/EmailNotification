package com.mail.controller;


import com.mail.dto.IssuerEmaildto;
import com.mail.service.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class Controller {
    @Autowired
    private PermitService permitService;
    @PostMapping("/send/approve")
    public String sendEmailApprove(@RequestParam("email") String email) throws IOException, MessagingException {
        IssuerEmaildto issuerEmail=new IssuerEmaildto();
        issuerEmail.setPlant("4322");
        issuerEmail.setPermit_Number("cwp20231000001");
        issuerEmail.setCreated_by("AkashRaj Bhatt");
        issuerEmail.setPermit_startDate(1698746534);
        issuerEmail.setPermit_endDate(1698746236);
        issuerEmail.setStatus("Approved");
        issuerEmail.setPermit_type("Plant A");
        this.permitService.approvePermit(email,issuerEmail);
    return "Issues Approved Successfully";
    }

}
