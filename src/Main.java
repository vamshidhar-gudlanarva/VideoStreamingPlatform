import model.Genre;
import model.User;
import model.Video;
import model.WatchList;
import services.WatchListService;
import services.WatchListServiceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user = new User.Builder()
                .setEmail("vamshidha@gmail.com")
                .setName("vamshidhar")
                .setPassword("secure")
                .build();


        Video video1 = new Video.Builder()
                .setTitle("video1")
                .setId(101)
                .setDescription("Description1")
                .setGenre(Genre.ADVENTURE)
                .setDuration("1Hr")
                .build();

        Video video2 = new Video.Builder()
                .setId(102)
                .setTitle("video2")
                .setDescription("Description2")
                .setGenre(Genre.ACTION)
                .setDuration("3hr")
                .build();

        WatchList watchList1 = new WatchList.Builder()
                .setUser(user)
                .setVideos(List.of(video1,video2))
                .build();

        WatchListService watchListService = new WatchListServiceImpl();

        watchListService.addWatchList(watchList1);


        Video video3 = new Video.Builder()
                .setId(103)
                .setTitle("video3")
                .setDescription("Description3")
                .setGenre(Genre.COMEDY)
                .setDuration("2hr")
                .build();

        Video video4 = new Video.Builder()
                .setId(104)
                .setDuration("3hr")
                .setTitle("video4")
                .setDescription("royal")
                .setGenre(Genre.FANTASY)
                .build();

        watchListService.addVideoToWatchList(watchList1, video3);
//        watchListService.addVideoToWatchList(watchList1,video4);

        List<Video> watchListVideos = watchListService.getWatchListByUser(user);
        watchListVideos.forEach(video -> System.out.println(video.getTitle()));

        System.out.println("here");

      watchListService.addVideoToWatchList(watchList1,video4);

        //watchListVideos.forEach(video -> System.out.println(video.getTitle()));


        watchListService.removeVideoFromWatchList(watchList1,video2);

        System.out.println("After removal:");

        watchListVideos = watchListService.getWatchListByUser(user);
        watchListVideos.forEach(video -> System.out.println(video.getTitle()));


        watchListService.clearWatchListByUser(user);
        System.out.println("Watchlist cleared.");

    }
}