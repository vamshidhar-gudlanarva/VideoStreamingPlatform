package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Video {
    private long id;
    private String title;
    private String description;
    private LocalDateTime uploadDate;
    private Genre genre;
    private String duration;

    private Video(Builder builder){
        this.id = builder.id != 0 ? builder.id : UUID.randomUUID().getMostSignificantBits();
        this.title = builder.title;
        this.description = builder.description;
        this.uploadDate = builder.uploadDate  != null ? builder.uploadDate : LocalDateTime.now();
        this.genre = builder.genre;
        this.duration = builder.duration;


    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", uploadDate=" + uploadDate +
                ", genre=" + genre +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;
        return Objects.equals(getId(), video.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }


    public static class Builder{
        private long id;
        private String title;
        private String description;
        private LocalDateTime uploadDate;
        private Genre genre;
        private String duration;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setGenre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder setUploadDate(LocalDateTime uploadDate) {
            this.uploadDate = uploadDate;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }
        public Video build(){
            if(title == null || description == null || genre == null || duration == null){
                throw new IllegalArgumentException("Title and description are required");
            }
            return new Video(this);
        }
    }
}
