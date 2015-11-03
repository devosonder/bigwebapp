package org.onderdal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "app_user")
public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_name", unique = true, nullable = false)
    private String loginName;

    @Column(name = "first_name", nullable = false, length = 200)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 200)
    private String lastName;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @Column(name = "role", length = 2000)
    private String role;

    @Column(name = "password_hash", length = 200)
    private String passwordHash;

    @Column(name = "locale")
    private String locale;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "change_password")
    private boolean changePassword = false;

    @Column(name = "failed_logins", nullable = false, length = 1)
    private Integer failedLogins = 0;

    @Column(name = "locked_out_until")
    private ZonedDateTime lockedOutUntil;

    @Column(name = "last_login")
    private ZonedDateTime lastLogin;

    @Column(name = "password_reset_token")
    private String passwordResetToken;

    @Column(name = "password_reset_token_valid_until")
    private ZonedDateTime passwordResetTokenValidUntil;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "auto_open_view")
    private String autoOpenView;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean isChangePassword() {
        return changePassword;
    }

    public void setChangePassword(boolean changePassword) {
        this.changePassword = changePassword;
    }

    public Integer getFailedLogins() {
        return this.failedLogins;
    }

    public void setFailedLogins(Integer failedLogins) {
        this.failedLogins = failedLogins;
    }

    public ZonedDateTime getLockedOutUntil() {
        return this.lockedOutUntil;
    }

    public void setLockedOutUntil(ZonedDateTime lockedOutUntil) {
        this.lockedOutUntil = lockedOutUntil;
    }

    public ZonedDateTime getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(ZonedDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPasswordResetToken() {
        return this.passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public ZonedDateTime getPasswordResetTokenValidUntil() {
        return this.passwordResetTokenValidUntil;
    }

    public void setPasswordResetTokenValidUntil(
            ZonedDateTime passwordResetTokenValidUntil) {
        this.passwordResetTokenValidUntil = passwordResetTokenValidUntil;
    }

    public String getAutoOpenView() {
        return this.autoOpenView;
    }

    public void setAutoOpenView(String autoOpenView) {
        this.autoOpenView = autoOpenView;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
