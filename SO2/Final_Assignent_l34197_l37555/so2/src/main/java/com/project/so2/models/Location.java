package com.project.so2.models;

import com.vividsolutions.jts.geom.Point;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "Location")
@Table(name = "location")
@SequenceGenerator(name = "location_id")

public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_id")
    @Column(name = "id")
    private long id;
    
    @Column(name = "location", columnDefinition = "POINT")
    private Point location; 
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;

    public Location() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
    
    
}
