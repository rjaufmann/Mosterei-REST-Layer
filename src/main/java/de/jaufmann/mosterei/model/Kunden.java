package de.jaufmann.mosterei.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "kunden")
@EntityListeners(AuditingEntityListener.class)
public class Kunden  implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID", updatable = false, nullable = false)
  private long id;

  @Column(name = "ROLE")
  private long role;

  @Column(name = "EMAIL")
  private String email;

  @NotNull
  @Column(name = "NAME", nullable = false)
  private String name;

  @NotNull
  @Column(name = "FULL_NAME", nullable = false)
  private String fullName;

  @Column(name = "CREATED_ON")
  private Date createdOn;

  @Column(name = "PHONE")
  private String phone;

  @Column(name = "MOBILE")
  private String mobile;

  @Column(name = "ADDRESS")
  private String address;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
