package de.jaufmann.mosterei.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mosten")
@EntityListeners(AuditingEntityListener.class)
public class Mosten implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @NotNull
  @Column(name = "id", updatable = false, nullable = false)
  private long id;

  @Column(name = "suessmost")
  private Long suessmost;

  @Column(name = "pressen")
  private Long pressen;

  @Column(name = "pressen_separieren")
  private Long pressenSeparieren;

  @Column(name = "flaschen")
  private Long flaschen;

  @Column(name = "bag_in_box_beutel")
  private Long bagInBoxBeutel;

  @Column(name = "bag_in_box_karton")
  private Long bagInBoxKarton;

  @Column(name = "gesamtbetrag")
  private Long gesamtbetrag;

  @Column(name = "created")
  private Date created;

  @Column(name = "betrag_mosten")
  private Long betragMosten;

  @Column(name = "betrag_beutel")
  private Long betragBeutel;

  @Column(name = "status")
  private String status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public Long getSuessmost() {
    return suessmost;
  }

  public void setSuessmost(Long suessmost) {
    this.suessmost = suessmost;
  }


  public Long getPressen() {
    return pressen;
  }

  public void setPressen(Long pressen) {
    this.pressen = pressen;
  }


  public Long getPressenSeparieren() {
    return pressenSeparieren;
  }

  public void setPressenSeparieren(Long pressenSeparieren) {
    this.pressenSeparieren = pressenSeparieren;
  }


  public Long getFlaschen() {
    return flaschen;
  }

  public void setFlaschen(Long flaschen) {
    this.flaschen = flaschen;
  }

  public Long getBagInBoxBeutel() {
    return bagInBoxBeutel;
  }

  public void setBagInBoxBeutel(Long bagInBoxBeutel) {
    this.bagInBoxBeutel = bagInBoxBeutel;
  }


  public Long getBagInBoxKarton() {
    return bagInBoxKarton;
  }

  public void setBagInBoxKarton(Long bagInBoxKarton) {
    this.bagInBoxKarton = bagInBoxKarton;
  }

  public Long getBetragMosten() {
    return betragMosten;
  }

  public void setBetragMosten(Long betragMosten) {
    this.betragMosten = betragMosten;
  }

  public Long getBetragBeutel() {
    return betragBeutel;
  }

  public void setBetragBeutel(Long betragBeutel) {
    this.betragBeutel = betragBeutel;
  }


  public Long getGesamtbetrag() {
    return gesamtbetrag;
  }

  public void setGesamtbetrag(Long gesamtbetrag) {
    this.gesamtbetrag = gesamtbetrag;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
