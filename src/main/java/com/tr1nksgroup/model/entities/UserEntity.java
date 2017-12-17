package com.tr1nksgroup.model.entities;

import com.tr1nksgroup.model.entities.enums.SiteRolesEnum;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity extends AbstrEntity {
    @Basic
    @Column(name = "email", length = 256, unique = true, nullable = false)
    private String email;
    @Basic
    @Column(name = "password", length = 60, nullable = false)
    private String password;
    @Basic
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private SiteRolesEnum role;
    @Basic
    @Column(name = "enabled", nullable = false, columnDefinition = "bit(1) default false")
    private boolean enabled;
    @Basic
    @Column(name = "name", length = 40, nullable = false)
    private String name;
    @Basic
    @Column(name = "surname", length = 50)
    private String surname;
    @Basic
    @Column(name = "uuid")
    private UUID userUUID;
    @OneToMany(mappedBy = "userEntity")
    List<WorkSessionEntity> workSessionEntities;

    private UserEntity() {
    }

    //region get-set
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SiteRolesEnum getRole() {
        return role;
    }

    public void setRole(SiteRolesEnum role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UUID getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(UUID userUUID) {
        this.userUUID = userUUID;
    }

    public List<WorkSessionEntity> getWorkSessionEntities() {
        return workSessionEntities;
    }

    public void setWorkSessionEntities(List<WorkSessionEntity> workSessionEntities) {
        this.workSessionEntities = workSessionEntities;
    }
    //endregion
}
