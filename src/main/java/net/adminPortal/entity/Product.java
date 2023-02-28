package net.adminPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
public class Product {
	@Id
	@Column(name = "productId")
    private Long productId;

    @Column(name = "productname")
    private String productName;

    @Column(name = "reportid")
    private Long REPORTID;
    
    @Column(name = "PRICE")
    private String price;
    
    @Column(name = "QUANTITY")
    private String quantity;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getREPORTID() {
		return REPORTID;
	}

	public void setREPORTID(Long rEPORTID) {
		REPORTID = rEPORTID;
	}

    

   
}
