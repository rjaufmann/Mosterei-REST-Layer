package de.jaufmann.mosterei.model;

import de.jaufmann.mosterei.util.AbfuellungConverter;
import de.jaufmann.mosterei.util.SaftartConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;


@Entity
@Table(name = "Anmeldungen")
@EntityListeners(AuditingEntityListener.class)
public class Anmeldungen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @NotNull
    @Column(name = "beginn", nullable = false)
    private Date beginn;

    @NotNull
    @Column(name = "finish", nullable = false)
    private Date finish;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_on")
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

    @NotEmpty
    @Column(name = "SAFTART")
    @Convert(converter = SaftartConverter.class)
    private String[] saftart;

    @NotEmpty
    @Column(name = "ABFUELLUNG")
    @Convert(converter = AbfuellungConverter.class)
    private String[] abfuellung;

    @Column(name = "MITGLIED")
    private String mitglied;

    @Column(name = "BEMERKUNG")
    private String bemerkung;

    @Column(name = "mosten_id")
    private Long mostenId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBeginn() {
        return beginn;
    }

    public void setBeginn(Date beginn) {
        this.beginn = beginn;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String[] getSaftart() {
        return saftart;
    }

    public void setSaftart(String[] saftart) {
        this.saftart = saftart;
    }

    public String[] getAbfuellung() {

        if (Arrays.asList(saftart).contains("SM")) {
            return abfuellung;
        }
        else {
            String[] stringArray = new String[1];
            stringArray[0] = "-";
            return stringArray;
        }
    }

    public void setAbfuellung(String[] abfuellung) {
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


    public Long getMostenId() {
        return mostenId;
    }

    public void setMostenId(Long mostenId) {
        this.mostenId = mostenId;
    }
}
