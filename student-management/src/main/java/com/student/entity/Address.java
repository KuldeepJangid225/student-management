package com.student.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Primary address
    @NotBlank(message = "Address Line 1 is required")
    @Column(nullable = false)
    private String addressLine1;

    // Optional
    private String addressLine2;

    // Required fields
    @NotBlank(message = "City is required")
    @Column(nullable = false)
    private String city;

    @NotBlank(message = "State is required")
    @Column(nullable = false)
    private String state;

    // Default = India
    @Column(nullable = false)
    private String country = "India";

    // Exactly 6 digits
    @NotBlank(message = "PinCode is required")
    @Pattern(regexp = "\\d{6}", message = "PinCode must be exactly 6 digits")
    @Column(nullable = false, length = 6)
    private String pinCode;

    // Relationship with User
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}