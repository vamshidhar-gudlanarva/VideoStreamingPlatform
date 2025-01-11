package services;

import model.User;
import model.Video;
import model.WatchList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WatchListServiceImpl implements WatchListService {

    private static Map<User, WatchList> watchListDatabase = new HashMap<>();
    @Override
    public void addVideoToWatchList(WatchList watchList, Video video) {
            if (watchList != null && video != null){
                watchList.getVideos().add(video);
            } else {
                throw new IllegalArgumentException("WatchList is null");
            }

    }

    @Override
    public void removeVideoFromWatchList(WatchList watchList, Video video) {
        if (watchList != null && video != null){
            watchList.getVideos().remove(video);
        }else {
            throw new IllegalArgumentException("WatchList is null");
        }

    }

    @Override
    public List<Video> getWatchListByUser(User user) {
        WatchList watchList = findWatchListByUser(user);
        return watchList.getVideos();
    }

    @Override
    public void clearWatchListByUser(User user) {
        WatchList watchList = findWatchListByUser(user);
        watchList.getVideos().clear();

    }

    @Override
    public void addWatchList(WatchList watchList) {
        if(watchList != null && watchList.getUser() != null){
            watchListDatabase.put(watchList.getUser(), watchList);
        }else {
            throw new IllegalArgumentException("WatchList is null");
        }

    }

    @Override
    public WatchList findWatchListByUser(User user) {
        if(user == null){
            throw new IllegalArgumentException("User is null");
        }
        WatchList watchList = watchListDatabase.get(user);
        if(watchList == null){
            throw new IllegalArgumentException("WatchList is not found for user " + user.getName());
        }
        return watchList;
    }
}
