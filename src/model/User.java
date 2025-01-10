package model;

import java.lang.module.ModuleDescriptor;
import java.time.LocalDateTime;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private Subscription subscription;
    private LocalDateTime registeredDate;
    private boolean isActive;

   private String hashPassword(String password){
       return password;
   }

   private User(Builder builder){
       this.id = builder.id;
       this.name = builder.name;
       this.email = builder.email;
       this.password = builder.password;
       this.subscription = builder.subscription;
       this.registeredDate = builder.registeredDate;
       this.isActive = builder.isActive;
       this.hashPassword(builder.password);
   }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public static class Builder{
        private UUID id;
        private String name;
        private String email;
        private String password;
        private Subscription subscription;
        private LocalDateTime registeredDate;
        private boolean isActive = true;

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setSubscription(Subscription subscription) {
            this.subscription = subscription;
            return this;
        }

        public Builder setRegisteredDate(LocalDateTime registeredDate) {
            this.registeredDate = registeredDate;
            return this;
        }

        public Builder setActive(boolean active) {
            isActive = active;
            return this;
        }
        public User build(){
            if(name == null || email == null || password == null){
                throw new IllegalArgumentException("Name and email and password are required");
            }
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subscription=" + subscription +
                ", registeredDate=" + registeredDate +
                ", isActive=" + isActive +
                '}';
    }
}
