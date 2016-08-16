
package fooddata.adapter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für product complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="item_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="brand_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nf_calories" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="nf_serving_size_qty" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="nf_serving_size_unit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nf_serving_weight_grams" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product")
public class Product {

    @XmlAttribute(name = "item_name")
    protected String itemName;
    @XmlAttribute(name = "brand_name")
    protected String brandName;
    @XmlAttribute(name = "nf_calories")
    protected Double nfCalories;
    @XmlAttribute(name = "nf_serving_size_qty")
    protected Double nfServingSizeQty;
    @XmlAttribute(name = "nf_serving_size_unit")
    protected String nfServingSizeUnit;
    @XmlAttribute(name = "nf_serving_weight_grams")
    protected Integer nfServingWeightGrams;

    /**
     * Ruft den Wert der itemName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Legt den Wert der itemName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * Ruft den Wert der brandName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Legt den Wert der brandName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandName(String value) {
        this.brandName = value;
    }

    /**
     * Ruft den Wert der nfCalories-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNfCalories() {
        return nfCalories;
    }

    /**
     * Legt den Wert der nfCalories-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNfCalories(Double value) {
        this.nfCalories = value;
    }

    /**
     * Ruft den Wert der nfServingSizeQty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNfServingSizeQty() {
        return nfServingSizeQty;
    }

    /**
     * Legt den Wert der nfServingSizeQty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNfServingSizeQty(Double value) {
        this.nfServingSizeQty = value;
    }

    /**
     * Ruft den Wert der nfServingSizeUnit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNfServingSizeUnit() {
        return nfServingSizeUnit;
    }

    /**
     * Legt den Wert der nfServingSizeUnit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNfServingSizeUnit(String value) {
        this.nfServingSizeUnit = value;
    }

    /**
     * Ruft den Wert der nfServingWeightGrams-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNfServingWeightGrams() {
        return nfServingWeightGrams;
    }

    /**
     * Legt den Wert der nfServingWeightGrams-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNfServingWeightGrams(Integer value) {
        this.nfServingWeightGrams = value;
    }

}
