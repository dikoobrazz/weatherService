package com.app.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="weather")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Weather implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @NotBlank
    private String cityName;

    @Lob
    @Column(name="openWeatherData", columnDefinition="CLOB")
    private String openWeatherData;

    @Lob
    @Column(name="weatherStackData", columnDefinition="CLOB")
    private String weatherStackData;

    public Weather() {
    }

    public Weather(@NotBlank String cityName, String openWeatherData, String weatherStackData) {
        this.cityName = cityName;
        this.openWeatherData = openWeatherData;
        this.weatherStackData = weatherStackData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Transactional
    public String getOpenWeatherData() { return openWeatherData; }

    public void setOpenWeatherData(String openWeatherData) {
        this.openWeatherData = openWeatherData;
    }

    @Transactional
    public String getWeatherStackData() {
        return weatherStackData;
    }

    public void setWeatherStackData(String weatherStackData) {
        this.weatherStackData = weatherStackData;
    }
}
