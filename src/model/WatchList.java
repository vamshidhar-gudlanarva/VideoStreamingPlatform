package model;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WatchList {
    private long id;
    private User user;
    private List<Video> videos;
    private LocalDateTime addedAt;

    private WatchList(Builder builder){
        this.id = builder.id  != 0 ? builder.id : System.currentTimeMillis();
        this.user = builder.user;
        this.videos = builder.videos != null ?   new ArrayList<>(builder.videos) : new ArrayList<>();
        this.addedAt = builder.addedAt != null ? builder.addedAt : LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    @Override
    public String toString() {
        return "WatchList{" +
                "id=" + id +
                ", user=" + user +
                ", videos=" + videos +
                ", addedAt=" + addedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WatchList watchList = (WatchList) o;
        return id == watchList.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }


    public static class Builder {
        private long id;
        private User user;
        private List<Video> videos;
        private LocalDateTime addedAt;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setVideos(List<Video> videos) {
            this.videos = videos;
            return this;
        }

        public Builder setAddedAt(LocalDateTime addedAt) {
            this.addedAt = addedAt;
            return this;
        }

        public WatchList build() {
            if (user == null) {
                throw new IllegalStateException("User must be provided.");
            }
            return new WatchList(this);
        }
    }
}
