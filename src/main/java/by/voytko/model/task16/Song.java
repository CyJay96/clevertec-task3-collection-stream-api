package by.voytko.model.task16;

import java.time.LocalDate;

public class Song {

    private Long id;

    private String title;

    private String performer;

    private String album;

    private int likesCount;

    private LocalDate releaseDate;

    public Song() {
    }

    public Song(Long id, String title, String performer, String album, int likesCount, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.performer = performer;
        this.album = album;
        this.likesCount = likesCount;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", performer='" + performer + '\'' +
                ", album='" + album + '\'' +
                ", likesCount=" + likesCount +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
