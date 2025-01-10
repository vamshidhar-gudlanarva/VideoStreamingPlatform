package model;

import java.time.LocalDateTime;
import java.util.Date;

public class Review {
    private long id;
    private User user;
    private Video video;
    private double rating;
    private String comment;
    private LocalDateTime commentDate;

    public Review(Builder builder){
        if (builder.rating < 0 || builder.rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        this.id = builder.id != 0 ? builder.id : System.currentTimeMillis();
        this.user = builder.user;
        this.video = builder.video;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.commentDate = builder.commentDate != null ? builder.commentDate : LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Video getVideo() {
        return video;
    }

    public User getUser() {
        return user;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;
        return id == review.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }


    public static class Builder {
        private long id;
        private User user;
        private Video video;
        private double rating;
        private String comment;
        private LocalDateTime commentDate;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setVideo(Video video) {
            this.video = video;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setCommentDate(LocalDateTime commentDate) {
            this.commentDate = commentDate;
            return this;
        }
        public Review build(){
            if (user == null || video == null || rating < 0 ||rating >0 || comment == null || commentDate == null || comment.isEmpty()) {
                throw new IllegalArgumentException("You must provide a valid review");
            }
            return new Review(this);
        }
    }
}
