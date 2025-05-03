package com.crud.Operations.crud.operation;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	
	@Id

	
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long Product_Id;
    private String Product_Name;
    private String Product_Description;
    private Double Product_Price;
    private Integer Product_Quantity;
    private Double Product_AverageRating;
    private Integer Product_ReviewCount;
    private String Product_ManufacturerName;
    private String Product_WarrantyPeriod;
    private String Product_AvailabilityStatus;
    private String Product_ShippingMethod;
    private Double Product_ShippingCost;
    private Boolean Product_IsShippable;
    private String Product_Condition;

    
   
}
