//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.30 at 01:52:53 PM MSK 
//


package glim.antony.soapexample.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usersList" type="{http://www.soapexample.antony.glim/util}usersList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usersList"
})
@XmlRootElement(name = "getUsersListResponse")
public class GetUsersListResponse {

    @XmlElement(required = true)
    protected UsersList usersList;

    /**
     * Gets the value of the usersList property.
     * 
     * @return
     *     possible object is
     *     {@link UsersList }
     *     
     */
    public UsersList getUsersList() {
        return usersList;
    }

    /**
     * Sets the value of the usersList property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsersList }
     *     
     */
    public void setUsersList(UsersList value) {
        this.usersList = value;
    }

}