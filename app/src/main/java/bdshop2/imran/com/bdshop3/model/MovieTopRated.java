package bdshop2.imran.com.bdshop3.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by imran on 4/19/2017.
 */

public class MovieTopRated {
    @SerializedName("poster_path")
    private String PosterPath;
    @SerializedName("adult")
    private boolean Adult;
    @SerializedName("overview")
    private String Overview;
    @SerializedName("release_date")
    private String ReleaseDate;
    @SerializedName("genre_ids")
    private ArrayList<Integer> genre_ids = new ArrayList<Integer>();
    @SerializedName("id")
    private Integer Id;
    @SerializedName("original_title")
    private String OriginalTitle;
    @SerializedName("original_language")
    private String OriginalLanguage;
    @SerializedName("title")
    private String Title;
    @SerializedName("backdrop_path")
    private String BackdropPath;
    @SerializedName("popularity")
    private double Popularity;
    @SerializedName("vote_count")
    private Integer VoreCount;
    @SerializedName("video")
    private boolean Video;
    @SerializedName("vote_average")
    private double VoteAverage;

    public MovieTopRated(String posterPath, boolean adult, String overview, String releaseDate, ArrayList<Integer> genre_ids, Integer id, String originalTitle, String originalLanguage, String title, String backdropPath, double popularity, Integer voreCount, boolean video, double voteAverage) {
        this.PosterPath = posterPath;
        this.Adult = adult;
        this.Overview = overview;
        this.ReleaseDate = releaseDate;
        this.genre_ids = genre_ids;
        this.Id = id;
        this.OriginalTitle = originalTitle;
        this.OriginalLanguage = originalLanguage;
        this.Title = title;
        this.BackdropPath = backdropPath;
        this.Popularity = popularity;
        this.VoreCount = voreCount;
        this.Video = video;
        this.VoteAverage = voteAverage;
    }

    public MovieTopRated() {

    }

    public String getPosterPath() {
        return PosterPath;
    }

    public void setPosterPath(String posterPath) {
        PosterPath = posterPath;
    }

    public boolean isAdult() {
        return Adult;
    }

    public void setAdult(boolean adult) {
        Adult = adult;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public ArrayList<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(ArrayList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        OriginalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return OriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        OriginalLanguage = originalLanguage;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBackdropPath() {
        return BackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        BackdropPath = backdropPath;
    }

    public double getPopularity() {
        return Popularity;
    }

    public void setPopularity(double popularity) {
        Popularity = popularity;
    }

    public Integer getVoreCount() {
        return VoreCount;
    }

    public void setVoreCount(Integer voreCount) {
        VoreCount = voreCount;
    }

    public boolean isVideo() {
        return Video;
    }

    public void setVideo(boolean video) {
        Video = video;
    }

    public double getVoteAverage() {
        return (int) Math.round(VoteAverage);
    }

    public void setVoteAverage(double voteAverage) {
        this.VoteAverage = voteAverage;
    }


    @Override
    public String toString() {
        return "MovieTopRated{" +
                "PosterPath='" + PosterPath + '\'' +
                ", Adult=" + Adult +
                ", Overview='" + Overview + '\'' +
                ", ReleaseDate='" + ReleaseDate + '\'' +
                ", genre_ids=" + genre_ids +
                ", Id=" + Id +
                ", OriginalTitle='" + OriginalTitle + '\'' +
                ", OriginalLanguage='" + OriginalLanguage + '\'' +
                ", Title='" + Title + '\'' +
                ", BackdropPath='" + BackdropPath + '\'' +
                ", Popularity=" + Popularity +
                ", VoreCount=" + VoreCount +
                ", Video=" + Video +
                ", VoteAverage=" + VoteAverage +
                '}';
    }


}
