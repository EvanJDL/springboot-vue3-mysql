package Evan.demo.utils;

public class Claims {
    private Integer id;
    private String username;

    public Claims() {}

    public Claims(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
