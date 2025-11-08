package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "book_location")
public class BookLocation {
    @Id
    @Column(name = "barcode")
    private String barcode;

    @JoinColumn(name = "book_id", nullable = false)
    private int bookId;

    private String branch;

    private String floor;

    @Column(name = "shelf_no")
    private String shelfNo;

    @Column(name = "cell_no")
    private String cellNo;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('在馆','借出','丢失') DEFAULT '在馆'")
    private LocationStatus status;

    private BigDecimal price;

    @Column(name = "damage_note")
    private String damageNote;

    @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    public void setStatus(LocationStatus status) {
        this.status = status;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDamageNote(String damageNote) {
        this.damageNote = damageNote;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setBook(int bookId) {
        this.bookId = bookId;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBranch() {
        return branch;
    }

    public String getFloor() {
        return floor;
    }

    public String getShelfNo() {
        return shelfNo;
    }

    public String getCellNo() {
        return cellNo;
    }

    public LocationStatus getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDamageNote() {
        return damageNote;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public enum LocationStatus {
        在馆, 借出, 丢失
    }
}