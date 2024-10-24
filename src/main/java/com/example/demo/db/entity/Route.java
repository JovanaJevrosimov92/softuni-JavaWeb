package com.example.demo.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column(columnDefinition = "MEDIUMTEXT",name = "gpx_coordinates",nullable = false)
    private String gpxCoordinates;

    @Column(name = "level",nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false)
    private String name;

    @Column(name = "video_url")
    private String videoURL;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comments>comments;

    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pictures>pictures;

    @ManyToMany
    @JoinTable(name = "routes_categories",joinColumns = @JoinColumn(name = "route_entity_id"),inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private List<Categories>categories;

}

