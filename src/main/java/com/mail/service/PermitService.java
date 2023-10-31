package com.mail.service;



import com.mail.dto.IssuerEmaildto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class PermitService {
    @Autowired
    private EmailService emailService;
    public void approvePermit(String email, IssuerEmaildto issuer) throws IOException, MessagingException {
        // Your logic here
        Timestamp createsdon=new Timestamp(System.currentTimeMillis());
        Timestamp permitstart=new Timestamp(issuer.getPermit_startDate());
        Timestamp permitend= new Timestamp(issuer.getPermit_endDate());
        // Send email notification
        String subject = "Permit Approved";
      //  String body = "Hi permit issuer, Your permit has been approved. table: plant,permit number, permit type, status, created on, created by|| thanks regards, ";
        String body="Dear permit issuer"+"<br/>"
              +"<br/>" + "The below notification has been submitted and waiting for your ATTENTION.Please click here the "+"<a href='www.cherrywork.com'>link</a> "+
                "to view the same"+"<br/>"
               +"<br/>" +"<head><title>Permit Table</title></head>"
                +"<table border='1'>"+
                "<thead>"+
                "<tr>"+
                "<th>Plant</th>"+
                "<th>Permit Number</th>"+
                "<th>Permit Type</th>"+
                "<th>Status</th>"+
                "<th>Permit StartDate</th>"+
                "<th>Permit EndDate</th>"+
                "<th>Created On</th>"+
                "<th>Created By"+
                "</tr>"+
                "</thead>"+
                "<tbody>"+
                "<tr>"+
                "<td><b>"+issuer.getPlant()+"</b></td>"+
                "<td><b>"+issuer.getPermit_Number()+"<b></td>"+
                "<td><b>"+issuer.getPermit_type()+"<b></td>"+
                "<td><b>"+issuer.getStatus()+"<b></td>"+
                "<td><b>"+permitstart.toString()+"<b></td>"+
                "<td><b>"+permitend.toString()+"<b></td>"+
                "<td><b>"+createsdon.toString()+"</b></td>"+
                "<td><b>"+issuer.getCreated_by()+"</b></td>"+
                "</tr>"+
                "</tbody>"+
                "</thead>"+
                "<tbody>"+
                "<tr>"+
                "</tbody>"+
                "</table>"+"<br/>"
                +"<b>Thanks & Regard</b>"+"<br/>"
                +"<b>IMO P2W</b>"
                ;

        emailService.sendEmail( subject,body, email);
    }
}
