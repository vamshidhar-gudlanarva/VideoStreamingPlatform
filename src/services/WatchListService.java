package services;

import model.User;
import model.Video;
import model.WatchList;

import java.util.List;

public interface WatchListService {
    public void addVideoToWatchList(WatchList watchList, Video video);

    public void removeVideoFromWatchList(WatchList watchList, Video video);

    List<Video> getWatchListByUser(User user);

    public void clearWatchListByUser(User user);

    public void addWatchList(WatchList watchList);

    WatchList findWatchListByUser(User user);


}
