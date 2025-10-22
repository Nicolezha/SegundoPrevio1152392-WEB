package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "inventory_items")
public class InventoryItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ClothingCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "section")
    private Section section;

    @Column(name = "description")
    private String description;

    @ElementCollection // Indica que es una colección de elementos básicos o embebibles (no entidades)
    @CollectionTable(name = "inventory_item_images", // Define la tabla auxiliar donde se almacenarán los elementos de la colección
                     joinColumns = @JoinColumn(name = "inventory_item_id"))
    @Column(name = "image")
    private List<String> image;

    @Column(name = "material")
    private String material;

    @Column(name = "care_instructions")
    private String careInstructions;

    @ElementCollection(targetClass = Size.class)
    @CollectionTable(name = "inventory_item_sizes",
                     joinColumns = @JoinColumn(name = "inventory_item_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "available_sizes")
    private List<Size> availableSizes;
    
    @ElementCollection
    @CollectionTable(name = "inventory_item_colors",
                     joinColumns = @JoinColumn(name = "inventory_item_id"))
    @Column(name = "available_colors")
    private List<String> availableColors;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "new_item")
    private boolean newItem;

    @OneToMany(mappedBy = "inventoryItem", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products;

}
