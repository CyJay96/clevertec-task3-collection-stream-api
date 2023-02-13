package by.voytko.model.task16;

import java.util.List;

public class Performer {

    private Long id;

    private String name;

    private GenreType genre;

    private List<Song> songs;

    public Performer() {
    }

    public Performer(Long id, String name, GenreType genre, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", songs=" + songs +
                '}';
    }
}
