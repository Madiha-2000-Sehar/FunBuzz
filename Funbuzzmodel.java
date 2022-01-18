package com.example.miniproject_funbuzz;

public class Funbuzzmodel {
    private String username;
    private String password;
    private int score;

    public Funbuzzmodel(String username, String password, int score) {
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Funbuzzmodel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
