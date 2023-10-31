package com.mail.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class IssuerEmaildto {
  private String plant;
  private String permit_Number;
  private String permit_type;
  private String status;
  private long permit_startDate;
  private long permit_endDate;
  private String created_by;
}
