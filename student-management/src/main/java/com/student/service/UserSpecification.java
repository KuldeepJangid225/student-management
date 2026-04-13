package com.student.service;


import com.student.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> filterUsers(
            String name,
            String email,
            String role,
            Boolean active
    ) {
        return (root, query, cb) -> {

            var predicate = cb.conjunction();

            // Filter by name (LIKE)
            if (name != null && !name.isEmpty()) {
                predicate.getExpressions().add(
                        cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%")
                );
            }

            // Filter by email (exact match)
            if (email != null && !email.isEmpty()) {
                predicate.getExpressions().add(
                        cb.equal(cb.lower(root.get("email")), email.toLowerCase())
                );
            }

            // Filter by role
            if (role != null && !role.isEmpty()) {
                predicate.getExpressions().add(
                        cb.equal(root.get("role"), role)
                );
            }

            // Filter by active (true/false)
            if (active != null) {
                predicate.getExpressions().add(
                        cb.equal(root.get("active"), active)
                );
            }

            return predicate;
        };
    }
}