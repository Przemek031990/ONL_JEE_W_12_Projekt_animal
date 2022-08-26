package pl.coderslab.animalclub.domain.animal.dto;

public class AnimalDto {
    private Long id;
    private String name;
    private Integer age;
    private Integer weight;
    private String description;
    private String genre;
    private boolean promoted;
    private String photo;
    private double avgRating;
    private int ratingCount;


    public AnimalDto(Long id,
                     String name,
                     Integer age,
                     Integer weight,
                     String description,
                     String genre,
                     boolean promoted,
                     String photo,
                     Double avgRating,
                     int ratingCount) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.description = description;
        this.genre = genre;
        this.promoted = promoted;
        this.photo = photo;
        this.avgRating = avgRating;
        this.ratingCount = ratingCount;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }
}
