package com.homeservices.WiFiScanner.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class NetworkUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Network network;

    @ManyToOne
    private User user;

    private LocalDateTime createdAt;


    public NetworkUser(){}

    public NetworkUser(Network network, User user){
        this.network = network;
        this.user = user;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getJoinedAt() {
        return createdAt;
    }

    public void setJoinedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
