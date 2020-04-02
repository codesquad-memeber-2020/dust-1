package com.codesquad.team1.dust.domain;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Forecast {

    private String informOverall;
    private String informGrade;
    private List<Image> images;

    public Forecast(JsonNode forecastObject) {
        this.informOverall = forecastObject.get("informOverall").asText();
        this.informGrade = forecastObject.get("informGrade").asText();
        this.images = parseImages(forecastObject);
    }

    public Forecast(String informOverall, String informGrade, List<Image> images) {
        this.informOverall = informOverall;
        this.informGrade = informGrade;
        this.images = images;
    }

    private List<Image> parseImages(JsonNode forecastObject) {
        List<Image> images = new ArrayList<>();

        images.add(new Image(forecastObject.get("imageUrl1").asText()));
        images.add(new Image(forecastObject.get("imageUrl2").asText()));
        images.add(new Image(forecastObject.get("imageUrl3").asText()));

        return images;
    }

    public String getInformOverall() {
        return informOverall;
    }

    public void setInformOverall(String informOverall) {
        this.informOverall = informOverall;
    }

    public String getInformGrade() {
        return informGrade;
    }

    public void setInformGrade(String informGrade) {
        this.informGrade = informGrade;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Forecast{" + "informOverall='" + informOverall + '\'' + ", informGrade='" + informGrade + '\'' + ", images=" + images + '}';
    }
}
