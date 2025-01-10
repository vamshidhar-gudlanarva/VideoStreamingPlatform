package model;

import java.security.Timestamp;
import java.util.List;

public class History {
    private long id;
    private User user;
    private List<Video> videos;
    private Timestamp watchedAt;
}
