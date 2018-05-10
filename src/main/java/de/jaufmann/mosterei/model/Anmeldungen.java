package de.jaufmann.mosterei.model;

import de.jaufmann.mosterei.util.LocalISO8601TimestampAttributeConverter;
import de.jaufmann.mosterei.util.LocalTimestampAttributeConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "Anmeldungen")
@EntityListeners(AuditingEntityListener.class)
public class Anmeldungen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotBlank
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @NotBlank
    @Column(name = "beginn", nullable = false)
    @Convert(converter = LocalTimestampAttributeConverter.class)
    private Timestamp beginn;

    @NotBlank
    @Column(name = "finish", nullable = false)
    @Convert(converter = LocalTimestampAttributeConverter.class)
    private Timestamp finish;

    @Column(name = "created_on")
    @Convert(converter = LocalISO8601TimestampAttributeConverter.class)
    private Timestamp createdOn;

    @NotBlank
    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_on")
    @Convert(converter = LocalISO8601TimestampAttributeConverter.class)
    private Timestamp updatedOn;

    @Column(name = "status_message")
    private String statusMessage;

    @NotBlank
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mobile")
    private String mobile;

    @NotBlank
    @Column(name = "angemeldete_menge")
    private String angemeldeteMenge;

    @NotBlank
    @Column(name = "SAFTART")
    private String saftart;

    @NotBlank
    @Column(name = "ABFUELLUNG")
    private String abfuellung;

    @Column(name = "MITGLIED")
    private String mitglied;

    @Column(name = "BEMERKUNG")
    private String bemerkung;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getBeginn() {
        return beginn;
    }

    public void setBeginn(Timestamp beginn) {
        this.beginn = beginn;
    }

    public Timestamp getFinish() {
        return finish;
    }

    public void setFinish(Timestamp finish) {
        this.finish = finish;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAngemeldeteMenge() {
        return angemeldeteMenge;
    }

    public void setAngemeldeteMenge(String angemeldeteMenge) {
        this.angemeldeteMenge = angemeldeteMenge;
    }

    public String getSaftart() {
        return saftart;
    }

    public void setSaftart(String saftart) {
        this.saftart = saftart;
    }

    public String getAbfuellung() {
        return abfuellung;
    }

    public void setAbfuellung(String abfuellung) {
        this.abfuellung = abfuellung;
    }

    public String getMitglied() {
        return mitglied;
    }

    public void setMitglied(String mitglied) {
        this.mitglied = mitglied;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

}