package com.tejlearning.springFramework.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String publisherName;
    private String Address;
    private String City;
    private String state;
    private String zip;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;



    @Override
    public String toString() {
        return "Publisher{" +
                "publisherID=" + ID +
                ", publisherName='" + publisherName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (!Objects.equals(publisherName, publisher.publisherName))
            return false;
        if (!Objects.equals(Address, publisher.Address)) return false;
        if (!Objects.equals(City, publisher.City)) return false;
        if (!Objects.equals(state, publisher.state)) return false;
        return Objects.equals(zip, publisher.zip);
    }

    @Override
    public int hashCode() {
        int result = publisherName != null ? publisherName.hashCode() : 0;
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (City != null ? City.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        return result;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
